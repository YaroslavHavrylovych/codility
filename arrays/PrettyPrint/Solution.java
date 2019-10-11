import java.util.ArrayList;
import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/prettyprint/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> prettyPrint(int A) {
        int N = 2 * A - 1;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            ArrayList<Integer> tmp = new ArrayList<>(A);
            for (int j = 1; j <= N; j++) {
                tmp.add(A);
            }
            res.add(tmp);
        }
        for (int c = 1; c < A; c++) {
            for (int i = c; i < N - c; i++) {
                res.get(c).set(i, A - c);
                res.get(N - c - 1).set(i, A - c);
                res.get(i).set(c, A - c);
                res.get(N - i - 1).set(N - c - 1, A - c);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        print(sl.prettyPrint(5));
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }
}
