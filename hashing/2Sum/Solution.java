import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.interviewbit.com/problems/2-sum/
 */
public class Solution {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        if (A.size() < 2) return res;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            Integer val = A.get(i);
            List<Integer> pos = map.getOrDefault(val, new ArrayList<>());
            pos.add(i);
            List<Integer> pos1 = map.get(B - val);
            if (pos1 != null) {
                res.add(pos1.stream().min(Integer::compareTo).get() + 1);
                res.add(i + 1);
                return res;
            }
            map.putIfAbsent(A.get(i), pos);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 2, 2, 7, 7, 11, 15});
        System.out.println(sl.twoSum(a, 9));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}


