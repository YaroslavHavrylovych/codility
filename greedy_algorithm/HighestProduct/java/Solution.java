import java.util.ArrayList;

/**
 * Given an array A, of N integers A.
 * Return the highest product possible by multiplying 3 numbers from the array.
 * NOTE: Solution will fit in a 32-bit signed integer.
 * <br/>
 * https://www.interviewbit.com/problems/highest-product/
 */
public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        if (A.size() <= 3) return A.stream().mapToInt(v -> v).reduce((x, y) -> x * y).orElse(0);
        int[] max = new int[3];
        max[0] = max[1] = max[2] = Integer.MIN_VALUE;
        int[] min = new int[2];
        min[0] = min[1] = Integer.MAX_VALUE;
        for (Integer val : A) {
            if (val >= max[0]) {
                max[2] = max[1];
                max[1] = max[0];
                max[0] = val;
            } else if (val >= max[1]) {
                max[2] = max[1];
                max[1] = val;
            } else if (val >= max[2]) {
                max[2] = val;
            }
            if (val <= min[0]) {
                min[1] = min[0];
                min[0] = val;
            } else if (val <= min[1]) {
                min[1] = val;
            }
        }
        if (max[0] <= 0) return max[0] * max[1] * max[2];
        int minProd = min[0] * min[1];
        int maxProd = max[1] * max[2];
        if (minProd > maxProd) return max[0] * minProd;
        return maxProd * max[0];
    }
}
