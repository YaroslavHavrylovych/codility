public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        Solution.TreeNode tr = new Solution.TreeNode(10);
        tr.left = new Solution.TreeNode(9);
        tr.right = new Solution.TreeNode(20);
        System.out.println("2 Sum: " +
                (sl.t2Sum(tr, -1) == 0 ? "SUCCESS" : "FAIL"));
    }
}
