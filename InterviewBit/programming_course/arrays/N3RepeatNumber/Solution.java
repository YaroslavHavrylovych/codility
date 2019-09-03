import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * https://www.interviewbit.com/problems/n3-repeat-number/
 */
public class Solution {
    public int repeatedNumber(final List<Integer> a) {
        if (a == null || a.isEmpty()) return -1;
        //sort by amount of digits, to check if we can reduce amount of elements to check
        final int K = a.size() / 3;
        int max = a.get(0);
        int min = max;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i) > max) {
                max = a.get(i);
            } else if (a.get(i) < min) {
                min = a.get(i);
            }
        }
        max = String.valueOf(max).length();
        min = String.valueOf(min).length();
        int[] sizeBuckets = new int[max - min + 1];
        //count amount elements of each size
        for (Integer v : a) sizeBuckets[String.valueOf(v).length() - min]++;
        for (int i = 0; i < sizeBuckets.length; i++) {
            if (sizeBuckets[i] < K) continue;
            int power = (int) Math.pow(10, i + min - 1);
            int val = checkAmountInRange(a, power, power, power * 10, K);
            if (val != -1) {
                return val;
            }
        }
        return -1;
    }

    private int checkAmountInRange(List<Integer> a, int power, int lowBound, int maxBound, final int K) {
        if (power == 1) {
            int[] buckets = new int[10];
            for (Integer v : a) {
                if (v >= lowBound && v < maxBound) {
                    buckets[v % 10]++;
                    if (buckets[v % 10] > K) return v;
                }
            }
            return -1;
        }
        int[] buckets = new int[10];
        for (Integer v : a) if (v >= lowBound && v < maxBound) buckets[(v - lowBound) / power]++;
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] > K) {
                return checkAmountInRange(a, power / 10, lowBound + power * i,
                        lowBound + power * (i + 1), K);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> row = new ArrayList<>();
        arrToList(row, new int[]{1, 2, 3, 1, 1});
        System.out.println(sl.repeatedNumber(row));
        arrToList(row, new int[]{1, 2, 3, 4});
        System.out.println(sl.repeatedNumber(row));
        arrToList(row, new int[]{101, 99, 98, 102, 102, 103, 103, 103});
        System.out.println(sl.repeatedNumber(row));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}

