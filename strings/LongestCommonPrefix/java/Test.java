import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<String> a = new ArrayList<>();
        a.add("ab");
        a.add("abcefgh");
        System.out.println("Longest common prefix: " +
                (sl.longestCommonPrefix(a).equals("ab") 
                 ? "SUCCESS" : "FAIL"));
    }
}
