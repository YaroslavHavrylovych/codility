import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * https://www.interviewbit.com/problems/triplets-with-sum-between-given-range/
 */
public class Solution {
    private DecimalFormat df = new DecimalFormat("0", DecimalFormatSymbols.getInstance(Locale.ENGLISH));

    public int solve(String[] A) {
        ArrayList<String> lst = new ArrayList<>(A.length);
        for (String st : A) lst.add(st);
        return solve(lst);
    }

    public int solve(ArrayList<String> A) {
        df.setMaximumFractionDigits(340); // 340 = DecimalFormat.DOUBLE_FRACTION_DIGITS
        Map<Bound, List<String>> buckets = new HashMap<>();
        double bucketStep = 2d;
        buckets.put(new Bound(0d, 2d), A.stream().filter(val -> val.compareTo("2") < 0)
                .collect(Collectors.toList()));
        int boundariesCheckResult;
        do {
            bucketStep /= 2;
            Map<Bound, List<String>> newBuckets = new HashMap<>(buckets.size() * 2);
            for (Bound key : buckets.keySet()) {
                Bound lowBound = new Bound(key.low, key.low + bucketStep);
                Bound highBound = new Bound(key.low + bucketStep, key.high);
                List<String> oldBucket = buckets.get(key);
                List<String> lowBoundV = new ArrayList<>(oldBucket.size());
                List<String> highBoundV = new ArrayList<>(oldBucket.size());
                for (String val : buckets.get(key)) {
                    if (val.compareTo(lowBound.sHigh()) <= 0) {
                        lowBoundV.add(val);
                    } else {
                        highBoundV.add(val);
                    }
                }
                if (!lowBoundV.isEmpty()) newBuckets.put(lowBound, lowBoundV);
                if (!highBoundV.isEmpty()) newBuckets.put(highBound, highBoundV);
            }
            buckets = newBuckets;
            boundariesCheckResult = sumExists(buckets);
        } while (boundariesCheckResult == 0);
        return boundariesCheckResult == 1 ? 1 : 0;
    }

    private int sumExists(Map<Bound, List<String>> vals) {
        List<Bound> possibleUsedValues = new ArrayList<>(vals.keySet().size() * 3);
        for (Bound key : vals.keySet()) {
            if (vals.get(key).size() > 2) {
                possibleUsedValues.add(key);
                possibleUsedValues.add(key);
                possibleUsedValues.add(key);
            } else {
                if (vals.get(key).size() == 1) {
                    possibleUsedValues.add(key);
                } else {
                    possibleUsedValues.add(key);
                    possibleUsedValues.add(key);
                }
            }
        }
        //build permutations
        Set<Bound> usedBounds = new HashSet<>();
        for (int a = 0; a < possibleUsedValues.size() - 2; a++) {
            for (int b = a + 1; b < possibleUsedValues.size() - 1; b++) {
                for (int c = b + 1; c < possibleUsedValues.size(); c++) {
                    double lowSum = possibleUsedValues.get(a).low + possibleUsedValues.get(b).low
                            + possibleUsedValues.get(c).low;
                    double highSum = possibleUsedValues.get(a).high + possibleUsedValues.get(b).high
                            + possibleUsedValues.get(c).high;
                    if (lowSum > 1d && highSum < 2d) {
                        return 1;
                    }
                    if (lowSum > 2 || highSum < 1) {
                        continue;
                    }
                    usedBounds.add(possibleUsedValues.get(a));
                    usedBounds.add(possibleUsedValues.get(b));
                    usedBounds.add(possibleUsedValues.get(c));
                }
            }
        }
        if (usedBounds.isEmpty()) return -1;
        //remove unused
        Map<Bound, List<String>> newMap = new HashMap<>(vals.size() - usedBounds.size());
        int amount = 0;
        for (Bound bound : usedBounds) {
            amount += vals.get(bound).size();
            newMap.put(bound, vals.get(bound));
        }
        if (amount < 3) return -1;
        vals.clear();
        vals.putAll(newMap);
        return 0;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.solve(new String[]{"0.6", "0.7", "0.8", "1,2", "0.4"}));
        System.out.println(sl.solve(new String[]{"0.6", "0.7", "0.8", "1,2"}));
        System.out.println(sl.solve(new String[]{"0.503094", "0.648924", "0.999298"}));
    }

    class Bound {
        double low;
        double high;

        Bound(double low, double high) {
            this.low = low;
            this.high = high;
        }

        String sLow() {
            return df.format(low);
        }

        String sHigh() {
            return df.format(high);
        }

        @Override
        public int hashCode() {
            return Double.hashCode(low + 2d * high);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Bound)) return false;
            Bound b = (Bound) obj;
            return b.low == low && b.high == high;
        }
    }
}
