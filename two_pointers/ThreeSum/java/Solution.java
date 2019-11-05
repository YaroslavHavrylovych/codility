import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given an array S of n integers, find three integers in S 
 * such that the sum is closest to a given number, target.
 * Return the sum of the three integers. 
 * Assume that there will only be one solution
 * <br/>
 * https://www.interviewbit.com/problems/3-sum/
 */
public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        if (A.size() < 3) return -1;
        Collections.sort(A);
        int minSum = Integer.MAX_VALUE;
        int res = -1;
        for (int i = 0; i < A.size() - 2; i++) {
            int min = valuedSum(B - A.get(i), i + 1, A);
            int tmp = A.get(i) + min;
            if (minSum > Math.abs(B - tmp)) {
                minSum = Math.abs(B - tmp);
                res = tmp;
                if (minSum == 0) return res;
            }
        }
        return res;
    }

    private int valuedSum(int sum, int start, List<Integer> a) {
        int j = a.size() - 1;
        int minSum = Integer.MAX_VALUE;
        int res = -1;
        int i = start;
        while (i < j) {
            int val = a.get(i) + a.get(j) - sum;
            if (minSum > Math.abs(val)) {
                minSum = Math.abs(val);
                res = a.get(i) + a.get(j);
                if (minSum == 0) return res;
            }
            if (val < 0) i++;
            else j--;
        }
        return res;
    }
}
