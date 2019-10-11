/**
 * https://www.interviewbit.com/problems/balanced-binary-tree/
 */
public class Solution {
    public int isBalanced(TreeNode A) {
        if (A == null) return 1;
        int depth = getDepth(A, 0);
        return depth > 0 ? 1 : 0;
    }

    private int getDepth(TreeNode A, int depth) {
        if (A == null) return depth;
        int leftDepth = getDepth(A.left, depth + 1);
        if (leftDepth == -2) return -2;
        int rightDepth = getDepth(A.right, depth + 1);
        if (rightDepth == -2) return -2;
        if (Math.abs(leftDepth - rightDepth) <= 1) return Math.max(leftDepth, rightDepth);
        return -2;
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

    public static void main(String[] args) {
        Solution sl = new Solution();
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.right.left = new TreeNode(4);
        System.out.println(sl.isBalanced(a));
        a = new TreeNode(1);
        a.left = new TreeNode(2);
        a.right = new TreeNode(3);
        a.left.left = new TreeNode(4);
        a.left.right = new TreeNode(5);
        a.left.left.left = new TreeNode(7);
        a.left.left.right = new TreeNode(8);
        a.right.right = new TreeNode(6);
        System.out.println(sl.isBalanced(a));
    }
}


