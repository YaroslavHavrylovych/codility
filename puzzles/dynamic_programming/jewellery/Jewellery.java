import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;
import java.util.Map;
import java.util.HashMap;

public class Jewellery {
    public int calculatePossibleOutcomes(int[] jewellery) {
        Arrays.sort(jewellery);
        System.out.println("Jewellery: "  + Arrays.toString(jewellery));
        return calculateCombinations(new HashMap<>(), jewellery, 0, 1);
    }

    /**
     * Calculate amount of combinations.
     * <br/>
     * Each combination presented as a sum. 
     * Sum - a key in `sums` argument.
     * Value in sums argument represents amount of such sums (different
     * combinations with same sum).
     * <br/>
     *
     * @param sums map which contains existing sum as a key and amount
     * of such sums as a value
     * @param jewellery jewellery values. Each jewellery value only once
     * can be used in combination
     * @param maxValue the biggest key in sums
     * @param startInd start index marks the smallest index in jewellery
     * array which we can use in combinations
     *
     * @return amount of combinations which can be generated for each
     * possible sums key.
     */
    private int calculateCombinations(Map<Integer, Integer> sums,
            int[] jewellery, int maxValue, int startInd) {
        if(startInd == jewellery.length) return 0;
        int val = jewellery[startInd - 1];
        maxValue += maxValue + val;
        sums = updateSums(sums, val);
        System.out.println();
        int comb = calculateCombinations(sums, jewellery, maxValue, 
                startInd, 0);
        System.out.println("At the moment combinations " + startInd 
                + ": " + comb);
        System.out.println("start value: " + jewellery[startInd]);
        System.out.println("At the moment sums: " 
                + Arrays.toString(sums.keySet().toArray()));
        System.out.println("At the moment vals: " 
                + Arrays.toString(sums.values().toArray()));
        //int multiplier = calculateMiltiplierForCombination(jewellery,
                //startInd);
        System.out.println("mult=" + multiplier);
        return  comb + calculateCombinations(sums, jewellery,
                maxValue, startInd + 1);
    }

    /** Calculate amount of possible combinations (look combination in math) */
    private int calculateMiltiplierForCombination(int[] jewellery,
            int startInd) {
        int combStartInd = startInd;
        while(combStartInd >= 0) {
            if(jewellery[startInd] == jewellery[combStartInd]) combStartInd--;
            else break;
        }
        combStartInd++;
        int combEndInd = startInd;
        while(combEndInd < jewellery.length) {
            if(jewellery[startInd] == jewellery[combEndInd]) combEndInd++;
            else break;
        }
        combEndInd--;
        int n = combEndInd - combStartInd + 1;
        int k = startInd - combStartInd + 1;
        System.out.println("multiplier n, k " + n + ", " + k);
        return fact(n) / (fact(k) * fact(n - k));
    }

    private int fact(int n) {
        int f = 1;
        for(int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    /**
     * Calculates new sums if we add one more value to the sequence.
     *
     * @param sums old sums values
     * @param jewellery new value to add to the sequence
     *
     * @return all possible sums of the collection with appended
     * jewellery value.
     */
    private Map<Integer, Integer> updateSums(Map<Integer, Integer> sums,
            int jewellery) {
        Map<Integer, Integer> newSums = new HashMap<>(sums);
        //feed newSum with (oldVal+jewellery)
        for(Map.Entry<Integer, Integer> entry: sums.entrySet()) {
            int sum = entry.getKey();
            sum += jewellery;
            Integer amount = sums.get(sum);
            newSums.put(sum, entry.getValue() 
                    + (amount == null ?  0 : amount));
        }
        //add to newSum values which can't be represented as (oldVal+jewellery)
        for(Map.Entry<Integer, Integer> entry: sums.entrySet()) {
            Integer amount = newSums.get(entry.getKey());
            if(amount == null) newSums.put(entry.getKey(), entry.getValue());
        }
        //add jewellery itself
        if(newSums.get(jewellery) == null) newSums.put(jewellery, 1);
        else newSums.put(jewellery, newSums.get(jewellery) + 1);
        return newSums;
    }

    /**
     * Very similar to {@link calculateCombinations} with startInd param,
     * the difference is that this method has current sum value and current
     * index we must use in our combination.
     */
    private int calculateCombinations(Map<Integer, Integer> sums,
            int[] jewellery, int maxValue, int currentInd, int currentSum) {
        currentSum += jewellery[currentInd];
        if(currentSum > maxValue) return 0; //first of right > sum in the left
        Integer amount = sums.get(currentSum);
        if(amount == null) amount = 0;
        else {System.out.println("ind=" + currentInd + ",currentSum=" + currentSum);}
        for(int i = currentInd + 1; i < jewellery.length; i++)
            amount += calculateCombinations(sums, jewellery, maxValue, 
                    i, currentSum);
        return amount;
    }

    public static void main(String[] args) {
        int[] jewellery = new int[] {1,1,1};
        System.out.println("Possible outcomes: "  + new Jewellery()
                .calculatePossibleOutcomes(jewellery));
    }
}
