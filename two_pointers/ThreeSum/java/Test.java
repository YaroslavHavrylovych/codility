import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{-1, 2, 1, -4});
        boolean success = sl.threeSumClosest(a, 2) == 2;
        arrToList(a, new int[]{5, -2, -1, -10, 10});
        success = success && (sl.threeSumClosest(a, 5) == 5);
        arrToList(a, new int[]{-10, -10, -10});
        success = success && (sl.threeSumClosest(a, -5) == -30);
        System.out.println("3 sum: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
