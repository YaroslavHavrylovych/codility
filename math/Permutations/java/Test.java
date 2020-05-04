import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        var success = sl.permute(new int[] {1,2,3}).size() == 6;
        success = success && sl.permute(new int[] {1,2,3,4}).size() == 24;
        success = success && sl.permute(new int[] {1,2,3,4,5}).size() == 120;
        System.out.println("All permutations: " + 
                (success ? "SUCCESS" : " FAILED"));
    }
}

