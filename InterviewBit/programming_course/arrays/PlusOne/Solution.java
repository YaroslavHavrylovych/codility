/*
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class Solution {
    public int[] plusOne(int[] A) {
        int lastInd = A.length - 1;
        int i = A.length - 1;
        int c = 1;
        while (i >= 0) {
            c += A[i];
            A[i] = c % 10;
            c = c / 10;
            if (A[i] != 0) {
                lastInd = i;
            }
            i -= 1;
        }
        if (c > 0) {
            lastInd = 0;
        }
        int[] B = new int[c > 0 ? A.length + 1 : A.length - lastInd];
        System.arraycopy(A, lastInd, B, c > 0 ? 1 : 0, c > 0 ? A.length : A.length - lastInd);
        if (c > 0) {
            B[0] = c;
        }
        return B;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.plusOne(new int[]{9, 9, 9}));
    }
}
