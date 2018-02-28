import java.io.IOException;
import java.nio.file.Files;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class FileChecker {
    public void readPizzaFile(String fileName) throws IOException {
        List<String> content = Files.lines(Paths.get(fileName))
            .collect(Collectors.toList());
        int slicesAmount = Integer.parseInt(content.remove(0));
        assert(content.size() == slicesAmount);
        Set<SlicePoint> stPt = new HashSet<>();
        for(int i = 0; i < slicesAmount; i++)
            for(SlicePoint pt: parsePoints(content.get(i))) {
                if(stPt.contains(pt)) {
                    System.out.println("Point " + pt + "is in reuse by slice "
                            + content.get(i));
                    return;
                }
                stPt.add(pt);
            }
        System.out.println("All slices are valid");
        System.out.println("Scores: " + stPt.size());
    }

    private class SlicePoint {
        private int maxOfAbsAndOrd = 1001;
        private int x;
        private int y;

        private SlicePoint(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(x * maxOfAbsAndOrd + y);
        }

        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof SlicePoint)) return false;
            SlicePoint pt = (SlicePoint) obj;
            return pt.x == x && pt.y == y;
        }

        @Override
        public String toString() {
            return "[" + x + "," + y + "]";
        }
    }

    public List<SlicePoint> parsePoints(String square) {
        String[] splitted = square.split(" ");
        int x1 = Integer.parseInt(splitted[0]);
        int y1 = Integer.parseInt(splitted[1]);
        int x2 = Integer.parseInt(splitted[2]);
        int y2 = Integer.parseInt(splitted[3]);
        int dX = x2 - x1 + 1;
        int dY = y2 - y1 + 1;
        List<SlicePoint> pts = new ArrayList<>(dX * dY);
        for(int i = x1; i <= x2; i++)
            for(int j = y1; j  <= y2; j++)
                pts.add(new SlicePoint(i, j));
        return pts;
    }

    public static void main(String[] args) throws IOException {
        if(args.length == 0) {
            System.out.println("You need to pass file name to verify or");
            return;
        }
        String arg = args[0];
        if(arg.endsWith(".out")) {
            new FileChecker().readPizzaFile(arg);
            return;
        }
        File out = new File(arg + ".out");
        if(!out.exists() || out.isDirectory()) {
            System.out.println("File '" + out.getName() 
                    + "' doesn't exist, or it's a directory");
        }
        File in = new File(arg + ".in");
        if(!out.exists() || out.isDirectory()) {
            System.out.println("File '" + in.getName() 
                    + "' doesn't exist, or it's a directory");
        }
        PizzaReader pr = new PizzaReader();
        pr.readPizzaFile(arg + ".in");
        new FileChecker().checkCut(pr, arg + ".out");
    }

    public void checkCut(PizzaReader pr, String fileName) throws IOException {
        boolean[][] resultSlices = new boolean[pr.getR()][pr.getC()];
        List<String> content = Files.lines(Paths.get(fileName))
            .collect(Collectors.toList());
        int slicesAmount = Integer.parseInt(content.remove(0));
        assert(content.size() == slicesAmount);
        int score = 0;
        for(int ind = 0; ind < slicesAmount; ind++) {
            String[] splitted = content.get(ind).split(" ");
            int x1 = Integer.parseInt(splitted[0]);
            int y1 = Integer.parseInt(splitted[1]);
            int x2 = Integer.parseInt(splitted[2]);
            int y2 = Integer.parseInt(splitted[3]);
            int dX = x2 - x1 + 1;
            int dY = y2 - y1 + 1;
            int t = 0, m = 0;
            int amount = 0;
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j  <= y2; j++) {
                    if(resultSlices[i][j]) {
                        System.out.println("Slice " + content.get(ind) 
                                + " intersects with other slice");
                        return;
                    } else {
                        if(pr.getPizza()[i][j] == 'T') t++;
                        else m++;
                        resultSlices[i][j] = true;
                        amount++;
                    }
                }
            }
            if(amount > pr.getH() || t < pr.getL() || m < pr.getL()) {
                System.out.println("Slice " + content.get(ind) 
                                + " doesn't have enough"
                                + " tomatoes or mushrooms or too big");
                return;
            }
            score += amount;
        }
        System.out.println("All slices are valid");
        System.out.println("Scores: " + score);
    }
}
