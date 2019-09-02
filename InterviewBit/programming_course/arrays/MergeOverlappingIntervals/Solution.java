import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/merge-overlapping-intervals/
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort(Comparator.comparingInt(o -> o.start));
        int i = 0;
        while (i < intervals.size() - 1) {
            Interval i1 = intervals.get(i);
            Interval i2 = intervals.get(i + 1);
            if (i1.end < i2.start) {
                i++;
                continue;
            }
            if (i1.end < i2.end) i1.end = i2.end;
            intervals.remove(i + 1);
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Interval> lst = new ArrayList<>();
        arrToList(lst, new Interval[]{new Interval(8, 10), new Interval(1, 3), new Interval(2, 9),
                new Interval(15, 18), new Interval(1, 2), new Interval(18, 19)});
        lst = sl.merge(lst);
        System.out.println(Arrays.toString(lst.toArray()));
    }

    private static void arrToList(List<Interval> lst, Interval[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }

    /**
     * Definition for an interval.
     */
    public static class Interval {
        int start;
        int end;

        Interval() { start = 0; end = 0; }

        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "[" + start + "," + end + "]";
        }
    }
}

