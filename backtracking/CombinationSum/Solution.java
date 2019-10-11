import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.interviewbit.com/problems/combination-sum/
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        return combinationSum(A.stream().distinct().sorted().collect(Collectors.toList()),
                B, new ArrayList<>(), 0);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(List<Integer> A, int B,
                                                        ArrayList<Integer> seq, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (Integer val : A) {
            if (!seq.isEmpty() && val < seq.get(seq.size() - 1)) continue;
            if (sum + val > B) break;
            else if (sum + val == B) {
                seq.add(val);
                res.add(seq);
                return res;
            }
            ArrayList<Integer> newSeq = new ArrayList<>(seq);
            newSeq.add(val);
            res.addAll(combinationSum(A, B, newSeq, sum + val));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{2, 3, 6, 7});
        print(sl.combinationSum(a, 7));
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}


