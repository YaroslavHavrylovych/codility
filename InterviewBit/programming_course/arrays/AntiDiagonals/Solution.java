import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/anti-diagonals/
 */
public class Solution {
    public int[][] diagonal(int[][] A) {
        int lastEl = A.length - 1;
        int[][] res = new int[lastEl * 2 + 1][];
        for (int ind = 0; ind < res.length; ind++) {
            int i = ind < lastEl ? 0 : ind - lastEl;
            int j = ind < lastEl ? ind : lastEl;
            res[ind] = new int[ind < lastEl ? j + 1 : A.length - i];
            int i1 = 0;
            while (i < A.length && j >= 0) {
                res[ind][i1++] = A[i++][j--];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] A = new int[3][];
        A[0] = new int[]{1, 2, 3};
        A[1] = new int[]{4, 5, 6};
        A[2] = new int[]{7, 8, 9};
        int[][] res = sl.diagonal(A);
        for (int i = 0; i < res.length; i++)
            System.out.println(Arrays.toString(res[i]));
    }
}
