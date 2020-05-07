public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        boolean success = true;
        var h = new Solution.TreeNode(1);
        h.left = new Solution.TreeNode(2);
        h.right = new Solution.TreeNode(3);
        h.left.right = new Solution.TreeNode(4);
        h.right.left = new Solution.TreeNode(5);
        success = success && !sl.isCousins(h, 2, 3);
        success = success && !sl.isCousins(h, 4, 3);
        success = success && sl.isCousins(h, 4, 5);
        System.out.println("Cousins nodes: " +
                (success ? "SUCCESS" : "FAILED"));
    }
}
