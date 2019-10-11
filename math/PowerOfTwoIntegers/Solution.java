/*
 * https://www.interviewbit.com/problems/power-of-two-integers/
 */
public class Solution {
    public int isPower(int A) {
        if (A == 1) return 1;
        int res;
        for (int i = 2; i <= Math.sqrt(A); i++) {
            res = 1;
            if (A % i != 0) continue;
            int ai = A / i;
            while (ai > res) res *= i;
            if (ai == res) return 1;
        }
        return 0;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.isPower(26));
    }
}

