/**
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 * <br/>
 * https://www.interviewbit.com/problems/symmetric-binary-tree/
 */
public class Solution {
    public int isSymmetric(TreeNode A) {
        if (A == null) return 1;
        return checkSymmetry(A.left, A.right) ? 1 : 0;
    }

    private boolean checkSymmetry(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a != null && b != null) {
            if (a.val != b.val) return false;
            return checkSymmetry(a.left, b.right) && checkSymmetry(a.right, b.left);
        } else {
            return false;
        }
    }

    static class TreeNode {
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


