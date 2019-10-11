import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/rotate-matrix/
 */
public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        int n = a.size();
        int[] tmp = new int[4];
        for (int i = 0; i < n / 2; i++) {
            int last = n - i - 1;
            for (int j = i; j < last; j++) {
                tmp[0] = a.get(i).get(j);
                tmp[1] = a.get(j).get(last);
                tmp[2] = a.get(last).get(n - 1 - j);
                tmp[3] = a.get(n - 1 - j).get(i);
                a.get(i).set(j, tmp[3]);
                a.get(j).set(last, tmp[0]);
                a.get(last).set(n - 1 - j, tmp[1]);
                a.get(n - 1 - j).set(i, tmp[2]);
            }
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int n = 10;
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>(n));
            for (int j = 1; j <= n; j++) {
                matrix.get(i).add(i * n + j);
            }
        }
        print(matrix);
        System.out.println();
        sl.rotate(matrix);
        System.out.println();
        print(matrix);
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }
}

