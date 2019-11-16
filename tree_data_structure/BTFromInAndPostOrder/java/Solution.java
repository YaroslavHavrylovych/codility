import java.util.ArrayList;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note: You may assume that duplicates do not exist in the tree. 
 * <br/>
 * https://www.interviewbit.com/problems/binary-tree-from-inorder-and-postorder/
 */
public class Solution {
    public TreeNode buildTree(ArrayList<Integer> A, ArrayList<Integer> B) {
        return constructSub(A, B, 0, A.size() - 1, 0, A.size() - 1);
    }

    public TreeNode constructSub(ArrayList<Integer> A, ArrayList<Integer> B,
                                 int a1, int a2, int b1, int b2) {
        if (a1 > a2) return null;
        int b = B.get(b2);
        TreeNode head = new TreeNode(b);
        int newA1 = a1;
        for (int i = a2; i > a1; i--) if (A.get(i) == b) { newA1 = i; break; }
        head.right = constructSub(A, B, newA1 + 1, a2, b2 - (a2 - newA1), b2 - 1);
        head.left = constructSub(A, B, a1, newA1 - 1, b1, b2 - (a2 - newA1) - 1);
        return head;
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
