import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.IntStream;

public class Jewellery {
    public int calculatePossibleOutcomes(int[] jewellery) {
        Arrays.sort(jewellery);
        return calculateOutcome(jewellery, 0, 0, new ArrayList<>());
    }

    private int calculateOutcome(int jewellery[], int i1, int solutions, 
            List<List<Integer>> combinations) {
        int i2 = i1 + 1;
        while(i2 < jewellery.length && jewellery[i1] == jewellery[i2]) i2++;
        i2--;
        if(i2 >= jewellery.length) return solutions;
        int amount = i2 - i1 + 1;
        List<List<Integer>> newCombinations = 
            calculateIncrementalCombinations(jewellery[i2], amount, 
                    combinations);
        int newSolutions = solutions + 
            calculateIncrementalOutcomes(newCombinations, jewellery, i2 + 1);
        if(amount > 1) newSolutions += IntStream.rangeClosed(2, amount)
            .reduce(1, (a, b) -> a * b);
        combinations.addAll(newCombinations);
        return calculateOutcome(jewellery, i2 + 1, newSolutions, combinations);
    }

    private int calculateIncrementalOutcomes(List<List<Integer>> combinations,
            int[] jewellery, int ind) {
        if(ind >= jewellery.length) return 0;
        List<Integer> sums = new ArrayList<>(combinations.size());
        for(List<Integer> lst: combinations) sums.add(lst.stream()
                .mapToInt(Integer::intValue).sum());
        sums.sort(Integer::compareTo);
        int endInd = jewellery.length;
        int maxLeftSum = sums.get(sums.size() - 1);
        while(endInd > ind && jewellery[--endInd] > maxLeftSum);
        List<List<Integer>> variations = new ArrayList<>();
        for(int i = ind; i <= endInd && i < jewellery.length; i++) 
            variations.addAll(calculateIncrementalCombinations(jewellery[i], 
                        1, variations));
        List<Integer> bigSums = new ArrayList<>(variations.size());
        for(List<Integer> lst: variations) bigSums.add(lst.stream()
                .mapToInt(Integer::intValue).sum());
        int result = 0;
        for(int val: sums) result +=  Collections.frequency(bigSums, val);
        return result;
    }
    
    private List<List<Integer>> calculateIncrementalCombinations(int newVal,
            int amount,
            List<List<Integer>> combinations) {
        List<List<Integer>> newCombinations = new ArrayList<List<Integer>>(
                combinations.size() + 1);
        List<Integer> singleEl = new ArrayList<>(1);
        singleEl.add(newVal);
        for(int i = 0; i < amount; i++) newCombinations.add(singleEl);
        combinations.stream().forEach(el -> {
            List<Integer> lst = new ArrayList<>(el.size() + 1);
            lst.addAll(el);
            lst.add(newVal);
            for(int i = 0; i < amount; i++) 
                newCombinations.add(new ArrayList<>(lst));
        });
        return newCombinations;
    }

    public static void main(String[] args) {
        int[] jewellery = new int[] {1,2,5,3,4,5};
        System.out.println("Jewellery: "  + Arrays.toString(jewellery));
        System.out.println("Possible outcomes: "  + new Jewellery()
                .calculatePossibleOutcomes(jewellery));
    }
}
