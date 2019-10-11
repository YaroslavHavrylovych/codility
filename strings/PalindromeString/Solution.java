import java.util.ArrayList;

/**
 * https://www.interviewbit.com/problems/palindrome-string/
 */
public class Solution {
    public int isPalindrome(String A) {
        A = A.toLowerCase();
        int i = 0, j = A.length() - 1;
        while (i < j) {
            char chi;
            do {
                if (i > j) return 1;
                chi = A.charAt(i++);
            } while (!suits(chi));
            char chj;
            do {
                if (i > j) return 1;
                chj = A.charAt(j--);
            } while (!suits(chj));
            if (chi != chj) return 0;
        }
        return 1;
    }

    private boolean suits(char ch) {
        return Character.isAlphabetic(ch) || Character.isDigit(ch);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        System.out.println(sl.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sl.isPalindrome("A1"));
        System.out.println(sl.isPalindrome(""));
    }
}

