import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/kth-permutation-sequence/
 */
public class Solution {
    public String getPermutation(int A, int B) {
        B--;
        if (A <= 0 || B < 0) return "";
        List<Integer> alphabet = new ArrayList<>(A);
        for (int i = 1; i <= A; i++) alphabet.add(i);
        StringBuilder res = new StringBuilder();
        while (!alphabet.isEmpty()) {
            BigInteger fact = fact(alphabet.size() - 1);
            if (fact.compareTo(BigInteger.valueOf(B)) > 0) {
                res.append(alphabet.remove(0));
            } else {
                int div = BigInteger.valueOf(B).divide(fact).intValue();
                B = B - div * fact.intValue();
                res.append(alphabet.remove(div));
            }
        }
        return res.toString();
    }

    private Map<Integer, BigInteger> factMap 
        = new HashMap<Integer, BigInteger>() {{
        put(0, BigInteger.ONE);
        put(1, BigInteger.ONE);
    }};

    private BigInteger fact(Integer n) {
        if (factMap.containsKey(n)) return factMap.get(n);
        BigInteger val = BigInteger.valueOf(n).multiply(fact(n - 1));
        factMap.put(n, val);
        return val;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.getPermutation(11, 2));
    }
}


