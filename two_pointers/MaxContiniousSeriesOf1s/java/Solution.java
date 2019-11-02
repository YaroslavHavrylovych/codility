import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * You are given with an array of 1s and 0s. 
 * And you are given with an integer M, 
 * which signifies number of flips allowed.  
 * Find the position of zeros which when flipped will 
 * produce 'maximum continuous series of 1s'.
 * <br/>
 * https://www.interviewbit.com/problems/max-continuous-series-of-1s/
 */
public class Solution {
    public ArrayList<Integer> maxone(ArrayList<Integer> A, int B) {
        if (B < 0) return new ArrayList<>();
        int stI = 0;
        int lng = findLong(A, 0, A.size() - 1, B);
        int firstZero = indexOfZero(A, 0);
        while (firstZero >= 0) {
            int tmpLng = findLong(A, firstZero + 1, A.size() - 1, B);
            if (tmpLng > lng) {
                stI = firstZero + 1;
                lng = tmpLng;
            }
            firstZero = indexOfZero(A, firstZero + 1);
        }
        if (lng <= 0) return new ArrayList<>();
        return IntStream.range(stI, stI + lng)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private int findLong(ArrayList<Integer> A, int st, int end, int b) {
        int i = 0, c = st;
        int ones = 0;
        while (c <= end && i <= b) {
            if (A.get(c) == 0) {
                if (i < b) ones++;
                i++;
            } else {
                ones++;
            }
            c++;
        }
        return ones;
    }

    private int indexOfZero(List<Integer> A, int start) {
        for (int i = start; i < A.size(); i++)
            if (A.get(i) == 0) return i;
        return -1;
    }
}

