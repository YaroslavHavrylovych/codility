public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        var success = sl.canWinNim(4) == false;
        success = success || sl.canWinNim(7);
        System.out.println("Min game: " + (success ? "SUCCESS" : "FAIL"));
    }
}
