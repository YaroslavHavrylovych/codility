/*
 * https://www.interviewbit.com/problems/largest-coprime-divisor/
 * <br/>
 * NOTE: there is another solution, much faster.
 * Lets write A as multiplication of prime factor: p1^x1*p2^x2...
 * Do the same for B: q1^y1*q2^y2...
 * The X we're searching for is value of A which lack of
 * common multipliers.
 * Why A, because the greates divisor of A is A. And if GCD(B,A) == 1 then
 * A is our value.
 * <br/>
 * How we can remove those common multipliers? Just dividing A, each time,
 * by GCD(A,B).
 */
public class Solution {
    public int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    public int cpFact(int A, int B) {
        if (GCD(B, A) == 1) return A;
        int max = 1;
        for (int i = (int) Math.sqrt(A); i > 1; i--) {
            if ((A % i == 0)) {
                int tmp = (A / i);
                if (GCD(B, tmp) == 1) {
                    if (tmp > max) max = tmp;
                } else if (GCD(B, i) == 1) {
                    if (i > max) max = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.cpFact(30, 12));
        System.out.println(sl.cpFact(2, 3));
        System.out.println(sl.cpFact(100, 26));
    }
}
