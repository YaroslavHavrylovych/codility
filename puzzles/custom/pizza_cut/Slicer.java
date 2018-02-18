import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.ArrayList;

public class Slicer {
    final char TOMATO = 'T';
    final char MUSHROOM = 'M';

    public List<int[]> runSlicer(char[][] pizza, int l, int h, int r, int c) {
        int[][][] slicerTmp = new int[r][][];
        for(int i = 0; i < r; i++) slicerTmp[i] = new int[c][6]; 
        int[] ind = new int[2];
        ind[0] = r - 2;
        ind[1] = c;
        runSlicer(slicerTmp, ind, pizza, l, h);
        System.out.println("Scores: " + slicerTmp[0][0][0]);
        return pizzaToSlicesConvertor(slicerTmp, r, c);
    }

    /** 
     * for sliceTmp. [] - row. [][] - column. 
     * [][][0] - maximum size of current + all previous slices
     * [][][1] - size of the current slice; 
     * [][][2] - end of the row;
     * [][][3] - end of the column;
     * [][][4] - start row of the previous path;
     * [][][5] - start column of the previous path;
     */
    private void runSlicer(int[][][] slicerTmp, int[] ind,
            char[][] pizza, int l, int h) {
        int progress = 0;
        while(ind[0] >= 0 && ind[1] >= 0) {
            for(int i = ind[0]; i < ind[0] + h; i++) {
                for(int j = ind[1]; j < ind[1] + h; j++) {
                    if(i >= pizza.length || j >= pizza[i].length) continue;
                    if(!isValidSlice(pizza, ind[0], i, ind[1], j, h, l)) 
                        continue;
                    int currentMaxC = slicerTmp[ind[0]][ind[1]][0]; 
                    updateMax(slicerTmp, ind[0], ind[1], i, j);
                }
            }
            float currentPr = (ind[1] * 1f) / pizza[0].length * 100f;
            if(progress != (int) currentPr) {
                progress = (int) currentPr;
                System.out.println("Progress " + progress + "%");
            }
            if(ind[0] == 0 && ind[1] == 0) return;
            if(ind[0] == 0) {
                ind[0] = slicerTmp.length;
                ind[1] = ind[1] - 1;
            }
            ind[0] = ind[0] - 1;
        }
    }

    private void updateMax(int[][][] slicerTmp, int i1, int j1,
            int i2, int j2) {
        int width = j2 - j1 + 1;
        int height = i2 - i1 + 1;
        int maxC = 0;
        int maxX = 0;
        int maxY = 0;
        int val = 0;
        //search for the best slice at the moment, with verification that
        //other slices wouldn't be intersect.
        for(int j = j2; j < slicerTmp[0].length; j++) {
            for(int i = 0; i < slicerTmp.length; i++) {
                if(!isSlicesNotIntersect(slicerTmp, j1, i1, width,
                            height, i, j))
                    continue;
                val = slicerTmp[i][j][0];
                if(val > maxC) {
                    maxC = val;
                    maxX = i;
                    maxY = j;
                }
            }
        }
        int c = maxC + width * height;
        int currentMaxC = slicerTmp[i1][j1][0];
        if(c > currentMaxC) {
            slicerTmp[i1][j1][0] = c;
            slicerTmp[i1][j1][1] = (i2 - i1 + 1) * (j2 - j1 + 1);
            slicerTmp[i1][j1][2] = i2;
            slicerTmp[i1][j1][3] = j2;
            slicerTmp[i1][j1][4] = maxX;
            slicerTmp[i1][j1][5] = maxY;
        }
    }

    private boolean isSlicesNotIntersect(int[][][] slicerTmp, int x, int y,
            int width, int height, int i, int j) {
        if(i >= slicerTmp.length || j >= slicerTmp[i].length) return false;
        if(j >= x + width) return true;
        if(j == x + width && i >= y + width) return true;
        if(!isSliceNotIntersect(slicerTmp, x, y, width, height, i, j))
                return false;
        return isSlicesNotIntersect(slicerTmp, x, y, width, height,
                slicerTmp[i][j][3], slicerTmp[i][j][4]);
    }

    private boolean isSliceNotIntersect(int[][][] slicerTmp, int x, int y,
            int width, int height, int i, int j) {
        if(x >= j && y >= i) return false;
        if((j >= x && i >= y) && (j < x + width && i < y + height)) 
            return false;
        if(i < y && j < x + width) {
            return y > i + slicerTmp[i][j][1];
        }
        return true;
    }

    private boolean isValidSlice(char[][] pizza, int i1, int i2, 
            int j1, int j2, int h, int l) {
        int mushroomsAmount = 0;
        int tomotoesAmount = 0;
        if((i2 - i1 + 1) * (j2 - j1 + 1) > h) return false;
        for(int i = i1; i <= i2; i++)
            for(int j = j1; j <= j2; j++) {
                if(pizza[i][j] == TOMATO) tomotoesAmount++;
                else mushroomsAmount++;
            }
        return tomotoesAmount >= l && mushroomsAmount >= l;
    }

    private List<int[]> pizzaToSlicesConvertor(int[][][] pizza, int r, int c) {
        List<int[]> slices = new ArrayList<>();
        int nextI = pizza[0][0][4];
        int nextJ = pizza[0][0][5];
        int currentI = -1;
        int currentJ = -1;
        while(!(currentI == 0 && currentJ == 0)) {
            currentI = currentI == -1 ? 0 : currentI;
            currentJ = currentJ == -1 ? 0 : currentJ;
            int[] slice = new int[4];
            slice[0] = currentI;
            slice[1] = currentJ;
            slice[2] = pizza[currentI][currentJ][2];
            slice[3] = pizza[currentI][currentJ][3];
            slices.add(slice);
            currentI = nextI;
            currentJ = nextJ;
            nextI = pizza[currentI][currentJ][4];
            nextJ = pizza[currentI][currentJ][5];
        }
        return slices;
    }

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("You need to pass file name to verify or");
            return;
        }
        String arg = args[0];
        File file = new File(arg + ".in");
        if(!file.exists() || file.isDirectory()) {
            System.out.println("File '" + arg + "' doesn't exist, or it's a"
                   + " directory");
        }
        PizzaReader pr = new PizzaReader();
        pr.readPizzaFile(arg + ".in");
        List<int[]> slices = new Slicer().runSlicer(pr.getPizza(), pr.getL(),
                pr.getH(), pr.getR(), pr.getC());
        PizzaWriter pw = new PizzaWriter();
        pw.writePizza(arg + ".out", slices);
        System.out.println("Checking result file...");
        new FileChecker().readPizzaFile(arg + ".out");
    }
}
