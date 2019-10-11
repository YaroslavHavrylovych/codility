import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/max-non-negative-subarray/
 */
public class Solution {
    public int[] maxset(int[] A) {
        int maxLength = 0, maxStartInd = -1;
        int currentLength = 0, currStartInd = -1;
        long currentSum = 0, maxSum = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                currentLength = 0;
                currentSum = 0;
                currStartInd = -1;
            } else {
                if (currStartInd == -1) {
                    currStartInd = i;
                }
                currentLength += 1;
                currentSum += A[i];
            }
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxLength = currentLength;
                maxStartInd = currStartInd;
            } else if (currentSum == maxSum) {
                if (currentLength > maxLength) {
                    maxSum = currentSum;
                    maxLength = currentLength;
                    maxStartInd = currStartInd;
                }
            }
        }
        if (maxStartInd == -1) {
            return new int[0];
        }
        return Arrays.copyOfRange(A, maxStartInd, maxStartInd + maxLength);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.maxset(new int[]{1967513926, 1540383426, -1303455736, -521595368})));
        System.out.println(Arrays.toString(sl.maxset(new int[]{1, 2, 3, 4, -7, 1, 10})));
        System.out.println(Arrays.toString(sl.maxset(new int[]{-7, 1, 8, -5, 0, 2, 3, 4,})));
        System.out.println(Arrays.toString(sl.maxset(new int[]{1, 2, 3, 4, -7, 1, 9})));
        System.out.println(Arrays.toString(sl.maxset(new int[]{1, 2, 3, 4, -7, 1, 1, 2, 2, 5})));
    }
}
