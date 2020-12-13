/**
 * Given a string s and an integer k. 
 * Return the maximum number of vowel letters in any 
 * substring of s with length k.
 * Vowel letters in English are (a, e, i, o, u).
 * <br>
 * https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
 */
class Solution {
  val vows = setOf('a', 'e', 'i', 'o', 'u')
  
  fun maxVowels(s: String, k: Int): Int {
    //init
    var cVow = 0
    var i = 0
    while(i < k) {
      if(vows.contains(s[i])) cVow += 1
      i += 1
    }
    var max = cVow
    while(i < s.length) {
      if(vows.contains(s[i - k])) cVow -= 1
      if(vows.contains(s[i])) cVow += 1
      if(cVow > max) max = cVow
      i += 1
    }
    return max
  }
}

fun main() {
    println("Maximum Number of Vowels in a Substring of Given Length" +
        ": test is not implemented")
} 
