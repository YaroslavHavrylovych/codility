/**
 * Given a sorted array nums, remove the duplicates in-place such 
 * that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must 
 * do this by modifying the input array in-place with O(1) extra memory.
 * Clarification:
 * Confused why the returned value is an integer but your answer is an array?
 * Note that the input array is passed in by reference, which means 
 * a modification to the input array will be known to the caller as well.
 * Internally you can think of this:
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 * 
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, 
 * //it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 * <br/>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
class Solution {
    fun removeDuplicates(a: IntArray): Int {
        var i = 0
        var j = 1
        while(j < a.size) {
            if(a[i] != a[j]) {
                if(i + 1 != j) a[i + 1] = a[j]
                i += 1
            }
            j += 1
        }
        return i + 1
    }
}

fun main() {
    println("Remove Duplicates from Sorted Array: test is not implemented")
} 
