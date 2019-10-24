import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{640, 435, 647, 352, 8, 90, 960, 329, 859});
        ArrayList<Integer> b = new ArrayList<>();
        arrToList(b, new int[]{1000000, 1000000});
        System.out.println(sl.paint(3, 10, a) == 17220 
                && sl.paint(1, 1000000, b) == 9400003 ?
                "Painters problem: SUCCESS" : "Painters problem: FAILED");
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int i = 0; i < a.length; i++) {
            lst.add(a[i]);
        }
    }
}
