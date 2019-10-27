import java.util.ArrayList;

/**
 * Given a sorted array and a target value, return the index if the 
 * target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <br/>
 * https://www.interviewbit.com/problems/sorted-insert-position/
 */
public class Solution {
    public int searchInsert(ArrayList<Integer> a, int b) {
        //set stating and ending index
        int start = 0, end = a.size() - 1;

        while (start <= end) {
            // take mid of the list
            int mid = (start + end) / 2;

            // we found a match
            if (a.get(mid) == b) {
                return mid;
            }
            // go on right side
            else if (a.get(mid) < b) {
                start = mid + 1;
            }
            // go on left side
            else {
                end = mid - 1;
            }
        }
        // element is not present in list
        return start;
    }
}
