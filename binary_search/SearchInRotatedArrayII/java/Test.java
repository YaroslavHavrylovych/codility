import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        var success = true;
        success = success && sl.search(new int[] {2,5,6,0,0,1,2}, 0);
        success = success && !sl.search(new int[] {2,5,6,0,0,1,2}, 3);
        System.out.println("Rotated Search II: " + 
                (success ? "SUCCESS" : " FAILED"));
    }
}

