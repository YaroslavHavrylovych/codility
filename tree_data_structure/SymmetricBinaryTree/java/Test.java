public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        Solution.TreeNode a = new Solution.TreeNode(1);
        a.left = new Solution.TreeNode(2);
        a.right = new Solution.TreeNode(2);
        a.left.left = new Solution.TreeNode(3);
        a.right.right = new Solution.TreeNode(3);
        System.out.println("Symetric tree: " +
                (sl.isSymmetric(a) == 1 ? "SUCCESS" : "FAIL"));
    }
}
