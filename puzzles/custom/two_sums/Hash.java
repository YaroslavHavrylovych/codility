import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Hash {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) return new int[] {i, map.get(nums[i])};
            else map.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println("Checking TwoSums");
        assertResults(new int[]{2, 7, 11, 15}, 9);
        assertResults(new int[]{15, 11, 7, 2}, 9);
        assertResults(new int[]{11, -2, 11, 15, 15, 9, 9, 7}, 7);
        assertResults(new int[]{2, 7, 11, 15}, 18);
        assertResults(new int[]{7, 2, 7, -7, 11, 15}, -5);
        assertResults(new int[]{7, 2, 7, -7, 11, 15, 7, 2, 7, -7, 11, 15, 7,
            2, 7, -7, 11, 15, 2, 7, -7, 11, 15, 2, 9, 9, 11, 5}, 2);
        assertResults(new int[]{3, 2, 4}, 6);
        System.out.println("TwoSums succeed");
    }

    private static void assertResults(int[] a, int t) {
        Hash solution = new Hash();
        int[] res = solution.twoSum(a, t);
        boolean result = a[res[0]] + a[res[1]] == t && res[0] != res[1];
        if(!result) {
            System.out.println("Fails on " + Arrays.toString(a)
                    + " with target " + t);
        }
        assert result : "assertion fails";
    }
}
