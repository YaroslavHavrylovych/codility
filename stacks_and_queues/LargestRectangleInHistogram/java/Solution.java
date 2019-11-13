import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * Given an array of integers A of size N. 
 * A represents a histogram i.e A[i] denotes height of 
 * the ith histogram’s bar. Width of each bar is 1.
 * <br/>
 * Input Format:
 * The only argument given is the integer array A.
 * <br/> 
 * Output Format: 
 * Return the area of largest rectangle in the histogram.
 * <br/>
 * https://www.interviewbit.com/problems/largest-rectangle-in-histogram/
 */
public class Solution {
    public int largestRectangleArea(ArrayList<Integer> A) {
        if (A.isEmpty()) return 0;
        Deque<Integer> deque = new ArrayDeque<>(A.size());
        //left[i] - amount of elements to the left, which higher that ours
        int[] left = new int[A.size()];
        deque.push(0);
        for (int i = 1; i < A.size(); i++) {
            int val = A.get(i);
            while (!deque.isEmpty() && val <= A.get(deque.peek())) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                deque.push(i);
                left[i] = i;
            } else {
                left[i] = i - deque.peek() - 1;
                deque.push(i);
            }
        }
        //right[i] - amount of elements to the right, which higher that ours
        int[] right = new int[A.size()];
        deque.clear();
        deque.push(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            int val = A.get(i);
            while (!deque.isEmpty() && val <= A.get(deque.peek())) {
                deque.pop();
            }
            if (deque.isEmpty()) {
                deque.push(i);
                right[i] = A.size() - i - 1;
            } else {
                right[i] = deque.peek() - i - 1;
                deque.push(i);
            }
        }
        //searching for the max size
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            maxSize = Math.max(maxSize, (left[i] + right[i] + 1) * A.get(i));
        }
        return maxSize;
    }
}


