import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/rearrange-array/
 */
public class Solution {
    public void arrange(ArrayList<Integer> a) {
        int N = a.size();
        for (int i = 0; i < a.size(); i++) {
            int v = a.get(i);
            int t = a.get(v);
            if (t >= N) {
                t = t % N;
            }
            a.set(i, v + N * t);
        }
        for (int i = 0; i < a.size(); i++) {
            int v = a.get(i);
            a.set(i, v / N);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 0});
        sl.arrange(a);
        System.out.println(Arrays.toString(a.toArray()));
        arrToList(a, new int[]{1, 3, 2, 0});
        sl.arrange(a);
        System.out.println(Arrays.toString(a.toArray()));
        arrToList(a, new int[]{1, 2, 7, 0, 9, 3, 6, 8, 5, 4});
        sl.arrange(a);
        System.out.println(Arrays.toString(a.toArray()));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

