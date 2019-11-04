import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{0, 1, 2, 0, 1, 2});
        sl.sortColors(a);
        System.out.println("Color sort: " +
                (equals(a, new int[] {0, 0, 1, 1, 2, 2})
                        ? "SUCCESS" : "FAIL"));
    }

    private static boolean equals(List<Integer> a, int[] b) {
        if(a.size() != b.length) return false;
        for(int i = 0; i < b.length; i++)
            if(!a.get(i).equals(b[i])) return false;
        return true;
    }


    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
