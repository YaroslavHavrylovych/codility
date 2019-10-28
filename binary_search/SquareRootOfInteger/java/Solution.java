/**
 * Implement int sqrt(int x).  
 * Compute and return the square root of x.  
 * If x is not a perfect square, return floor(sqrt(x))
 * <br/>
 * https://www.interviewbit.com/problems/square-root-of-integer/
 */
public class Solution {
    public int sqrt(int a) {
        if (a == 1 || a == 2) return 1;
        if (a < 1) return 0;
        long start = 1, end = a;
        while (start <= end) {
            long mid = (start + end) / 2;
            long val = mid * mid;
            if (val <= a && (mid + 1) * (mid + 1) > a) return (int) mid;
            if (val < a) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) start;
    }
}
