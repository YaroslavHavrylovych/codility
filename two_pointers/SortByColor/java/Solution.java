import java.util.ArrayList;

/**
 * Given an array with n objects colored red, white or blue,
 * sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.  
 *
 * Here, we will use the integers 0, 1, and 2 to represent the color red, 
 * white, and blue respectively.  
 * <br/>
 * Note: Using library sort function is not allowed.
 * <br/>
 * https://www.interviewbit.com/problems/sort-by-color/
 */
public class Solution {
    public void sortColors(ArrayList<Integer> a) {
        int r = 0;
        int g = 0;
        int b = 0;
        for (int v : a) {
            if (v == 0) r++;
            else if (v == 1) g++;
            else b++;
        }
        for (int i = 0; i < a.size(); i++) {
            if (i < r) a.set(i, 0);
            else if (i < r + g) a.set(i, 1);
            else a.set(i, 2);
        }
    }
}

