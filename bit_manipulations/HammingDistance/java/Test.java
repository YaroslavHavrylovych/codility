public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        var success = sl.hammingDistance(1, 3) == 1;
        success = success | sl.hammingDistance(10, 0) == 2;
        System.out.println("Hamming distance: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
