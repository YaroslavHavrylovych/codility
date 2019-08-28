import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/sorted-permutation-rank/
 */
public class Solution {
    public int findRank(String A) {
        if (A == null || A.length() < 1) return 0;
        List<Character> alphabet = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            alphabet.add(A.charAt(i));
        }
        Collections.sort(alphabet);
        BigInteger res = BigInteger.ZERO;
        int n = A.length();
        for (int i = 0; i < A.length(); i++) {
            int posInAlph = alphabet.indexOf(A.charAt(i));
            alphabet.remove(posInAlph);
            res = res.add(BigInteger.valueOf(posInAlph).multiply(fact(n - i - 1)));
        }
        return res.add(BigInteger.ONE).mod(BigInteger.valueOf(1000003)).intValue();
    }

    public BigInteger fact(int number) {
        BigInteger fact = BigInteger.ONE;
        for (int i = 1; i <= number; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.findRank("cab"));
        System.out.println(sl.findRank("DTNGJPURFHYEW"));
        System.out.println(sl.findRank("ZCSFLVHXRYJQKWABGT"));
    }
}
