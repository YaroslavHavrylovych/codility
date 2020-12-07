import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a string, find the length of the longest substring without 
 * repeating characters.
 * <br/>
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        Map<Character, List<Integer>> repeatTable = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            List<Integer> lst = repeatTable.getOrDefault(ch, new ArrayList<>());
            lst.add(i);
            repeatTable.put(ch, lst);
        }
        int longest = 1;
        int currentLength = 1;
        for (int i = 1; i < s.length(); i++) {
            Character ch = s.charAt(i);
            List<Integer> lst = repeatTable.get(ch);
            int lastOccurInd = java.util.Collections.binarySearch(lst, i - 1);
            lastOccurInd = lastOccurInd > 0 ? lastOccurInd
                    : -(lastOccurInd + 2);
            int lastOccur = lst.get(lastOccurInd < 0 ? 0 : lastOccurInd);
            if (i > lastOccur && s.charAt(i) == s.charAt(lastOccur) && i - lastOccur <= currentLength) {
                if (longest < currentLength) {
                    longest = currentLength;
                }
                currentLength = i - lastOccur;
            } else {
                currentLength++;
            }
        }
        return longest < currentLength ? currentLength : longest;
    }
}
