/*
 * https://www.interviewbit.com/problems/min-steps-in-infinite-grid/
 */
public class Solution {
    public int coverPoints(int[] A, int[] B) {
        if (A == null || B == null || A.length != B.length) return 0;
        int steps = 0;
        for (int i = 1; i < A.length; i++) {
            steps += Math.max(Math.abs(A[i - 1] - A[i]), Math.abs(B[i - 1] - B[i]));
        }
        return steps;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int res = sl.coverPoints(new int[] {0, 1, 1}, new int[] {0, 1, 2});
        System.out.println(res == 2 ? "Correct" : "Failure");
    }
}

