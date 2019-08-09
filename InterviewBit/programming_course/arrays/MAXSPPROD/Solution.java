import java.math.BigInteger;
import java.util.Stack;

public class Solution {
    public int maxSpecialProduct(int[] A) {
        int[] lsvInds = new int[A.length];
        int[] rsvInds = new int[A.length];
        Stack<Integer> stack = new Stack<Integer>();
        //fill lsv
        lsvInds[0] = -1;
        stack.push(0);
        for(int i = 1; i < A.length; i++) {
            do {
                int lastLsvInd = stack.pop();
                if(A[lastLsvInd] > A[i]) {
                    lsvInds[i] = lastLsvInd;
                    stack.push(lastLsvInd);
                    stack.push(i);
                    break;
                }
            } while(!stack.isEmpty());
            if(stack.isEmpty()) {
                lsvInds[i] = -1;
                stack.push(i);
            }
        }
        //fill rsv
        stack.clear();
        rsvInds[A.length - 1] = -1;
        stack.push(A.length - 1);
        for(int i = A.length - 2; i >= 0; i--) {
            do {
                int lastRsvInd = stack.pop();
                if(A[lastRsvInd] > A[i]) {
                    rsvInds[i] = lastRsvInd;
                    stack.push(lastRsvInd);
                    stack.push(i);
                    break;
                }
            } while(!stack.isEmpty());
            if(stack.isEmpty()) {
                rsvInds[i] = -1;
                stack.push(i);
            }
        }
        //get max product mod
        BigInteger maxProduct = BigInteger.valueOf(0);
        for(int i = 0; i < lsvInds.length; i++) {
            long lsv = lsvInds[i];
            lsv = lsv == -1 ? 0 : lsvInds[i];
            long rsv = rsvInds[i];
            rsv = rsv == -1 ? 0 : rsvInds[i];
            BigInteger currProduct = BigInteger.valueOf(rsv).multiply(BigInteger.valueOf(lsv));
            if(currProduct.compareTo(maxProduct) > 0) {
                maxProduct = currProduct;
            }
        }
        return maxProduct.mod(BigInteger.valueOf(1000000007)).intValue();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] a = new int[]{5,9,6,8,6,4,6,9,5,4,9};
        System.out.println("A: " + java.util.Arrays.toString(a));
        int msp = sl.maxSpecialProduct(a);
        int litmus = 80;
        System.out.println("Expected max special product: " + litmus);
        System.out.println("Real max special product: " + msp);
        System.out.println("Result: " + (litmus == msp ? "Correct" : "Fail"));
    }
}

