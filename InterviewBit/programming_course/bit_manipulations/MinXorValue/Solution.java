import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/min-xor-value/
 */
public class Solution {
    public int findMinXor(ArrayList<Integer> A) {
        if (A.size() <= 1) return 0;
        List<List<Integer>> bucket = new ArrayList<>();
        bucket.add(A);
        int maxBit = Integer.toBinaryString(
                A.stream().max(Integer::compareTo).get()).length() - 1;
        while (maxBit >= 0) {
            List<List<Integer>> res = new ArrayList<>();
            int mask = 1 << maxBit;
            for (List<Integer> lst : bucket) {
                List<Integer> tmp = lst.stream()
                        .filter(val -> (val & mask) == 0)
                        .collect(Collectors.toList());
                if (tmp.size() > 1) res.add(tmp);
                tmp = lst.stream()
                        .filter(val -> (val & mask) != 0)
                        .collect(Collectors.toList());
                if (tmp.size() > 1) res.add(tmp);
            }
            if (res.size() > 0) bucket = res;
            maxBit--;
        }
        int minXor = Integer.MAX_VALUE;
        for (List<Integer> lst : bucket) {
            int tmp = lst.get(0) ^ lst.get(1);
            if (minXor > tmp) minXor = tmp;
        }
        return minXor;

    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(2);
        a.add(5);
        a.add(7);
        System.out.println(sl.findMinXor(a));
    }
}

