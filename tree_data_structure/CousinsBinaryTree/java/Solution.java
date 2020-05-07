/**
 * In a binary tree, the root node is at depth 0, and children of each
 * depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth,
 * but have different parents.
 * We are given the root of a binary tree with unique values,
 * and the values x and y of two different nodes in the tree.
 * <br/>
 * Return true if and only if the nodes corresponding to
 * the values x and y are cousins.
 * <br/>
 * https://leetcode.com/problems/cousins-in-binary-tree/
 */
public class Solution {
    TreeNode pnx = null;
    TreeNode pny = null;
    
    Integer px = null;
    Integer py = null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        px = null;
        py = null;
        pnx = null;
        pny = null;
        if(root.val == x || root.val == y) return false;
        isCousins(root, null, x, y, 0);
        return px != null && px.equals(py) && pnx != pny;
    }
    
    private void isCousins(TreeNode current, TreeNode parent, int x, int y, int level) {
        if(current == null || (px != null && py != null)) return;
        if(current.val == x) {
            px = level;
            pnx = parent;
            if(py != null) return;
        } else if(current.val == y) {
            py = level;
            pny = parent;
            if(px != null) return;
        }
        isCousins(current.left, current, x, y, level + 1);
        isCousins(current.right, current, x, y, level + 1);
    }

    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
}
