import java.util.Arrays;

class BruteForce {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
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
        System.out.println("TwoSums succeed");
    }

    private static void assertResults(int[] a, int t) {
        BruteForce solution = new BruteForce();
        int[] res = solution.twoSum(a, t);
        boolean result = a[res[0]] + a[res[1]] == t;
        if(!result) {
            System.out.println("Fails on " + Arrays.toString(a)
                    + " with target " + t);
        }
        assert result : "assertion fails";
    }
}
