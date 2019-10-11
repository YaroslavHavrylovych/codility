import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/next-permutation/
 */
public class Solution {
    public void nextPermutation(ArrayList<Integer> a) {
        //searching the element to swap
        int smallerSwapInd = -1;
        for (int i = a.size() - 1; i > 0; i--) {
            if (a.get(i) > a.get(i - 1)) {
                smallerSwapInd = i - 1;
                break;
            }
        }
        if (smallerSwapInd == -1) {
            sort(a, 0, a.size());
            return;
        }
        int biggerSwapIndex = -1;
        //search for the number to swap
        for (int i = a.size() - 1; i > smallerSwapInd; i--) {
            if (biggerSwapIndex == -1 && a.get(i) > a.get(smallerSwapInd)) {
                biggerSwapIndex = i;
            } else if (a.get(i) > a.get(smallerSwapInd) && a.get(i) < a.get(biggerSwapIndex)) biggerSwapIndex = i;
        }
        int tmp = a.get(smallerSwapInd);
        a.set(smallerSwapInd, a.get(biggerSwapIndex));
        a.set(biggerSwapIndex, tmp);
        sort(a, smallerSwapInd + 1, a.size());
    }

    //insertion sort, without extra space
    private void sort(ArrayList<Integer> a, int startInd, int endInd) {
        for (int c = startInd; c < endInd; c++) {
            int lowInd = c;
            for (int i = c + 1; i < endInd; i++) {
                if (a.get(i) < a.get(lowInd)) {
                    lowInd = i;
                }
            }
            if (c != lowInd) {
                int tmp = a.get(lowInd);
                a.set(lowInd, a.get(c));
                a.set(c, tmp);
            }
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int n = 10;
        ArrayList<Integer> matrix = new ArrayList<>();
        arrToList(matrix, new int[]{1, 2});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{1, 2, 3, 4, 5});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{1, 2, 3, 5, 4});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{2, 4, 6, 10, 8});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{10, 8, 4, 7, 6});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{10, 8, 6, 4, 2});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{10});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{701, 319, 695, 52});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
        arrToList(matrix, new int[]{229, 891, 985, 905, 824, 507});
        System.out.print(Arrays.toString(matrix.toArray()) + " - ");
        sl.nextPermutation(matrix);
        System.out.println(Arrays.toString(matrix.toArray()));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

