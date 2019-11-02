import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> A = new ArrayList<>();
        arrToList(A, new int[]{1, 1, 0, 1, 1, 0, 0, 1, 1, 1});
        boolean success = equals(sl.maxone(A, 1), new int[]{0, 1, 2, 3, 4});
        arrToList(A, new int[]{1, 0, 0, 1, 1, 0, 0, 1, 1, 1});
        success = success && equals(sl.maxone(A, 1), new int[]{6, 7, 8, 9});
        System.out.println("Max 1s: " +
                (success ? "SUCCESS" : "FAILED"));
    }

    private static boolean equals(List<Integer> a, int[] b) {
        if(a.size() != b.length) return false;
        for(int i = 0; i < a.size(); i++) {
            if(!a.get(i).equals(b[i])) return false;
        }
        return true;
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
