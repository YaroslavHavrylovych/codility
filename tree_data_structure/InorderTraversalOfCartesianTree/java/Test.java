import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        ArrayList<Integer> a = new ArrayList<>();
        arrToList(a, new int[]{1, 2, 3});
        Solution.TreeNode t = sl.buildTree(a);
        List<Integer> newList = new ArrayList<>(a.size());
        toList(t, newList);
        boolean success = Arrays.deepEquals(a.toArray(), newList.toArray());
        arrToList(a, new int[]{9, 3, 7, 1, 8, 12, 10, 20, 15, 18, 5});
        t = sl.buildTree(a);
        newList.clear();
        toList(t, newList);
        success = success && Arrays.deepEquals(a.toArray(), newList.toArray());
        System.out.println("Carthesian tree: " + 
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }

    private static void toList(Solution.TreeNode node, List<Integer> lst) {
        if (node == null) return;
        if (node.left != null) toList(node.left, lst);
        lst.add(node.val);
        if (node.right != null) toList(node.right, lst);
    }
}
