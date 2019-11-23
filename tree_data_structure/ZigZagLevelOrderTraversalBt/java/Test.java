import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        Solution.TreeNode nd = new Solution.TreeNode(3);
        nd.left = new Solution.TreeNode(9);
        nd.right = new Solution.TreeNode(20);
        nd.right.left = new Solution.TreeNode(15);
        nd.right.right = new Solution.TreeNode(7);

        StringBuilder strBld = new StringBuilder();
        ArrayList<ArrayList<Integer>> res = sl.zigzagLevelOrder(nd);
        for (ArrayList<Integer> lst : res) 
            for (int i : lst) 
                strBld.append(" ").append(i);
        boolean success = strBld.toString().equals(" 3 20 9 15 7");
        System.out.println("ZigZag traversal: " +
                (success ? "SUCCESS" : "FAIL"));
    }

}
