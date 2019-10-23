import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] A = new int[3][];
        A[0] = new int[]{1, 2, 3};
        A[1] = new int[]{4, 5, 6};
        A[2] = new int[]{7, 8, 9};
        int[][] res = sl.diagonal(A);
        if(Arrays.equals(res[0], new int[] {1}) 
                && Arrays.equals(res[1], new int[] {2,4})
                && Arrays.equals(res[2], new int[] {3,5,7})
                && Arrays.equals(res[3], new int[] {6,8})
                && Arrays.equals(res[4], new int[] {9}))
            {
                System.out.println("Anti-diagonals SUCCESS");
            } else {
                System.out.println("Anti-diagonals FAILED");
            }
    }
}
