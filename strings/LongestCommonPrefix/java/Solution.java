import java.util.ArrayList;

/**
 * Given the array of strings A,
 * you need to find the longest string S which is the prefix of
 * ALL the strings in the array.
 * Longest common prefix for a pair of strings S1 and S2
 * is the longest string S which is the prefix of both S1 and S2.
 * <br/>
 * For Example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".
 * <br/>
 * https://www.interviewbit.com/problems/longest-common-prefix/
 */
public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        if (A.isEmpty()) return "";
        int c = 0;
        while (c < A.get(0).length()) {
            char ch = A.get(0).charAt(c);
            for (String str : A) {
                if (c >= str.length() || str.charAt(c) != ch) {
                    return str.substring(0, c);
                }
            }
            c++;
        }
        return A.get(0).substring(0, c);
    }
}

