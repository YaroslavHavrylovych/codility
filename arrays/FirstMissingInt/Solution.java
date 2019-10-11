import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/first-missing-integer/
 */
public class Solution {
    public int firstMissingPositive(ArrayList<Integer> A) {
        int firstPos = -1;
        int positiveAmount = 0;
        int maxVal = A.get(0);
        int v;
        for (int i = 0; i < A.size(); i++) {
            v = A.get(i);
            if (v >= 1) {
                positiveAmount++;
                if (v == 1) {
                    firstPos = 1;
                }
            }
            if (v > maxVal) {
                maxVal = v;
            }
        }
        if (firstPos == -1) return 1;
        if (positiveAmount == 1) return 2;
        int[] checker = new int[Math.min(positiveAmount, maxVal)];
        for (int i = 0; i < A.size(); i++) {
            v = A.get(i);
            if (v > 0 && v <= checker.length) {
                checker[v - 1] = v;
            }
        }
        for (int i = 1; i < checker.length; i++) {
            if (checker[i] <= 0) return i + 1;
        }
        return checker.length + 1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<ArrayList<Integer>> lst = new ArrayList<>();
        ArrayList<Integer> row = new ArrayList<>();
        arrToList(row, new int[]{-7, -8, -3});
        System.out.println(sl.firstMissingPositive(row));
        arrToList(row, new int[]{1, 2, 0});
        System.out.println(sl.firstMissingPositive(row));
        arrToList(row, new int[]{-1, 1, 0, 78, 3, 5, 2});
        System.out.println(sl.firstMissingPositive(row));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }
}

