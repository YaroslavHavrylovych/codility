import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/nextgreater/
 */
public class Solution {
    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        if (A.isEmpty()) return new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>(A);
        for (int i = A.size() - 1; i >= 0; i--) {
            int val = A.get(i);
            while (!stack.isEmpty() && val >= stack.peek()) stack.pop();
            if (stack.isEmpty()) res.set(i, -1);
            else res.set(i, stack.peek());
            stack.push(val);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{4, 5, 2, 10});
        System.out.println(Arrays.toString(sl.nextGreater(a).toArray()));
        arrToList(a, new int[]{3, 2, 1});
        System.out.println(Arrays.toString(sl.nextGreater(a).toArray()));
        arrToList(a, new int[]{3});
        System.out.println(Arrays.toString(sl.nextGreater(a).toArray()));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}


