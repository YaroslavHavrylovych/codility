public class Test {
    public static void main(String... args) {
        boolean success = new Solution().generateTrees(3).size() == 5
                && new Solution().generateTrees(11).size() == 58786;
        System.out.println("Unique binary search tries: " + (success ? "SUCCESS" : "FAILED"));
    }
}
