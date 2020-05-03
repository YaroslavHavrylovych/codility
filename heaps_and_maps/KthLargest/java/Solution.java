import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Design a class to find the k-th largest element in a stream.
 * Note that it is the kth largest element in the sorted order,
 * not the k-th distinct element.
 *
 * Your KthLargest class will have a constructor which accepts
 * an integer k and an integer array nums, which contains initial elements
 * from the stream. For each call to the method KthLargest.add, 
 * return the element representing the kth largest element in the stream.
 * <br />
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class Solution {
    Queue<Integer> q;
    int k;
    
    public Solution(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<Integer>(Math.max(k + 1, nums.length));
        q.addAll(Arrays.stream(nums).mapToObj(Integer::valueOf)
                 .collect(Collectors.toList()));
        while(q.size() > k) q.poll();
    }
    
    public int add(int val) {
        q.offer(val);
        while(q.size() > k) q.poll();
        return q.peek();
    }
}
