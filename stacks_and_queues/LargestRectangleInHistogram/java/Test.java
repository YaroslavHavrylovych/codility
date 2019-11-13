import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{4, 1, 5, 6, 2, 3});
        boolean success = sl.largestRectangleArea(a) == 10;
        arrToList(a, new int[]{90, 58, 69, 70, 82, 100, 13, 57, 47, 18});
        success = success && sl.largestRectangleArea(a) == 348;
        System.out.println("Largest rectangle: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
