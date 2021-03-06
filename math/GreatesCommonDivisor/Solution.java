/*
 * https://www.interviewbit.com/problems/greatest-common-divisor/
 */
public class Solution {
    public int gcd(int A, int B) {
        if (B == 0) return A;
        return gcd(B, A % B);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.gcd(10, 5));
    }
}
