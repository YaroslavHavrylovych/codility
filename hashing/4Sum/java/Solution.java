import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array S of n integers, are there elements 
 * a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * <br/>
 * 1.  Elements in a quadruplet (a,b,c,d) must be in 
 * non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * 2. The solution set must not contain duplicate quadruplets.
 * <br/>
 * https://www.interviewbit.com/problems/4-sum/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (Integer val : A) mp.put(val, mp.getOrDefault(val, 0) + 1);
        List<Integer> vals = new ArrayList<>(mp.keySet());
        vals.sort(Integer::compareTo);
        for (int a = 0; a < vals.size(); a++) {
            int aVal = vals.get(a);
            for (int b = a; b < vals.size(); b++) {
                int bVal = vals.get(b);
                if (a == b && mp.get(bVal) < 2) continue;
                for (int c = b; c < vals.size(); c++) {
                    int cVal = vals.get(c);
                    if (c == b && mp.get(cVal) < 2) continue;
                    if (c == a && c == b && mp.get(cVal) < 3) continue;
                    int dVal = B - aVal - bVal - cVal;
                    if (dVal < cVal) continue;
                    Integer dAmount = mp.get(dVal);
                    if (dAmount == null) continue;
                    if (cVal == dVal && mp.get(dVal) < 2) continue;
                    if (cVal == dVal && c == b && mp.get(dVal) < 3) continue;
                    if (cVal == dVal && c == b && b == a && mp.get(dVal) < 4) continue;
                    ArrayList<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(vals.get(a));
                    tmp.add(vals.get(b));
                    tmp.add(vals.get(c));
                    tmp.add(dVal);
                    res.add(tmp);
                }
            }
        }
        return res;
    }
}
