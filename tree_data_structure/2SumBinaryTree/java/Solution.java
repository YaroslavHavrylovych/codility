/** 
 * Given a binary search tree T, where each node contains a positive integer, 
 * and an integer K, you have to find whether or not there exist 
 * two different nodes A and B such that A.value + B.value = K.  
 * Return 1 to denote that two such nodes exist. Return 0, otherwise.  
 * <br>/
 * Notes:
 * <ul>
 * <li>Your solution should run in linear time and not take memory
 * more than O(height of T).</li>
 * <li>Assume all values in BST are distinct.</li>
 * </ul>
 * <br/>
 * https://www.interviewbit.com/problems/2sum-binary-tree/
 */
public class Solution {
    public int t2Sum(TreeNode A, int B) {
        if (A == null) return 0;
        if (solutionExist(A, A, B)) return 1;
        return 0;
    }

    public boolean solutionExist(TreeNode left, TreeNode right, int B) {
        if (left == null || right == null) return false;
        int sum = left.val + right.val;
        if (sum == B) {
            if (left == right) return false;
            return true;
        }
        if (sum - B < 0) {
            return solutionExist(left, right.right, B)
                    || solutionExist(left.right, right, B);
        }
        return solutionExist(left, right.left, B)
                || solutionExist(left.left, right, B);
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
