/*
 * Check README to find the description.
 * <br/>
 * Each step we can move down or right. So starting from the top left cell
 * we're moving line horizontal and line vertical and calculate max
 * value for each cell. Storing previous result in the same array
 * and repeating this until reach the last element of an array.
 */
public class HighestRouteValue {
    public int findMaxRoute(int[][] route) {
        return findMaxRoute(route, 0, 0, route.length - 1, 
                route[0].length - 1);
    }
    
    private int findMaxRoute(int[][] route, int x, int y, int n, int m) {
        for(int i = x; i <= n; i++) route[i][y] += getMax(route, i, y);
        for(int j = y + 1; j <= m; j++) route[x][j] += getMax(route, x, j);
        if(x == n || y == m) return route[n][m];
        return findMaxRoute(route, x + 1, y + 1, n, m);
    }

    private int getMax(int[][] route, int x, int y) {
        if(x == 0 && y == 0) return 0;
        if(x == 0) return route[x][y - 1];
        if(y == 0) return route[x - 1][y];
        return Math.max(route[x - 1][y], route[x][y - 1]);
    }

    private static String toString(int[][] array) {
        int n = array.length - 1;
        StringBuilder res = new StringBuilder("{");
        for(int i = 0; i <= n; i++)
            res.append(java.util.Arrays.toString(array[i])).append("\n");
        res.append("}");
        return res.toString();
    }

    public static void main(String[] args) {
        int[][] route = new int[][] {{1, 2, 3}, {6, 9, 11}, 
            {8, 10, 7}, {4, 9, 5}, {10, 8, 3}};
        System.out.println("Array: \n" + toString(route));
        System.out.println("Max apples: " + 
                new HighestRouteValue().findMaxRoute(route));
    }
}
