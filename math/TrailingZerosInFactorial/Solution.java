/*
 * https://www.interviewbit.com/problems/trailing-zeros-in-factorial/
 */
public class Solution {
    public int trailingZeroes(int A) {
        int divider = 5;
        int res = 0;
        while (A / divider >= 1) {
            res += (A / divider);
            divider *= 5;
        }
        return res;
    }
    
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.trailingZeroes(9247));
    }
}
