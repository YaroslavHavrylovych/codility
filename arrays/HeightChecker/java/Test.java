public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        boolean success = sl.heightChecker(new int[] {1,1,4,2,1,3}) == 3;
        success = success && sl.heightChecker(new int[] {5,1,2,3,4}) == 5;
        System.out.println("Long pressed name: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
