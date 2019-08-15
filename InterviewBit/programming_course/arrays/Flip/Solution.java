import java.util.Arrays;

/*
 * https://www.interviewbit.com/problems/flip/
 */
public class Solution {
    public int[] flip(String A) {
        int maxR = -1, maxL = -1, maxPls = 0;
        int curPls = 0;
        int currLength = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == '0') {
                curPls += 1;
                currLength += 1;
                if (curPls > maxPls) {
                    maxPls = curPls;
                    maxR = i;
                    maxL = i - currLength + 1;
                }
            } else {
                curPls -= 1;
                currLength += 1;
                if (curPls < 0) {
                    curPls = 0;
                    currLength = 0;
                }
            }
        }
        if (maxPls == 0) return new int[0];
        //check maybe we can start earlier
        int i = maxL;
        int start = maxL;
        int currentBalance = 0;
        while (--i >= 0) {
            if (A.charAt(i) == '0') {
                currentBalance += 1;
            } else {
                currentBalance -= 1;
            }
            if (currentBalance == 0) {
                start = i;
            }
        }
        return new int[]{start + 1, maxR + 1};
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(Arrays.toString(sl.flip("00110")));
        System.out.println(Arrays.toString(sl.flip("1111")));
        System.out.println(Arrays.toString(sl.flip("10000")));
        System.out.println(Arrays.toString(sl.flip("000001")));
        System.out.println(Arrays.toString(sl.flip("010")));
        System.out.println(Arrays.toString(sl.flip("111")));
        System.out.println(Arrays.toString(sl.flip("1101010001")));
        System.out.println(Arrays.toString(sl.flip("0111000100010")));
    }
}
