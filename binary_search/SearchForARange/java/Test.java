import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(5);
        a.add(6);
        a.add(7);
        a.add(8);
        a.add(8);
        a.add(10);
        System.out.println("Range search: " 
                + (Arrays.equals(sl.searchRange(a, 8).toArray(),
                    new Integer[] {3,4}) ? "SUCCESS" : "FAILED"));
    }
}
