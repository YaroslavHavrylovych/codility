import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 * https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/
 * <br/>
 * NOTE: use HashMap with depth as the key and child as List of nodes 
 * on this level. Then we can get children in reverse order by O(n).
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Deque<TreeNode> treeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        treeStack.push(A);
        depthStack.push(0);
        while (!treeStack.isEmpty()) {
            TreeNode curr = treeStack.pop();
            int depth = depthStack.pop();
            ArrayList<Integer> brothers;
            if (res.size() > depth) {
                brothers = res.get(depth);
            } else {
                brothers = new ArrayList<>();
                res.add(brothers);
            }
            brothers.add(curr.val);
            if (curr.left != null) {
                treeStack.push(curr.left);
                depthStack.push(depth + 1);
            }
            if (curr.right != null) {
                treeStack.push(curr.right);
                depthStack.push(depth + 1);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 == 0) {
                Collections.reverse(res.get(i));
            }
        }
        return res;
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


