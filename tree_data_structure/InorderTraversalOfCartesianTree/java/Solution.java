import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 * <br/>
 * https://www.interviewbit.com/problems/inorder-traversal-of-cartesian-tree/
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A) {
        if (A == null || A.isEmpty()) return null;
        int i = A.size() - 1;
        Deque<TreeNode> heads = new ArrayDeque<>();
        TreeNode iPlusOne = new TreeNode(A.get(i--));
        while (i >= 0) {
            if (A.get(i) < iPlusOne.val) {
                heads.push(iPlusOne);
                iPlusOne = new TreeNode(A.get(i));
                i--;
                continue;
            }
            if (heads.isEmpty() || A.get(i) < heads.peek().val) {
                TreeNode node = new TreeNode(A.get(i));
                node.right = iPlusOne;
                iPlusOne = node;
                i--;
                continue;
            }
            if (A.get(i) > heads.peek().val) {
                TreeNode node = heads.pop();
                node.left = iPlusOne;
                iPlusOne = node;
            }
        }
        while (!heads.isEmpty()) {
            TreeNode node = heads.pop();
            node.left = iPlusOne;
            iPlusOne = node;
        }
        return iPlusOne;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
