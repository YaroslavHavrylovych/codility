/**
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 * <br/>
 * https://www.interviewbit.com/problems/symmetric-binary-tree/
 */
fun isSymmetric(tree: TreeNode): Boolean = subSymmetry(tree.left, tree.right)

fun subSymmetry(l: TreeNode?, r: TreeNode?): Boolean = (l == r) //this only catches null or same objects
        || (l?.v == r?.v && subSymmetry(l?.left, r?.right) && subSymmetry(l?.right, r?.left))

class TreeNode(val v: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

//Test
fun main() {
    var t = TreeNode(1)
    var success = true
    t.left = TreeNode(2)
    t.right = TreeNode(2)
    t.left!!.left = TreeNode(3)
    t.left!!.right = TreeNode(4)
    t.right!!.right = TreeNode(3)
    t.right!!.left = TreeNode(4)
    success = success && isSymmetric(t)
    t = TreeNode(1)
    t.left = TreeNode(2)
    t.right = TreeNode(2)
    t.left!!.left = TreeNode(3)
    t.right!!.right = TreeNode(3)
    t.right!!.left = TreeNode(4)
    success = success && isSymmetric(t) == false
    t = TreeNode(1)
    t.left = TreeNode(2)
    t.right = TreeNode(2)
    t.left!!.left = TreeNode(3)
    t.right!!.left = TreeNode(3)
    success = success && isSymmetric(t) == false
    println("Symmetric tree: ${if (success) "SUCCESS" else "FAIL"}")
}

