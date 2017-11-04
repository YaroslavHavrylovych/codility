/**
 * Given a matrix of 0 and 1 where:
 * <br/>
 * 0 - water
 * <br/>
 * 1 - ground
 * <br/>
 * Find the longest connected (top, down, left or right) sequence of 1.
 */
public class BiggestIsland {
    private final int water = 0;
    private final int ground = 1;
    private final int visited_ground = 2;
    private final int N = 7;
    private static final int[][] WORLD = new int[][] 
                        {{0, 0, 0, 0, 1, 1, 1, 0},
                         {0, 1, 0, 0, 1, 0, 1, 0},
                         {0, 1, 1, 0, 1, 0, 1, 0},
                         {0, 0, 1, 0, 1, 1, 1, 0},
                         {1, 1, 1, 1, 0, 0, 0, 0},
                         {0, 1, 1, 0, 1, 1, 1, 0},
                         {1, 1, 1, 0, 0, 0, 1, 0}};

    /** 
     * searches for biggest island and return index of the first cell of the
     * island (if count all passed cells).
     */
    public int findBiggestIslandSize(int[][] world) {
        int[][] a = coppyArray(world);
        int biggestIslandSize = 0;
        int currentIslandSize = 0;
        for(int i = 0; i < a.length; i++)
            for(int  j = 0; j < a[i].length; j++) {
                if(a[i][j] == visited_ground) continue;
                if(a[i][j] == water) continue;
                if(a[i][j] == ground) {
                    currentIslandSize = checkIsland(a, i, j);
                    if(currentIslandSize > biggestIslandSize) 
                        biggestIslandSize = currentIslandSize;
                }
            }
        return biggestIslandSize;
    }

    private int[][] coppyArray(int[][] a) {
        int[][] b = new int[a.length][];
        for(int i = 0; i < a.length; i++) {
            b[i] = new int[a[i].length];
            for(int j = 0; j < a[i].length; j++) b[i][j] = a[i][j];
        }
        return b;
    }

    private int checkIsland(int[][] world, int i, int j) {
        if(i < 0 || j < 0 || i >= world.length || j >= world[i].length) 
            return 0;
        if(world[i][j] == water) return 0;
        if(world[i][j] == visited_ground) return 0;
        world[i][j] = visited_ground;
        return 1 
            + checkIsland(world, i + 1, j)
            + checkIsland(world, i, j + 1)
            + checkIsland(world, i - 1, j)
            + checkIsland(world, i, j - 1);
    }

    public static void main(String[] args) {
        System.out.println("biggest island in the world has size " 
                + new BiggestIsland().findBiggestIslandSize(WORLD));
    }
}
