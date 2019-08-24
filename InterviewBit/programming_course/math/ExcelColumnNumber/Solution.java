/*
 * https://www.interviewbit.com/problems/excel-column-number/
 */
public class Solution {
    public int titleToNumber(String A) {
        int res = 0;
        for (int i = 0; i < A.length(); i++) {
            res = res + (((int) A.charAt(A.length() - i - 1)) - (int) 'A' + 1) 
                * ((int) Math.pow(26, i));
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.titleToNumber("AB"));
    }
}

