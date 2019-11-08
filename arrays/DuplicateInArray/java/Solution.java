import java.util.List;

/**
 * Given a read only array of n + 1 integers between 1 and n, 
 * find one number that repeats in linear time using less 
 * than O(n) space and traversing the stream sequentially O(1) times.
 * <br/>
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
}

