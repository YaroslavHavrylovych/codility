import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/city-tour/
 */
public class Solution {
    private long modulo = 1_000_000_007L;

    public int solve(int A, ArrayList<Integer> B) {
        int[] ln = new int[B.size() + 1];
        long[] cb = new long[B.size() + 1];
        fill(A, B, ln, cb);
        for (int i = ln.length - 1; i > 0; i--) {
            if (ln[i - 1] == 0) {
                ln[i - 1] = ln[i];
                cb[i - 1] = cb[i];
                continue;
            }
            if (ln[i] == 0) continue;
            long nc = newComb(ln[i], ln[i - 1]);
            ln[i - 1] = ln[i] + ln[i - 1];
            nc = (((nc * cb[i]) % modulo) * cb[i - 1]) % modulo;
            cb[i - 1] = nc;
        }
        return (int) cb[0];
    }

    private void fill(int A, ArrayList<Integer> B, int[] ln, long[] cb) {
        B.sort(Integer::compareTo);
        ln[0] = B.get(0) - 1;
        cb[0] = ln[0] == 0 ? 0 : 1;
        for (int i = 1; i < B.size(); i++) {
            ln[i] = B.get(i) - B.get(i - 1) - 1;
            cb[i] = ln[i] == 0 ? 0 : pow(ln[i]);
        }
        ln[B.size()] = A - B.get(B.size() - 1);
        cb[B.size()] = ln[B.size()] == 0 ? 0 : 1;
    }

    private long pow(int len) {
        long res = 1;
        for (int i = len - 1; i > 0; i--) {
            res = (res << 1) % modulo;
        }
        return res;
    }

    private long newComb(int ln1, int ln2) {
        int total = ln1 + ln2;
        int ln = Math.max(ln1, ln2) + 1;
        long res = 1L;
        //res = total!/ln!
        while (ln <= total) {
            res = res * ln % modulo;
            ln += 1;
        }
        //res / shortest!
        res = res * modMult(fact(Math.min(ln1, ln2)), modulo - 2) % modulo;
        return res;
    }

    private long modMult(long f, long pw) {
        long m = f;
        long e = pw;
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * m) % modulo;
            m = (m * m) % modulo;
            e >>= 1;
        }
        return res;
    }

    private long fact(long n) {
        long res = 1;
        for (int i = 2; i <= n; i++) res = res * i % modulo;
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 3, 7});
        System.out.println(sl.solve(10, a));
        arrToList(a, new int[]{3});
        System.out.println(sl.solve(5, a));
        arrToList(a, new int[]{3, 8});
        System.out.println(sl.solve(10, a));
        arrToList(a, new int[]{1, 2});
        System.out.println(sl.solve(2, a));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

