import java.util.List;
import java.util.ArrayList;

/*
 * https://www.interviewbit.com/problems/matrix-median/
 */
public class Solution {
     private int findLessThen(ArrayList<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((a.get(mid) == b && mid == 0) 
                    || (a.get(mid) == b && a.get(mid - 1) != b)) return mid;
            if (a.get(mid) >= b) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    private int findMoreThen(ArrayList<Integer> a, int b) {
        int start = 0, end = a.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if ((a.get(mid) == b && mid == a.size() - 1) 
                    || (a.get(mid) == b && a.get(mid + 1) != b))
                return a.size() - mid - 1;
            if (a.get(mid) <= b) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return a.size() - start;
    }

    public int findAnyValInDiapason(ArrayList<ArrayList<Integer>> a, 
            int low, int high) {
        for (ArrayList<Integer> intList : a) {
            int start = 0, end = intList.size() - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int val = intList.get(mid);
                if (val >= low && val <= high) return val;
                if (val > high) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public int findSmallest(ArrayList<ArrayList<Integer>> a) {
        int smallest = a.get(0).get(0);
        for (int i = 1; i < a.size(); i++) {
            if (smallest > a.get(i).get(0)) smallest = a.get(i).get(0);
        }
        return smallest;
    }

    public int findBiggest(ArrayList<ArrayList<Integer>> a) {
        int biggest = a.get(0).get(a.get(0).size() - 1);
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).get(a.get(i).size() - 1) > biggest) 
                biggest = a.get(i).get(a.get(i).size() - 1);
        }
        return biggest;
    }

    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int lowVal = findSmallest(A), highVal = findBiggest(A);
        int general = A.size() * A.get(0).size();
        int searching = (general + 1) / 2;
        while (lowVal != highVal) {
            int val = findAnyValInDiapason(A, lowVal, highVal);
            int sumS = 0;
            for (ArrayList<Integer> lst : A) {
                sumS += findLessThen(lst, val);
            }
            int sumB = 0;
            for (ArrayList<Integer> lst : A) {
                sumB += findMoreThen(lst, val);
            }
            if (sumS < searching && sumB <= general - searching) return val;
            if (sumS < searching) {
                lowVal = val + 1;
            }
            if (sumB < general - searching) {
                highVal = val - 1;
            }
        }
        return lowVal;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<ArrayList<Integer>> tmp = new ArrayList<>();
        arrToList(a, new int[]{1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3});
        tmp.add(a);
        System.out.println(sl.findMedian(tmp));
        tmp.clear();
        a = new ArrayList<>();
        arrToList(a, new int[]{1, 3, 5});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{2, 6, 9});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{3, 6, 9});
        tmp.add(a);
        System.out.println(sl.findMedian(tmp));
        tmp.clear();
        a = new ArrayList<>();
        arrToList(a, new int[]{1, 8, 8});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{1, 2, 4});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{7, 10, 10});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{4, 5, 7});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{6, 7, 8});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{7, 8, 10});
        tmp.add(a);
        a = new ArrayList<>();
        arrToList(a, new int[]{4, 8, 9});
        tmp.add(a);
        System.out.println(sl.findMedian(tmp));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
