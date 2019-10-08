import java.util.ArrayList;
import java.util.List;

/**
 * https://www.interviewbit.com/problems/median-of-array/
 */
public class Solution {
    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        int generalLength = a.size() + b.size();
        int ind = generalLength / 2;
        if (generalLength % 2 == 1) ind++;
        double val1 = findElementByInd(ind, a, b);
        if (generalLength % 2 == 1) return val1;
        double val2 = findElementByInd(ind + 1, a, b);
        return (val1 + val2) / 2;
    }

    private int findElementByInd(int ind, final List<Integer> a, final List<Integer> b) {
        if (a.isEmpty() && b.isEmpty()) return 0;
        if (a.isEmpty()) return b.get(ind > 1 ? ind - 1 : 0);
        if (b.isEmpty()) return a.get(ind > 1 ? ind - 1 : 0);
        int st1 = 0, e1 = a.size() - 1;
        int st2 = 0, e2 = b.size() - 1;
        while (st1 <= e1) {
            int mid = (st1 + e1) / 2;
            int ins = findInsert(st2, e2, a.get(mid), b);
            if (mid + ins == ind - 1) {
                return a.get(mid);
            }
            if (st1 == e1) break;
            if (mid + ins < ind) {
                st1 = mid + 1;
                if (ins + 1 < e2) st2 = ins;
            } else {
                e1 = mid - 1;
                if (e2 < ins - 1) e2 = ins;
            }
        }
        while (st2 <= e2) {
            int mid = (st2 + e2) / 2;
            int ins = findInsert(st1, e1, b.get(mid), a);
            if (mid + ins == ind - 1) return b.get(mid);
            if (mid + ins < ind) {
                st2 = mid + 1;
            } else {
                e2 = mid - 1;
            }
        }
        return b.get(st2);
    }

    private int findInsert(int st, int end, int el, List<Integer> lst) {
        while (st <= end) {
            int mid = (st + end) / 2;
            if (lst.get(mid) == el) {
                st = mid;
                break;
            }
            if (lst.get(mid) < el) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return st;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{-40, -25, 5, 10, 14, 28, 29, 48});
        ArrayList<Integer> b = new ArrayList<>();
        arrToList(b, new int[]{-48, -31, -15, -6, 1, 8});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{-49, -38, -21, -8, 3, 7, 34, 50});
        b = new ArrayList<>();
        arrToList(b, new int[]{-40, 1});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{-45, -26, 23});
        b = new ArrayList<>();
        arrToList(b, new int[]{-41, -39, -33, -23, 8, 33, 41, 43, 48});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{-37, -9, 10, 19});
        b = new ArrayList<>();
        arrToList(b, new int[]{-29, 18, 46});
        System.out.println(sl.findMedianSortedArrays(a, b));
        a = new ArrayList<>();
        arrToList(a, new int[]{0, 23});
        b = new ArrayList<>();
        arrToList(b, new int[]{});
        System.out.println(sl.findMedianSortedArrays(a, b));
        System.out.println(sl.findMedianSortedArrays(b, a));
        a = new ArrayList<>();
        arrToList(a, new int[]{-50, -41, -40, -19, 5, 21, 28});
        b = new ArrayList<>();
        arrToList(b, new int[]{-50, -21, -10});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{1, 4, 5});
        b = new ArrayList<>();
        arrToList(b, new int[]{2, 3});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{1, 6, 7, 9, 11});
        b = new ArrayList<>();
        arrToList(b, new int[]{2, 3, 4, 5, 8, 10});
        System.out.println(sl.findMedianSortedArrays(a, b));
        arrToList(a, new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 11});
        b = new ArrayList<>();
        arrToList(b, new int[]{10});
        System.out.println(sl.findMedianSortedArrays(a, b));
        System.out.println(sl.findMedianSortedArrays(b, a));
        arrToList(a, new int[]{});
        b = new ArrayList<>();
        arrToList(b, new int[]{20});
        System.out.println(sl.findMedianSortedArrays(a, b));
        System.out.println(sl.findMedianSortedArrays(b, a));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

