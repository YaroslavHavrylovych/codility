import java.util.ArrayList;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/numbers-of-length-n-and-value-less-than-k/
 */
public class Solution {
    public int solve(ArrayList<Integer> A, int B, int C) {
        if (A == null || A.isEmpty()) return 0;
        if (B > Integer.toString(C).length()) return 0;
        int power = (int) Math.pow(10, B - 1);
        int res = 0;
        int i = 1;
        while (power > 0) {
            int c = C / power;
            C = C % power;
            int amountBefore = (int) A.stream().filter(v -> v < c).count();
            if (i == 1 && B != 1 && A.get(0) == 0) amountBefore--;
            res += (amountBefore * Math.pow(A.size(), B - i));
            if (!A.contains(c)) break;
            power /= 10;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{0, 1, 5});
        System.out.println(sl.solve(a, 1, 2));
        arrToList(a, new int[]{0, 1, 2, 5});
        System.out.println(sl.solve(a, 2, 21));
        arrToList(a, new int[]{2, 9});
        System.out.println(sl.solve(a, 5, 17015));
        arrToList(a, new int[]{0, 2, 3, 4, 5, 7, 8, 9});
        System.out.println(sl.solve(a, 5, 86587));
        arrToList(a, new int[]{0, 2, 3, 4, 5, 7, 8, 9});
        System.out.println(sl.solve(a, 9, 86587));
        arrToList(a, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(sl.solve(a, 5, 10004));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
