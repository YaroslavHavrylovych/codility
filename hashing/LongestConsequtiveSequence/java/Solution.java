import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * Given an unsorted array of integers, 
 * find the length of the longest consecutive elements sequence.
 * <br/>
 * https://www.interviewbit.com/problems/longest-consecutive-sequence/
 */
public class Solution {
    public int longestConsecutive(final List<Integer> A) {
        if (A.isEmpty()) return 0;
        int max = A.stream().max(Integer::compareTo).get();
        int min = A.stream().min(Integer::compareTo).get();
        min = min > 0 ? 0 : min;
        max = max > 0 ? max : 0;
        BitSet minus = new BitSet(max);
        BitSet plus = new BitSet(-min);
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            if (val >= 0) plus.set(val);
            else minus.set(-(val + 1));
        }
        int longest = 1;
        int current = 0;
        int prevBit = 0;
        for (int i = minus.length() - 1; i >= 0; i--) {
            if (minus.get(i)) {
                if (prevBit - 1 == i) {
                    current++;
                    prevBit = i;
                    if (longest < current) {
                        longest = current;
                    }
                } else {
                    current = 1;
                    prevBit = i;
                }
            }
        }
        if (prevBit == 0) {
            prevBit = -1;
        }
        for (int i = 0; i < plus.length(); i++) {
            if (plus.get(i)) {
                if (prevBit + 1 == i) {
                    current++;
                    prevBit = i;
                    if (longest < current) {
                        longest = current;
                    }
                } else {
                    current = 1;
                    prevBit = i;
                }
            }
        }
        return longest;
    }
}


