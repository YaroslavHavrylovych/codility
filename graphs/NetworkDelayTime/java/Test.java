import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        var sl = new Solution();
        boolean success = sl.networkDelayTime(
                new int[][] {{2,1,1}, {2,3,1}, {3,4,1}}, 4, 2) == 2;
        System.out.println("Network delay time: " +
                (success ? "SUCCESS" : "FAIL"));
    }
}
