import java.util.Arrays;

/**
 * Check README to find the description.
 * <br/>
 * Valid only path where length (by x and y) equals to width and
 * height. In other words each step we could move x by 1 or y by 1 and
 * that's it.
 * <br/>
 * We are creating a matrix each cell of which is point which at the
 * graph of roads. So [0,0] represent a point. For each point 
 * we store value from this point to the last one (last one stores 1
 * as there is only one way to the end).
 * <br/>
 * If point stores -1 then we didn't check this way before. If any
 * other value, then this value represents amount of ways to
 * the finish (if 0 then no such way). So if we see anything else
 * than -1, we could skip checking this way and use calculated
 * solution.
 */
public class AvoidRoads {
    public long calculate(int width, int height, String[] avoidStr) {
        long[][] roads = createMoveMatrix(width, height);
        int[][] avoid = parseAvoid(avoidStr);
        calculatePath(0, 0, roads, avoid);
        System.out.println("");
        System.out.println("avoid:");
        printArray(avoid);
        System.out.println("");
        System.out.println("result points matrix:");
        printArray(roads);
        System.out.println("");
        return roads[0][0];
    }

    private void calculatePath(int x, int y, long[][] roads, int[][] avoid) {
        int currentMoves = 0;
        if(checkMove(x, y, x + 1, y, roads, avoid)) {
            if(roads[x + 1][y] == -1) calculatePath(x + 1, y, roads, avoid);
            currentMoves += roads[x + 1][y];
        }
        if(checkMove(x, y, x, y + 1, roads, avoid)) {
            if(roads[x][y + 1] == -1) calculatePath(x, y + 1, roads, avoid);
            currentMoves += roads[x][y + 1];
        }
        roads[x][y] = currentMoves;
    }

    private boolean checkMove(int x1, int y1, int x2, int y2, 
            long[][] roads, int[][] avoid) {
        if(x2 == roads.length || y2 == roads[x2].length) return false;
        for(int i = 0; i < avoid.length; i++)
            if((avoid[i][0] == x1 && avoid[i][1] == y1 
                        && avoid[i][2] == x2 && avoid[i][3] == y2) || 
                (avoid[i][0] == x2 && avoid[i][1] == y2
                 && avoid[i][2] == x1 && avoid[i][3] == y1))
                    return false;
        return true;
    }

    private long[][] createMoveMatrix(int width, int height) {
        long[][] matrix = new long[width + 1][height + 1];
        for(int i = 0; i <= width; i++)
            for(int j = 0; j <= height; j++)
                matrix[i][j] = -1l;
        matrix[width][height] = 1l;
        return matrix;
    }

    private int[][] parseAvoid(String[] avoidStr) {
        int[][] avoidInt = new int[avoidStr.length][];
        for(int i = 0; i < avoidStr.length; i++) {
            String[] parts = avoidStr[i].split(" ");
            avoidInt[i] = new int[] {Integer.parseInt(parts[0]), 
                Integer.parseInt(parts[1]), 
                Integer.parseInt(parts[2]), 
                Integer.parseInt(parts[3])};
        }
        return avoidInt;
    }

    private static void printArray(int[][] array) {
        for(int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
    }

    private static void printArray(long[][] array) {
        for(int i = 0; i < array.length; i++)
            System.out.println(Arrays.toString(array[i]));
    }

    public static void main(String[] args) {
        int width = 6;
        int height = 6;
        String[] avoid = new String[] {"0 0 0 1","6 6 5 6"};
        System.out.println("width = " + width + ", height = " + height +
                ", avoid = " + Arrays.toString(avoid));
        System.out.println("possible ways = " + 
                new AvoidRoads().calculate(width, height, avoid));
    }
}
