/**
 * Give a N*N square matrix, return an array of its anti-diagonals.
 * <br />
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
}
