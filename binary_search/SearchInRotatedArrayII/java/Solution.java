/**
 * Suppose an array sorted in ascending order is rotated at some pivot
 * unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search.
 * If found in the array return true, otherwise return false.
 * <br />
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class Solution {
    public boolean search(int[] nums, int target) {
        return pivotedSearch(nums, target, 0, nums.length - 1);
    }
    
    private boolean pivotedSearch(int[] nums, int target, int li, int ri) {
        if(li > ri) return false;
        int mi = (li + ri) / 2;
        if(nums[mi] == target) return true;
        if(nums[li] < nums[ri]) {
            if(nums[mi] < target) return pivotedSearch(nums, target, 
                    mi + 1, ri);
            else return pivotedSearch(nums, target, li, mi - 1);
        } else {
            //nums[li] >= nums[ri] - this means that pivot is somewhere there
            return pivotedSearch(nums, target, li, mi - 1) 
                || pivotedSearch(nums, target, mi + 1, ri);
        }
    }
}
