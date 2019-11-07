/**
 * Given two binary strings, return their sum (also a binary string).
 * <br/>
 * https://www.interviewbit.com/problems/add-binary-strings/
 */
public class Solution {
    public String addBinary(String A, String B) {
        if (A.isEmpty()) return B;
        if (B.isEmpty()) return A;
        StringBuilder res = new StringBuilder();
        char carry = '0';
        for (int i = 0; i < A.length() || i < B.length(); i++) {
            char ch1 = i < A.length() ? A.charAt(A.length() - i - 1) : '0';
            char ch2 = i < B.length() ? B.charAt(B.length() - i - 1) : '0';
            if (ch1 == ch2) {
                res.append(carry);
                carry = ch1 == '0' ? '0' : '1';
            } else {
                res.append(carry == '0' ? '1' : '0');
                carry = carry == '0' ? '0' : '1';
            }
        }
        if (carry != '0') res.append('1');
        return res.reverse().toString();
    }
}

