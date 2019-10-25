import java.util.List;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.  
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).  
 * You are given a target value to search. 
 * If found in the array, return its index, otherwise return -1.  
 * You may assume no duplicate exists in the array.
 * <br/>
 * https://www.interviewbit.com/problems/rotated-sorted-array-search/
 */
public class Solution {
    public int search(final List<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (a.get(mid) == b) return mid;
            int isHereLow = isHere(a, start, mid, b);
            int isHereHigh = isHere(a, mid, end, b);
            if (isHereLow == 1 || (isHereLow == 0 && isHereHigh != 1)) {
                end = mid - 1;
                continue;
            }
            if (isHereHigh != -1) {
                start = mid + 1;
                continue;
            }
            break;
        }
        return -1;
    }

    private int isHere(final List<Integer> a, int start, int end, int b) {
        if (start > end) return -1;
        int stV = a.get(start), enV = a.get(end);
        if (stV < enV) {
            if (b >= stV && b <= enV) {
                return 1;
            }
            return -1;
        }
        return 0;
    }
}

