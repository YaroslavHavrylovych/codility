import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/maximum-consecutive-gap/
 */
public class Solution {
    public int maximumGap(final List<Integer> a) {
        if (a.size() < 2) {
            return 0;
        }
        //find min and max
        int minV = a.get(0);
        int maxV = a.get(0);
        for (int v : a) {
            if (v < minV) {
                minV = v;
            } else if (v > maxV) {
                maxV = v;
            }
        }
        //create a gap between numbers
        int gap = (maxV - minV) / a.size() + 1;
        int[] gapedMin = new int[a.size() + 1];
        Arrays.fill(gapedMin, -1);
        int[] gapedMax = new int[a.size() + 1];
        Arrays.fill(gapedMax, -1);
        //filter values by gaps
        for (int i = 0; i < a.size(); i++) {
            int j = (a.get(i) - minV) / gap;
            if (gapedMin[j] == -1) {
                gapedMin[j] = a.get(i);
                gapedMax[j] = a.get(i);
            } if (a.get(i) < gapedMin[j]) {
                gapedMin[j] = a.get(i);
            } else if (a.get(i) > gapedMax[j]) {
                gapedMax[j] = a.get(i);
            }
        }
        List<Integer> sorted = new ArrayList<>();
        int previous = -1;
        int max = 0;
        for (int i = 0; i < gapedMin.length; i++) {
            if (gapedMin[i] == -1) continue;
            if (previous != -1 && gapedMin[i] - previous > max) max = gapedMin[i] - previous;
            previous = gapedMax[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> lst = new ArrayList<>();
        lst.add(1);
        lst.add(10);
        lst.add(5);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(1);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(1);
        lst.add(2);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(5);
        lst.add(7);
        lst.add(8);
        lst.add(9);
        lst.add(10);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        lst.add(100);
        System.out.println(sl.maximumGap(lst)); lst.clear();
        lst.add(1);
        lst.add(1);
        lst.add(2);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(1);
        lst.add(10);
        System.out.println(sl.maximumGap(lst));
        lst.clear();
        lst.add(1);
        lst.add(3);
        lst.add(4);
        lst.add(5);
        lst.add(7);
        lst.add(9);
        lst.add(10);
        System.out.println(sl.maximumGap(lst));
    }
}
