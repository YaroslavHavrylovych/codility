import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Jewellery {
    public long splitJewellery(int[] jewellery) {
        Arrays.sort(jewellery);
        println(Arrays.toString(jewellery));
        long last = 1 << jewellery.length;
        Map<Integer, List<JewelleryDesc>> results = new HashMap<>();
        for(long i = 1; i < last; i++)
            calculateDesc(i, jewellery, results);
        return calcualteOutcomes(jewellery, results);
    }

    private void calculateDesc(long val, int[] jewellery,
            Map<Integer, List<JewelleryDesc>> results) {
        long current = 1;
        int i = 0;
        int first = -1;
        int last = i;
        int sum = 0;
        while(current <= val) {
            if((current & val) == current) {
                sum += jewellery[i];
                last = i;
                first = first == -1 ? i : first;
            }
            i++;
            current = current << 1;
        }
        List<JewelleryDesc> sums = results.get(sum);
        sums = sums == null ? new ArrayList<JewelleryDesc>() : sums;
        sums.add(new JewelleryDesc(first, last, val));
        results.put(sum, sums);
    }

    private int calcualteOutcomes(int[] jewellery,
            Map<Integer, List<JewelleryDesc>> results) {
        int res = 0;
        for(Integer key: results.keySet()) {
            List<JewelleryDesc> jewelleryDesc = results.get(key);
            for(int i = 0; i < jewelleryDesc.size(); i++) {
                for(int j = i+1; j < jewelleryDesc.size(); j++) {
                    long val1 = jewelleryDesc.get(i).val;
                    long val2 = jewelleryDesc.get(j).val;
                    int highest1 = jewellery[jewelleryDesc.get(i).highestOne];
                    int highest2 = jewellery[jewelleryDesc.get(j).highestOne];
                    int lowest1 = jewellery[jewelleryDesc.get(i).lowestOne];
                    int lowest2 = jewellery[jewelleryDesc.get(j).lowestOne];
                    if(highest1 <= lowest2 && (val1 & val2) == 0) {
                        if(highest2 == lowest1) res++;
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private void println(String str) {
        System.out.println(str);
    }

    public static void main(String[] args) {
        //int[] jewellery = new int[] {1,2,5,3,4,5};
        //int[] jewellery = new int[] {1,2,5,3,4};
        int[] jewellery = new int[] {7,7,8,9,10,11,1,2,2,3,4,5,6};
        System.out.println("Possible outcomes: "  
                + new Jewellery().splitJewellery(jewellery));
    }

    private class JewelleryDesc {
        int lowestOne;
        int highestOne;
        long val;

        private JewelleryDesc(int lowestOne, int highestOne, long val) {
            this.lowestOne = lowestOne;
            this.highestOne = highestOne;
            this.val = val;
        }
    }
}
