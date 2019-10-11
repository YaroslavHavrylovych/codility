import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/sorted-permutation-rank-with-repeats/
 * <br/>
 * Originally the task solved with a small hint:
 * <br/>
 * (1/A) % MOD = A ^ (MOD - 2) % MOD
 * <br/>
 * I didn't use that + we can use array instead of hashmap, as we know the 
 * maximum factorial we will use.
 */
public class Solution {
    public int findRank(String A) {
        List<Character> letters = A.chars().mapToObj(v -> (char) v).distinct().sorted().collect(Collectors.toList());
        ArrayList<Integer> repetitions = new ArrayList<>();
        for (int i = 0; i < letters.size(); i++) repetitions.add(0);
        for (int i = 0; i < A.length(); i++) {
            int pos = letters.indexOf(A.charAt(i));
            repetitions.set(pos, repetitions.get(pos) + 1);
        }
        BigInteger res = BigInteger.ONE;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int pos = letters.indexOf(ch);
            //amount of permutations we had
            BigInteger nextVal = BigInteger.ZERO;
            //sum of permutations for each letter as first
            for (int p = 0; p < pos; p++) {
                BigInteger permPerVal = factorial(A.length() - i - 1);
                for (int p1 = 0; p1 < repetitions.size(); p1++) {
                    if (p == p1) {
                        permPerVal = permPerVal.divide(factorial(repetitions.get(p1) - 1));
                    } else {
                        permPerVal = permPerVal.divide(factorial(repetitions.get(p1)));
                    }
                }
                nextVal = nextVal.add(permPerVal);
            }
            res = res.add(nextVal);
            repetitions.set(pos, repetitions.get(pos) - 1);
            if (repetitions.get(pos) == 0) {
                repetitions.remove(pos);
                letters.remove(pos);
            }
        }
        return res.mod(BigInteger.valueOf(1000003)).intValue();
    }

    Map<Integer, BigInteger> mem = new HashMap<Integer, BigInteger>() {
        {
            put(2, BigInteger.valueOf(2));
            put(1, BigInteger.ONE);
            put(0, BigInteger.ONE);
        }
    };

    public BigInteger factorial(int val) {
        BigInteger m = mem.get(val);
        if (m != null) return m;
        BigInteger res = BigInteger.ONE;
        for (int i = val; i >= 2; i--) {
            m = mem.get(i);
            if (m != null) break;
        }
        for (int i = m.intValue(); i <= val; i++) {
            res = res.multiply(BigInteger.valueOf(i));
            m = mem.get(val);
            if (m == null) mem.put(val, m);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.findRank("bbbcccaaa"));
        System.out.println(sl.findRank("bbbbaaaa"));
        System.out.println(sl.findRank("abaaabbb"));
        System.out.println(sl.findRank("dabbb"));
        System.out.println(sl.findRank("aabb"));
        System.out.println(sl.findRank("aba"));
        System.out.println(sl.findRank("acb"));
        System.out.println(sl.findRank("baabd"));
    }
}
