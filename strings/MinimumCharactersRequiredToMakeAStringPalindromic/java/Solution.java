/**
 * https://www.interviewbit.com/problems/minimum-characters-required-to-make-a-string-palindromic/
 */
public class Solution {
    public int solve(String A) {
        if (A.length() == 1) return 0;
        for (int i = A.length() / 2; i > 0; i--) {
            if (compare(A, 0, i - 1, i + 1, 2 * i)) 
                return (A.length() - 1) - 2 * i;
            if (compare(A, 0, i - 1, i, 2 * i - 1)) 
                return (A.length() - 1) - (2 * i - 1);
        }
        return A.length() - 1;
    }

    private boolean compare(String a, int s1, int e1, int s2, int e2) {
        if (s1 < 0 || e2 >= a.length()) return false;
        for (int i = 0; i <= e1 - s1; i++) {
            if (a.charAt(e1 - i) != a.charAt(s2 + i)) return false;
        }
        return true;
    }
}

