import java.util.ArrayList;
import java.util.List;

/**
 * Given three sorted arrays A, B and Cof not necessarily same sizes.
 * Calculate the minimum absolute difference between the maximum and 
 * minimum number from the triplet a, b, c such that a, b, c belongs 
 * arrays A, B, C respectively.  
 * i.e. minimize | max(a,b,c) - min(a,b,c) |.
 * <br/>
 * https://www.interviewbit.com/problems/minimize-the-absolute-difference/
 */
public class Solution {
    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {
        if (A.isEmpty() || B.isEmpty() || C.isEmpty()) return -1;
        int a = 0, b = 0, c = 0;
        int minRes = Integer.MAX_VALUE;
        while (true) {
            int max = findMax(a, A, b, B, c, C);
            a = moveToMax(a, A, max);
            b = moveToMax(b, B, max);
            c = moveToMax(c, C, max);
            int min = Math.min(A.get(a), Math.min(B.get(b), C.get(c)));
            if (max - min < minRes) minRes = max - min;
            if (a >= A.size() - 1 && b >= B.size() - 1 && c >= C.size() - 1) break;
            //move
            int nextMin = findMin(a + 1, A, b + 1, B, c + 1, C);
            a = moveToMax(a, A, nextMin);
            b = moveToMax(b, B, nextMin);
            c = moveToMax(c, C, nextMin);
        }
        return minRes;
    }

    private int moveToMax(int ind, ArrayList<Integer> ar, int max) {
        if (ind >= ar.size()) return ar.size() - 1;
        int ret = ar.get(ind);
        for (int i = ind; i < ar.size(); i++)
            if (ar.get(i) > max) break;
            else ret = i;
        return ret;
    }

    private int findMin(int a, ArrayList<Integer> A,
                        int b, ArrayList<Integer> B,
                        int c, ArrayList<Integer> C) {
        int aMax = a >= A.size() - 1 ? Integer.MAX_VALUE : A.get(a);
        int bMax = b >= B.size() - 1 ? Integer.MAX_VALUE : B.get(b);
        int cMax = c >= C.size() - 1 ? Integer.MAX_VALUE : C.get(c);
        return Math.min(aMax, Math.min(bMax, cMax));
    }

    private int findMax(int a, ArrayList<Integer> A,
                        int b, ArrayList<Integer> B,
                        int c, ArrayList<Integer> C) {
        int aMax = a >= A.size() - 1 ? A.get(A.size() - 1) : A.get(a);
        int bMax = b >= B.size() - 1 ? B.get(B.size() - 1) : B.get(b);
        int cMax = c >= C.size() - 1 ? C.get(C.size() - 1) : C.get(c);
        return Math.max(aMax, Math.max(bMax, cMax));
    }
}

