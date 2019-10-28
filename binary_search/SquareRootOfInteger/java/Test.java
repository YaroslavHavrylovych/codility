public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println("Square root: "
                + (sl.sqrt(3) == 1 
                    && sl.sqrt(7) == 2
                    && sl.sqrt(100_00) == 100 
                    ? "SUCCESS" : "FAILED"));
    }
}
