/**
 * Given an input string (s) and a pattern (p), implement 
 * regular expression matching with support for '.' and '*' where: 
 *     '.' Matches any single character.​​​​
 *     '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <br>
 * https://leetcode.com/problems/regular-expression-matching/
 */
class Solution {
  fun isMatch(s: String, p: String): Boolean = isMatch(s, p, 0, 0)
    
  fun isMatch(s: String, p: String, si: Int, pi: Int): Boolean {
    if(pi >= p.length) {
      if(si >= s.length) return true
      return false
    }
    val ch = p[pi]
    val mult = if(pi + 1 >= p.length) false else p[pi + 1] == '*'
    if(!mult) {
      if(si >= s.length) return false
      else return (s[si] == ch || ch == '.') && isMatch(s, p, si + 1, pi + 1)
    }
    //we have a multi-match
    if(si >= s.length) return isMatch(s, p, si, pi + 2)
    //si < s.length
    val chs = s[si]
    var i = si
    if(ch == '.') {
      while(i < s.length) {
        if(isMatch(s, p, i++, pi + 2)) return true
      }
    } else if(ch == chs) {
      while(i < s.length && chs == s[i]) {
        if(isMatch(s, p, i++, pi + 2)) return true
      }
    }
    return isMatch(s, p, i, pi + 2)
  }
}

fun main() {
    println("Regular Expression Matching: test is not implemented")
} 
