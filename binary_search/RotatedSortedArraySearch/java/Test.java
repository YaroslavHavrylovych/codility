import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{6, 7, 0, 1, 2, 3, 4});
        System.out.println("Rotated index: " + 
                (sl.search(a, 7) == 1 ? "SUCCESS" : "FAILED"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
