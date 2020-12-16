/**
 * Given a binary tree where node values are digits from 1 to 9. 
 * A path in the binary tree is said to be pseudo-palindromic 
 * if at least one permutation of the node values in the path is a palindrome.
 * Return the number of pseudo-palindromic paths going 
 * from the root node to leaf nodes.
 * <br/>
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * <br/>
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 */
class Solution {
  var res = 0
  lateinit var mp: MutableMap<Int, Int>
  
  fun pseudoPalindromicPaths(root: TreeNode?): Int {
      res = 0
      if (root == null) return 0
      mp = HashMap<Int, Int>()
      if (root.left == null && root.right == null) return 1
      help(root)
      return res
  }
  
  private fun help(n: TreeNode) {
      mp.put(n.`val`, mp.getOrDefault(n.`val`, 0) + 1)
      if (n.left != null) {
          help(n.left!!)
      }
      if (n.right != null) {
          help(n.right!!)
      }
      if (n.left == null && n.right == null) {
          //check if pseudo pal
          if (isPal()) res += 1
      }
      //remove from the map, we are going home
      val amount = mp.get(n.`val`)!! - 1
      if (amount == 0) mp.remove(n.`val`)
      else mp.put(n.`val`, amount)
  }
  
  private fun isPal(): Boolean {
      var nonDiv = true
      for (v in mp.values) {
          if (v % 2 != 0) {
              if (nonDiv) {
                  nonDiv = false
                  continue
              }
              return false
          }
      }
      return true
  }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    println("Pseudo-Palindromic Paths in a Binary Tree" +
        ": test is not implemented")
} 
