import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.Collections;

/*
 * https://www.interviewbit.com/problems/simple-queries/
 */
public class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        arrToList(a, new int[]{1, 2, 4});
        arrToList(b, new int[]{1, 2, 3, 4, 5, 6});
        ArrayList<Integer> tmp = sl.solve(a, b);
        System.out.println(Arrays.toString(tmp.toArray()));
    }

    private static void print(ArrayList<ArrayList<Integer>> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.println(Arrays.toString(a.get(i).toArray()));
        }
    }

    private boolean equal(List<Integer> lst1, List<Integer> lst2) {
        if (lst1.size() != lst2.size()) return false;
        for (int i = 0; i < lst1.size(); i++) {
            if (!lst1.get(i).equals(lst2.get(i))) return false;
        }
        return true;
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        if (A == null || A.size() == 0) return A;
        ArrayList<Integer> res = new ArrayList<>(B.size());
        if (B.isEmpty()) return res;
        //left and right are needed to find how many times an element appears in G
        long[] l = createLeftInd(A);
        long[] r = createRightInd(A);
        //creating G
        Map<Integer, Long> g = new HashMap<>();
        for (int i = 0; i < A.size(); i++) {
            Long amount = l[i] * r[i];
            Integer val = getProductOfDivisors(A.get(i));
            Long existingAmount = g.get(val);
            if (existingAmount != null) amount += existingAmount;
            g.put(val, amount);
        }
        ArrayList<Integer> gVals = new ArrayList<>(g.keySet());
        gVals.sort(Collections.reverseOrder());
        long[] gPositions = new long[gVals.size()];
        for (int i = 0; i < gVals.size(); i++) {
            gPositions[i] = (i == 0 ? 0 : gPositions[i - 1]) + g.get(gVals.get(i));
        }
        int i;
        int j;
        //creating the result
        for (int pos : B) {
            i = 0;
            j = gPositions.length - 1;
            while (i <= j) {
                int mid = (i + j) / 2;
                if (pos > gPositions[mid]) {
                    i = mid + 1;
                    continue;
                }
                if (pos <= gPositions[mid] &&
                        (mid <= 0 || pos > gPositions[mid - 1])) {
                    res.add(gVals.get(mid));
                    break;
                } else {
                    j = mid - 1;
                }
            }
        }
        return res;
    }

    private long[] createRightInd(ArrayList<Integer> A) {
        long[] r = new long[A.size()];
        int last = A.size() - 1;
        r[last] = 1;
        Stack<Integer> indStack = new Stack<>();
        indStack.push(last);
        for (int i = last - 1; i >= 0; i--) {
            int ind = indStack.pop();
            if (A.get(i) >= A.get(ind)) {
                while (!indStack.isEmpty()) {
                    ind = indStack.pop();
                    if (A.get(i) < A.get(ind)) {
                        r[i] = ind - i;
                        indStack.push(ind);
                        break;
                    }
                }
                if (indStack.isEmpty()) r[i] = last - i + 1;
                else r[i] = ind - i;
                indStack.push(i);
            } else {
                r[i] = ind - i;
                indStack.push(ind);
                indStack.push(i);
            }
        }
        return r;
    }

    private long[] createLeftInd(ArrayList<Integer> A) {
        long[] l = new long[A.size()];
        l[0] = 1;
        Stack<Integer> indStack = new Stack<>();
        indStack.push(0);
        for (int i = 1; i < A.size(); i++) {
            int ind = indStack.pop();
            if (A.get(i) > A.get(ind)) {
                while (!indStack.isEmpty()) {
                    ind = indStack.pop();
                    if (A.get(i) <= A.get(ind)) {
                        l[i] = i - ind;
                        indStack.push(ind);
                        break;
                    }
                }
                if (indStack.isEmpty()) l[i] = i + 1;
                else l[i] = i - ind;
                indStack.push(i);
            } else {
                l[i] = i - ind;
                indStack.push(ind);
                indStack.push(i);
            }
        }
        return l;
    }

    private int getProductOfDivisors(long value) {
        long product = 1;
        for (long i = 1; i <= Math.sqrt(value); i++)
            if (value % i == 0) {
                product *= i;
                if (value / i != i)
                    product *= value / i;
                product %= 1000000007L;
            }
        return (int) (product % (1000000007L));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
