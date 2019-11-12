public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        boolean success = sl.solve("AAAAAA") == 0
            && sl.solve("ABC") == 2
            && sl.solve("AACECAAAA") == 2
            && sl.solve("AACEAAAA") == 6
            && sl.solve("AA") == 0
            && sl.solve("AAA") == 0
            && sl.solve("AB") == 1;
        System.out.println("Minimum chars to the palindrome: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
