import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        //new
        arrToList(a, new int[]{-1, -2, -3, 0, 1, 2, 5, 6, 7, 8, 8});
        boolean success = sl.longestConsecutive(a) == 6;
        arrToList(a, new int[]{1, 2, 5, 6, 7, 8, 8});
        success = success && sl.longestConsecutive(a) == 4;
        arrToList(a, new int[]{-1, -2});
        success = success && sl.longestConsecutive(a) == 2;
        System.out.println("Longest sequence: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
