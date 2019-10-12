import java.util.Arrays;

/**
 * Check README to find the description.
 * <br/>
 * Donations are enclosed/locked (e.g. the first element is last's neighbor).
 * If we remove this condition then the algorithm is straight forward:
 * <br/>
 * starting from the first element pick next one and select the maximum possible
 * value in column before previous and the one which is before the column before
 * previous (e.g. if we're searching value for column i, then we checking
 * (i-2) and (i-3) columns for max value, where (i-1) is neighbor and we not
 * checking it).
 * <br/>
 * To ensure that we're not selecting first and last elements together we need
 * to track which values include value from the first column and update
 * such values with last instead of first, if last value is bigger (except
 * value before last as they are neighbors).
 */
public class BadNeighbors {
    public int maxDonations(int[] donations) {
        if(donations.length <= 3) return findMax(donations);
        return calculateMaxDonations(donations, new int[donations.length], 0);
    }
    
    public int calculateMaxDonations(int[] donations, int[] includeFirst, 
            int pos) {
        if(pos == 2) { 
            donations[2] += donations[0];
            includeFirst[0] = includeFirst[2] = 1;
        } else if(pos == donations.length - 1) {
            int delta = donations[pos] - donations[0];
            if(delta <= 0) updateLast(donations, includeFirst);
            else
                for(int i = 1; i < donations.length - 2; i++)
                    if(includeFirst[i] == 1) donations[i] += delta;
            return findMax(donations);
        } else if(pos > 2) {
            updateDonations(donations, includeFirst, pos);
        }
        return calculateMaxDonations(donations, includeFirst, pos + 1);
    }

    private void updateLast(int[] donations, int[] includeFirst) {
        int pos = donations.length - 1;
        int maxFirstless = pos;
        for(int i = pos - 1; i >= 1; i--)
            if(donations[i] > maxFirstless && includeFirst[i] == 0)
                maxFirstless = i;
        donations[pos] += donations[maxFirstless];
    }

    private void updateDonations(int[] donations, int[] includeFirst, 
            int pos) {
            int maxPos;
            if(donations[pos - 2] > donations[pos - 3]) maxPos = pos - 2;
            else if(donations[pos - 2] < donations[pos - 3]) maxPos = pos - 3;
            else if(includeFirst[pos - 3] == 0) maxPos = pos - 3;
            else maxPos = pos - 2; 
            donations[pos] += donations[maxPos];
            includeFirst[pos] = includeFirst[maxPos];
    }

    private int findMax(int[] donations) {
        int max = donations[0];
        for(int i = donations.length - 1; i > 0; i--) {
            int current = donations[i];
            if(current > max) max = current;
        }
        return max;
    }

    private static void printMaxDonations(int[] donations) {
        System.out.println("For sequence " + Arrays.toString(donations)
                + ", max donate =" + 
                new BadNeighbors().maxDonations(donations));
    }

    public static void main(String[] args) {
        printMaxDonations(new int[] { 10, 3, 2, 5, 7, 8 });
        printMaxDonations(new int[] { 11, 15 });
        printMaxDonations(new int[] { 7, 7, 7, 7, 7, 7, 7 });
        printMaxDonations(new int[] { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 });
        printMaxDonations(new int[] { 
            94, 40, 49, 65, 21, 21, 106, 80, 92,
            81, 679, 4, 61, 6, 237, 12, 72, 74, 29, 95,
            265, 35, 47, 1, 61, 397, 52, 72, 37, 51, 1,
            81, 45, 435, 7, 36, 57, 86, 81, 72 });
    }
}
