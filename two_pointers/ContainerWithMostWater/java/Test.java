import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> A = new ArrayList<>();
        arrToList(A, new int[]{1, 5, 4, 3});
        System.out.println("Container with the most water: "
                + (sl.maxArea(A) == 6
                    ? "SUCCESS" : "FAILED"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
