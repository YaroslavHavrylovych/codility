import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Check README to find the description.
 */
public class LongestNonDecreasing {
    private static final int[] SEQUENCE = 
        new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

    public List<Integer> longestSequence(int[] sequence) {
        int[] collector = new int[sequence.length];
        updateLongestSequenceCollector(sequence, collector, 0);
        return getListFromCollector(sequence, collector);
    }

    private List<Integer> getListFromCollector(int[] sequence,
            int[] collector) {
        List<Integer> ret = new ArrayList<Integer>();
        int maxId = collector.length - 1;
        for(int i = collector.length - 2; i >= 0; i--)
            if(collector[i] > collector[maxId]) maxId = i;
        ret.add(maxId);
        int currentId = maxId;
        for(int i = maxId - 1; i >= 0; i--)
            if(collector[currentId] - collector[i] == 1
                    && sequence[currentId] >= sequence[i]) {
                currentId = i;
                ret.add(i);
            }
        return ret;
    }

    private void updateLongestSequenceCollector(int[] sequence, 
            int[] collector, int ind) {
        if(ind == sequence.length) return;
        if(ind == 0) collector[0] = 1;
        else for(int i = ind - 1; i >= 0; i--)
            if(sequence[ind] >= sequence[i]
                    &&  collector[ind] < collector[i] + 1) 
                collector[ind] = collector[i] + 1;
        updateLongestSequenceCollector(sequence, collector, ind + 1);
    }

    public static void main(String[] args) {
        System.out.println("Sequence: " + Arrays.toString(SEQUENCE));
        List<Integer> indSeq = new LongestNonDecreasing()
            .longestSequence(SEQUENCE);
        List<Integer> valSeq = indSeq.stream().sorted()
            .map(ind -> SEQUENCE[ind])
            .collect(Collectors.toList());
        System.out.println("Longest: " + valSeq);
    }
}

