public class Slicer {
    final char TOMATO = 'T';
    final char MUSHROOM = 'M';

    public int[][] runSlicer(char[][] pizza, int l, int h) {
        int r = pizza.length;
        int c = pizza[0].length;
        printPizza(pizza, r, c);
        System.out.println();
        int[][][] slicerTmp = new int[r][][];
        for(int i = 0; i < r; i++) slicerTmp[i] = new int[c][2]; 
        int[] ind = new int[2];
        ind[0] = r;
        ind[1] = c;
        runSlicer(slicerTmp, ind, pizza, l, h);
        printMaxSlicerTmp(slicerTmp, r, c);
        return slicerTmp[0];
    }

    private void printPizza(char[][] pizza, int r, int c) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(pizza[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private void printMaxSlicerTmp(int[][][] slicerTmp, int r, int c) {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                System.out.print(slicerTmp[i][j][0] + "\t");
            }
            System.out.println();
        }
    }

    private void runSlicer(int[][][] slicerTmp, int[] ind,
            char[][] pizza, int l, int h) {
        for(int i = ind[0]; i < ind[0] + h; i++) {
            for(int j = ind[1]; j < ind[1] + h; j++) {
                if(i >= pizza.length || j >= pizza[i].length) continue;
                if(!isValidSlice(pizza, ind[0], i, ind[1], j, h, l)) 
                    continue;
                int currentMaxC = slicerTmp[ind[0]][ind[1]][0]; 
                int size = (i - ind[0] + 1) * (j - ind[1] + 1);
                int c = findMaxC(slicerTmp, ind[0], ind[1], i, j);
                if(c > currentMaxC) {
                    slicerTmp[ind[0]][ind[1]][0] = c;
                    slicerTmp[ind[0]][ind[1]][1] = 
                        (i - ind[0] + 1) * (j - ind[1] + 1);
                }
            }
        }
        if(ind[0] == 0 && ind[1] == 0) return;
        if(ind[0] == 0) {
            ind[0] = slicerTmp.length;
            ind[1] = ind[1] - 1;
        }
        ind[0] = ind[0] - 1;
        runSlicer(slicerTmp, ind, pizza, l, h);
    }

    private int findMaxC(int[][][] slicerTmp, int i1, int j1, int i2, int j2) {
        int width = j2 - j1 + 1;
        int height = i2 - i1 + 1;
        int maxC = 0;
        int val = 0;
        for(int j = j2; j < slicerTmp[0].length; j++) {
            for(int i = 0; i < slicerTmp.length; i++) {
                if(!isOuterPassedValue(slicerTmp, j1, i1, width, height, i, j))
                    continue;
                val = slicerTmp[i][j][0];
                if(val > maxC) maxC = val;
            }
        }
        return maxC + width * height;
    }

    private boolean isOuterPassedValue(int[][][] slicerTmp, int x, int y,
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

    public static void main(String[] args) {
        char[][] pizza = new char[][] {
            {'T', 'M', 'M', 'M', 'T', 'T', 'T'},
            {'M', 'M', 'M', 'M', 'T', 'M', 'M'},
            {'T', 'T', 'M', 'T', 'T', 'M', 'T'},
            {'T', 'M', 'M', 'T', 'M', 'M', 'M'},
            {'T', 'T', 'T', 'T', 'T', 'T', 'M'},
            {'T', 'T', 'T', 'T', 'T', 'T', 'M'}
        };
        new Slicer().runSlicer(pizza, 1, 5);
    }
}
