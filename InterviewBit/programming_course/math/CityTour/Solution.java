import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/city-tour/
 */
public class Solution {
    private int modulo = 1_000_000_007;

    public int solve(int A, ArrayList<Integer> B) {
        int prevCity = 1;
        Set<Interval> intervals = new HashSet<>();
        List<Integer> sortedCities = B.stream().distinct().sorted().collect(Collectors.toList());
        for (int city : sortedCities) {
            Interval interval;
            if (prevCity == 1 && sortedCities.get(0) != 1) {
                interval = new Interval(city - prevCity, 1);
            } else {
                interval = new Interval(city - prevCity - 1, doubleLinkedListComb(city - prevCity - 1));
            }
            prevCity = city;
            if (interval.length < 1) continue;
            intervals.add(interval);
        }
        if (prevCity != A && sortedCities.get(sortedCities.size() - 1) != A) {
            intervals.add(new Interval(A - prevCity, 1));
        }
        while (intervals.size() > 1) {
            Iterator<Interval> it = intervals.iterator();
            Interval i1 = it.next();
            Interval i2 = it.next();
            intervals.add(merge(i1, i2));
            intervals.remove(i1);
            intervals.remove(i2);
        }
        return intervals.isEmpty() ? 0 : (int) intervals.iterator().next().comb;
    }

    private Interval merge(Interval i1, Interval i2) {
        int longest = Math.max(i1.length, i2.length);
        int shortest = Math.min(i1.length, i2.length);
        long res = i1.comb * i2.comb % modulo;
        for (int i = longest + 1; i <= longest + shortest; i++) {
            res = res * i % modulo;
        }
        int a = 1;
        for (int i = 2; i <= shortest; i++) {
            a = a * i % modulo;
        }
        res = res * modExp(fact(shortest), modulo - 2) % modulo;
        return new Interval(longest + shortest, res);
    }

    long fact(int val) {
        long res = 1;
        for (int i = 1; i <= val; i++) res = res * i % modulo;
        return res;
    }

    private long modExp(long val, long exp) {
        long res = 1;
        long v = val;
        long e = exp;
        while (e > 0) {
            if ((e & 1) == 1) {
                res = (res * v) % modulo;
            }
            v = v * v % modulo;
            e >>= 1;
        }
        return res;
    }

    private int doubleLinkedListComb(int size) {
        int res = 1;
        for (int i = 1; i < size; i++) {
            res = res * 2 % modulo;
        }
        return res;
    }

    private class Interval {
        int length;
        long comb;

        Interval(int length, long comb) {
            this.length = length;
            this.comb = comb;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 3, 7});
        System.out.println(sl.solve(10, a));
        arrToList(a, new int[]{3});
        System.out.println(sl.solve(5, a));
        arrToList(a, new int[]{3, 8});
        System.out.println(sl.solve(10, a));
        arrToList(a, new int[]{1, 2});
        System.out.println(sl.solve(2, a));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

