import java.util.ArrayList;
import java.util.List;

/**
 * Given A, generate all structurally unique BST’s (binary search trees) that store values 1…A.
 * <br/>
 * Input Format:
 * The first and the only argument of input contains the integer, A.
 * <br/>
 * Output Format:
 * Return a list of tree nodes representing the generated BST's.
 * <br/>
 * https://www.interviewbit.com/problems/unique-binary-search-trees/
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int a) {
        ArrayList<TreeNode> res = new ArrayList<>();
        for (int v = 1; v <= a; v++) {
            res.addAll(generateTrees(1, v - 1, v, v + 1, a));
        }
        return res;
    }

    private List<TreeNode> generateTrees(int ll, int lh, int head, int hl, int hh) {
        List<TreeNode> res = new ArrayList<>();
        if (ll > lh && hl > hh) {
            res.add(createNode(head, null, null));
            return res;
        }
        List<TreeNode> leftPart = new ArrayList<>();
        for (int v = ll; v <= lh; v++) leftPart.addAll(generateTrees(ll, v - 1, v, v + 1, lh));
        List<TreeNode> rightPart = new ArrayList<>();
        for (int v = hl; v <= hh; v++) rightPart.addAll(generateTrees(hl, v - 1, v, v + 1, hh));
        if (leftPart.isEmpty() && !rightPart.isEmpty())
            for (TreeNode r : rightPart) res.add(createNode(head, null, r));
        else if (rightPart.isEmpty() && !leftPart.isEmpty())
            for (TreeNode l : leftPart) res.add(createNode(head, l, null));
        else if (!rightPart.isEmpty())
            for (TreeNode l : leftPart)
                for (TreeNode r : rightPart) res.add(createNode(head, l, r));
        return res;
    }

    private TreeNode createNode(int x, TreeNode l, TreeNode r) {
        TreeNode nd = new TreeNode(x);
        nd.left = l;
        nd.right = r;
        return nd;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) { val = x; }
    }
}

