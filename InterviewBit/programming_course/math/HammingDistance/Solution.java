import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/sum-of-pairwise-hamming-distance/
 */
public class Solution {
    public int hammingDistance(final List<Integer> A) {
        int i = 1;
        int max = A.stream().max(Integer::compareTo).get();
        BigInteger res = BigInteger.ZERO;
        while (i <= max) {
            int zeros = 0;
            int ones = 0;
            for (int a : A) {
                if ((a & i) > 0) ones++;
                else zeros++;
            }
            BigInteger tmp = BigInteger
                    .valueOf(2)
                    .multiply(BigInteger.valueOf(zeros))
                    .multiply(BigInteger.valueOf(ones));
            res = res.add(tmp);
            i <<= 1;
        }
        return res.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        arrToList(row, new int[]{2, 4, 5, 6});
        System.out.println(sl.hammingDistance(row));
        arrToList(row, new int[]{0, 1, 1, 1});
        System.out.println(sl.hammingDistance(row));
        arrToList(row, new int[]{2, 4, 6});
        System.out.println(sl.hammingDistance(row));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

