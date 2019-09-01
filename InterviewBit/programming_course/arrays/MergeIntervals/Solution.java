import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/merge-intervals/
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        //find interval, where I can step in
        int i = 0, j = intervals.size() - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (newInterval.start == intervals.get(mid).start) {
                i = mid + 1;
                break;
            }
            if (newInterval.start < intervals.get(mid).start) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        //checking the element before 'i' to be sure we're not overlapping
        intervals.add(i, newInterval);
        if (i - 1 >= 0) {
            Interval tmp = intervals.get(i - 1);
            if (tmp.end >= newInterval.start) {
                newInterval.start = tmp.start;
                newInterval.end = Math.max(newInterval.end, tmp.end);
                intervals.remove(i - 1);
                i--;
            }
        }
        //checking 'end' bound
        int newIntervalInd = i++;
        j = intervals.size() - 1;
        while (i <= j) {
            int mid = (j + i) / 2;
            if (newInterval.end < intervals.get(mid).start) {
                j = mid - 1;
                continue;
            } else if (newInterval.end <= intervals.get(mid).end) {
                j = mid;
                break;
            }
            i = mid + 1;
        }
        if (intervals.get(j) == newInterval) return intervals;
        if (newInterval.end < intervals.get(j).start) {
            for (i = 0; i < j - newIntervalInd - 1; i++) intervals.remove(newIntervalInd + 1);
        } else {
            newInterval.end = Math.max(intervals.get(j).end, newInterval.end);
            for (i = 0; i < j - newIntervalInd; i++) intervals.remove(newIntervalInd + 1);
        }
        return intervals;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Interval> lst = new ArrayList<>();
        arrToList(lst, new Interval[]{new Interval(2, 3), new Interval(6, 7), new Interval(8, 10),
                new Interval(11, 15), new Interval(20, 23), new Interval(25, 27)});
        lst = sl.insert(lst, new Interval(29, 30));
        System.out.println(Arrays.toString(lst.toArray()));
    }

    private static void arrToList(List<Interval> lst, Interval[] a) {
        lst.clear();
        lst.addAll(Arrays.asList(a));
    }

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

