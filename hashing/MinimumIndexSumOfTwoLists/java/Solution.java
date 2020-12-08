import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and 
 * they both have a list of favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least 
 * list index sum. If there is a choice tie between answers, output all 
 * of them with no order requirement. You could assume there 
 * always exists an answer.
 * <br/>
 * https://leetcode.com/problems/minimum-index-sum-of-two-lists/
 */
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m1 = new HashMap<>();
        for(int i = 0; i < list1.length; i++) m1.put(list1[i], i);
        int least = Integer.MAX_VALUE;
        List<String> res = new ArrayList<>();
        for(int i = 0; i < list2.length; i++) {
            Integer ind1 = m1.get(list2[i]);
            if(ind1 == null) continue;
            int sum = ind1 + i;
            if(sum < least) {
                res.clear();
                res.add(list2[i]);
                least = sum;
            } else if(sum == least) {
                res.add(list2[i]);
            }
        }
        return res.toArray(new String[0]);
    }
}
