import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution(3, new int[] {5, 8, 1, 7});
        var success = sl.add(6) == 6;
        success = success && sl.add(9) == 7;
        System.out.println("K-th largest: " + 
                (success ? "SUCCESS" : " FAILED"));
    }
}

