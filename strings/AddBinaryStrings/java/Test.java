public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        boolean success = sl.addBinary("1111", "1").equals("10000");
        success = success && sl.addBinary("0", "1").equals("1");
        success = success && sl.addBinary("0", "0").equals("0");
        success = success && sl.addBinary("1", "1").equals("10");
        System.out.println("Add binary: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
