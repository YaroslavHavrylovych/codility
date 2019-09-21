import java.util.Arrays;

public class Solution {
    public int[][] generateMatrix(int A) {
        //create matrix
        int[][] res = new int[A][];
        for (int i = 0; i < res.length; i++) {
            res[i] = new int[A];
        }
        //
        int start = 0, end = A - 1;
        int count = 1;
        for (int o = 0; o < (A + 1) / 2; o++) {
            for (int j = start; j <= end; j++) {
                res[start][j] = count++;
            }
            for (int i = start + 1; i <= end; i++) {
                res[i][end] = count++;
            }
            for (int j = end - 1; j >= start; j--) {
                res[end][j] = count++;
            }
            for (int i = end - 1; i > start; i--) {
                res[i][start] = count++;
            }
            start += 1;
            end -= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] res = sl.generateMatrix(2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
