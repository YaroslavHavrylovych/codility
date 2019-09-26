/*
 * https://www.interviewbit.com/problems/palindrome-integer/
 */
public class Solution {
    public int isPalindrome(int A) {
        if (A < 0) return 0;
        String val = Integer.toString(A);
        for (int i = 0; i < val.length() / 2; i++) {
            if (val.charAt(i) != val.charAt(val.length() - 1 - i)) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.isPalindrome(-123321));
        System.out.println(sl.isPalindrome(12332));
        System.out.println(sl.isPalindrome(123321));
    }
}
