/*
 * https://www.interviewbit.com/problems/reverse-integer/
 */
public class Solution {
    public int reverse(int A) {
        boolean min = false;
        if (A < 0) {
            min = true;
            A = -A;
        }
        StringBuilder str = new StringBuilder(Integer.toString(A));
        try {
            return Integer.parseInt(str.reverse().toString()) * (min ? -1 : 1);
        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.reverse(-582764641));
    }
}
