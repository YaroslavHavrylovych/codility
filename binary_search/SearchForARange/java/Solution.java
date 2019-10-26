import java.util.List;
import java.util.ArrayList;

/**
 * Given a sorted array of integers, find the starting 
 * and ending position of a given target value.  
 * Your algorithm’s runtime complexity must be in the order of O(log n).  
 * If the target is not found in the array, return [-1, -1].
 * <br/>
 * https://www.interviewbit.com/problems/search-for-a-range/
 */
public class Solution {
     private int leftBound(final List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b && (mid == 0 || a.get(mid - 1) != b)) return mid;
            if (a.get(mid) < b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int rightBound(final List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b && (mid == a.size() - 1 || a.get(mid + 1) != b)) return mid;
            if (a.get(mid) <= b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();
        int leftBound = leftBound(a, b);
        int rightBound = rightBound(a, b);
        res.add(leftBound);
        res.add(rightBound);
        return res;
    }
}
