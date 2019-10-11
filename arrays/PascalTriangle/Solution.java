import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/pascal-triangle/
 */
public class Solution {
    public int[][] solve(int A) {
        int[][] res = new int[A][];
        for (int i = 0; i < A; i++) {
            res[i] = new int[i + 1];
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    res[i][j] = 1;
                    continue;
                }
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] res = sl.solve(8);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
