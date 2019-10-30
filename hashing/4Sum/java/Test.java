import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 0, -1, 0, -2, 2});
        ArrayList<ArrayList<Integer>> res = sl.fourSum(a, 0);
        System.out.print("4Sum: ");
        if(equals(new Integer[]{-2,-1,1,2}, res.get(0).toArray())
                && equals(new Integer[]{-2,0,0,2}, res.get(1).toArray())
                && equals(new Integer[]{-1,0,0,1}, res.get(2).toArray())) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }

    private static boolean equals(Object[] a, Object[] b) {
        return Arrays.equals(a,b);
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
