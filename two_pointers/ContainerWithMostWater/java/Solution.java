import java.util.ArrayList;
import java.util.List;

/**
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * 'n' vertical lines are drawn such that the
 * two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * Your program should return an integer which corresponds to
 * the maximum area of water that can be contained
 * ( Yes, we know maximum area instead of maximum volume sounds weird.
 * But this is 2D plane we are working with for simplicity ).
 * <br/>
 * https://www.interviewbit.com/problems/container-with-most-water/
 */
public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        if (A.size() < 2) return 0;
        List<Integer> pos = new ArrayList<>(A.size());
        for (int i = 0; i < A.size(); i++) pos.add(i + 1);
        sort(0, A.size() - 1, A, pos);
        int maxVal = Math.max(pos.get(0), pos.get(1));
        int minVal = Math.min(pos.get(0), pos.get(1));
        int maxProd = Math.min(A.get(0), A.get(1)) * (maxVal - minVal);
        for (int i = 2; i < A.size(); i++) {
            int prod = Math.max(A.get(i) * Math.abs(pos.get(i) - minVal),
                    A.get(i) * Math.abs(pos.get(i) - maxVal));
            if (prod > maxProd) maxProd = prod;
            maxVal = Math.max(maxVal, pos.get(i));
            minVal = Math.min(minVal, pos.get(i));
        }
        return maxProd;
    }

    private void sort(int start, int end, List<Integer> A, List<Integer> pos) {
        if (start >= end) return;
        int i = start, j = end - 1;
        while (i < j) {
            while (i < j && A.get(i) >= A.get(end)) {
                i++;
            }
            while (j > i && A.get(j) <= A.get(end)) {
                j--;
            }
            if (i == j) break;
            //val
            int tmp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, tmp);
            //pos
            tmp = pos.get(i);
            pos.set(i, pos.get(j));
            pos.set(j, tmp);
        }
        j = end;
        if (A.get(i) < A.get(j)) {
            //val
            int tmp = A.get(i);
            A.set(i, A.get(j));
            A.set(j, tmp);
            //pos
            tmp = pos.get(i);
            pos.set(i, pos.get(j));
            pos.set(j, tmp);
            j = i;
        }
        sort(start, j - 1, A, pos);
        sort(j + 1, end, A, pos);
    }
}

