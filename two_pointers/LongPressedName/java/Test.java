public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        boolean success = sl.isLongPressedName("alex", "aaleex");
        success = success && !sl.isLongPressedName("saeed", "ssaaedd");
        success = success && sl.isLongPressedName("leelee", "lleeelee");
        System.out.println("Long pressed name: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
