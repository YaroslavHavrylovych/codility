/*
 * https://www.interviewbit.com/problems/max-sum-contiguous-subarray/
 */
public class Solution {
    public int maxSubArray(final int[] A) {
        if (A == null || A.length == 0) return 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            sum += t;
            if (sum < t) {
                sum = t;
            }
            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
