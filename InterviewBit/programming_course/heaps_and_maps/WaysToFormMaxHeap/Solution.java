/**
 * https://www.interviewbit.com/problems/ways-to-form-max-heap/
 */
public class Solution {
    static long modulo = 1000000007L;
    int[] solveMemo = new int[100];

    public int solve(int A) {
        if (A < 3) return 1;
        if (solveMemo[A] != 0) return solveMemo[A];
        int leftAmount = getLeftElementsAmount(A);
        int res = (int) ((((getC(A - 1, leftAmount) % modulo) *
                (solve(leftAmount)) % modulo) *
                solve(A - leftAmount - 1)) % modulo);
        solveMemo[A] = res;
        return res;
    }

    private int getLeftElementsAmount(int A) {
        if (A <= 1) return 0;
        if (A <= 3) return 1;
        int amount = 1;
        int leftAmount = 0;
        int prevLevelAmount = 1;
        while (true) {
            int nextLevelAmount = prevLevelAmount << 1;
            int nextGenAmount = amount + nextLevelAmount;
            if (nextGenAmount < A) {
                amount = nextGenAmount;
                leftAmount += prevLevelAmount;
                prevLevelAmount = nextLevelAmount;
            } else {
                leftAmount += Math.min(prevLevelAmount, A - amount);
                break;
            }
        }
        return leftAmount;
    }

    private long getC(int n, int k) {
        long res = 1;
        for (int i = n; i > (n - k); i--) res = res * i;
        for (int i = 1; i <= k; i++) res = res / i;
        return res % modulo;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.solve(4));
        System.out.println(sl.solve(5));
        System.out.println(sl.solve(20));
    }
}
