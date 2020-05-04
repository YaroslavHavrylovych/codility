import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * Example:
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 * <br />
 * https://leetcode.com/problems/permutations/
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length == 0) return res;
        if(nums.length == 1) { res.add(Arrays.asList(nums[0])); return res; }
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int el : nums) numList.add(el);
        res.addAll(permute(new ArrayList<>(), numList));
        return res;
    }

    private List<List<Integer>> permute(List<Integer> prefix, List<Integer> nums) {
        if (nums.size() == 2) return permuteLast2(prefix, nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> newPrefix = new ArrayList<>(prefix.size() + 1);
            newPrefix.addAll(prefix);
            List<Integer> newNums = new ArrayList<>(nums);
            newPrefix.add(newNums.remove(i));
            res.addAll(permute(newPrefix, newNums));
        }
        return res;
    }

    private List<List<Integer>> permuteLast2(List<Integer> prefix,
            List<Integer> nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> perm1 = new ArrayList<>(prefix.size() + 2);
        List<Integer> perm2 = new ArrayList<>(prefix.size() + 2);
        perm1.addAll(prefix);
        perm2.addAll(prefix);
        perm1.addAll(nums);
        perm2.add(nums.get(1));
        perm2.add(nums.get(0));
        res.add(perm1);
        res.add(perm2);
        return res;
    }
}
