/**
 * Given an array nums and a value val,
 * remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this 
 * by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 *
 * @link https://leetcode.com/problems/remove-element/
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int i = 0;
        int j = nums.length - 1;
        do {
            while(i < nums.length && nums[i] != val) i++;
            while(j >= 0 && nums[j] == val) j--;
            if(i < j && i < nums.length && j >= 0 && nums[i] == val && nums[j] != val) {
                nums[i++] = nums[j];
                nums[j--] = val;
            }
        } while(i <= j);
        return j + 1;
    }
}

