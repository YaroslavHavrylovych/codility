import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        Solution.TreeNode tr;
        boolean success = true;
        ArrayList<Integer> inTemplate = new ArrayList<>();
        ArrayList<Integer> postTemplate = new ArrayList<>();
        arrToList(inTemplate, new int[]{2, 1, 3});
        arrToList(postTemplate, new int[]{2, 3, 1});
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        tr = sl.buildTree(inTemplate, postTemplate);
        in(tr, in);
        post(tr, post);
        success = success && Arrays.toString(in.toArray())
            .equals("[2, 1, 3]");
        success = success && Arrays.toString(post.toArray())
            .equals("[2, 3, 1]");

        in.clear();
        post.clear();
        arrToList(inTemplate, new int[]{4, 2, 1, 5, 3});
        arrToList(postTemplate, new int[]{4, 2, 5, 3, 1});
        tr = sl.buildTree(inTemplate, postTemplate);
        in(tr, in);
        post(tr, post);
        success = success && Arrays.toString(in.toArray())
            .equals("[4, 2, 1, 5, 3]");
        success = success && Arrays.toString(post.toArray())
            .equals("[4, 2, 5, 3, 1]");
        System.out.println("BT from in-order and post-order: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static void in(Solution.TreeNode a, List<Integer> lst) {
        if (a == null) return;
        in(a.left, lst);
        lst.add(a.val);
        in(a.right, lst);
    }

    private static void post(Solution.TreeNode a, List<Integer> lst) {
        if (a == null) return;
        post(a.left, lst);
        post(a.right, lst);
        lst.add(a.val);
    }

    private static void arrToList(List<Integer> lst, int[] a) {
        lst.clear();
        for (int value : a) lst.add(value);
    }
}
