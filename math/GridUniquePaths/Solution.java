/*
 * https://www.interviewbit.com/problems/grid-unique-paths/
 */
public class Solution {
    public int uniquePaths(int A, int B) {
        if (A < 1 || B < 1) return 0;
        if (A == 1 || B == 1) return 1;
        int[][] path = new int[A][];
        for (int i = 0; i < A; i++) {
            path[i] = new int[B];
        }
        for (int i = 0; i < A; i++) path[i][0] = 1;
        for (int j = 0; j < B; j++) path[0][j] = 1;
        int i = 1;
        int j = 1;
        while (i < A && j < B) {
            i = Math.min(i, A - 1);
            j = Math.min(j, B - 1);
            for (int i1 = i; i1 < A; i1++)
                path[i1][j] = path[i1 - 1][j] + path[i1][j - 1];
            for (int j1 = j; j1 < B; j1++)
                path[i][j1] = path[i - 1][j1] + path[i][j1 - 1];
            if (i < A) i++;
            if (j < B) j++;
        }
        return path[A - 1][B - 1];
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.uniquePaths(15, 9));
        System.out.println(sl.uniquePaths(3, 3));
        System.out.println(sl.uniquePaths(4, 2));
    }
}
