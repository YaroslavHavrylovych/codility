/*
 * https://www.interviewbit.com/problems/excel-column-title/
 */
public class Solution {
    public String convertToTitle(int A) {
        if(A <= 0) return "";
        StringBuilder res = new StringBuilder();
        while (A > 0) {
            A = A - 1;
            int rest = A % 26;
            A = A / 26;
            res.append((char) (((int) 'A') + rest));
        }
        return res.reverse().toString();
    }


    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.convertToTitle(28));
    }
}
