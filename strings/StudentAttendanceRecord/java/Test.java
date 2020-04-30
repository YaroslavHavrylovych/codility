public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        boolean success = sl.checkRecord("PPALLP");
        success = success && !sl.checkRecord("PPALLL");
        System.out.println("Student attendance: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
