import java.util.ArrayList;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/find-duplicate-in-array/
 */
public class Solution {
    public int repeatedNumber(final List<Integer> a) {
        int[] tmp = new int[a.size()];
        for (Integer v : a) {
            if (tmp[v] != 0) return v;
            tmp[v] = 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(3);
        lst.add(4);
        lst.add(1);
        lst.add(4);
        lst.add(1);
        System.out.println(sl.repeatedNumber(lst));
    }
}

