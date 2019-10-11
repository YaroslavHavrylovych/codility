import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/kth-smallest-element-in-the-array/
 */
public class Solution {
    public int kthsmallest(final List<Integer> A, int B) {
        if (A.size() < B || B < 0) return 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();
        p.addAll(A);
        for (int i = 0; i < B - 1; i++) p.poll();
        return p.peek();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> A = new ArrayList<>();
        arrToList(A, new int[]{2, 1, 4, 3, 2});
        System.out.println(sl.kthsmallest(A, 3));
        arrToList(A, new int[]{8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92});
        System.out.println(sl.kthsmallest(A, 9));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}

