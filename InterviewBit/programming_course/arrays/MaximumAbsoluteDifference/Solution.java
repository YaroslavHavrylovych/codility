/*
 * https://www.interviewbit.com/problems/maximum-absolute-difference/
 */
public class Solution {
    public int maxArr(int[] A) {
        if (A == null || A.length <= 1) return 0;
        int maxPls = Integer.MIN_VALUE, minPls = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE, minMin = Integer.MAX_VALUE;
        for (int i = 0; i < A.length; i++) {
            int min = A[i] - i;
            int pls = A[i] + i;
            if (pls > maxPls) {
                maxPls = pls;
            }
            if (pls < minPls) {
                minPls = pls;
            }
            if (min > maxMin) {
                maxMin = min;
            }
            if (min < minMin) {
                minMin = min;
            }
        }
        return Math.max(maxPls - minPls, maxMin - minMin);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int res = sl.maxArr(new int[] {1, 3, -1});
        System.out.println(res == 5 ? "Correct" : "Failure");
    }
}

