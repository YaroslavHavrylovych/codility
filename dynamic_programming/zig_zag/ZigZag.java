import java.util.Arrays;

/**
 * Check README to find description.
 * <br/>
 * Starting from zero each step we're searching for the longest
 * existing ZigZag sequence in preceding steps which can be applied with
 * current number. 
 */
public class ZigZag {
    public int longestZigZag(int[] seq) {
        int[] zigZag = new int[seq.length];
        calcualteZigZags(seq, zigZag, 1);
        return findMaxAbs(zigZag) + 1;
    }
    
    public void calcualteZigZags(int[] seq, int[] zigZag, int pos) {
        if(pos >= zigZag.length) return;
        int longest = 0;
        for(int i = pos - 1; i >= 0; i--) {
            int posZig = zigZag[pos];
            int posZigAbs = Math.abs(posZig);
            int iZig = zigZag[i];
            int iZigAbs = Math.abs(iZig);
            if(posZigAbs > iZigAbs) continue;
            if(iZig < 0) {
                if(seq[pos] > seq[i]) zigZag[pos] = iZigAbs + 1; 
            } else if(iZig > 0) {
                if(seq[pos] < seq[i]) zigZag[pos] = -(iZigAbs + 1); 
            } else {
                if(seq[pos] > seq[i]) zigZag[pos] = 1;
                else if(seq[pos] < seq[i]) zigZag[pos] = -1;
            }
        }
        calcualteZigZags(seq, zigZag, pos + 1);
    }

    private int findMaxAbs(int[] zigZag) {
        int max = Math.abs(zigZag[0]);
        for(int i = zigZag.length - 1; i > 0; i--) {
            int abs = Math.abs(zigZag[i]);
            if(abs > max) max = abs;
        }
        return max;
    }

    private static void printLongest(int[] seq) {
        System.out.println("For sequence " + Arrays.toString(seq)
                + ", longest(ZigZag)=" + new ZigZag().longestZigZag(seq));
    }

    public static void main(String[] args) {
        printLongest(new int[] { 1, 7, 4, 9, 2, 5 });
        printLongest(new int[] { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 });
        printLongest(new int[] { 44 });
        printLongest(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
        printLongest(new int[] { 70, 55, 13, 2, 99, 2, 80, 80, 80, 80, 
            100, 19, 7, 5, 5, 5, 1000, 32, 32 });
        printLongest(new int[] { 
            374, 40, 854, 203, 203, 156, 362, 279, 812, 955, 
            600, 947, 978, 46, 100, 953, 670, 862, 568, 188, 
            67, 669, 810, 704, 52, 861, 49, 640, 370, 908, 
            477, 245, 413, 109, 659, 401, 483, 308, 609, 120, 
            249, 22, 176, 279, 23, 22, 617, 462, 459, 244 });
    }
}
