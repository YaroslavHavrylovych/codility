import java.util.ArrayDeque
/**
 * Given an input string (s) and a pattern (p), implement 
 * regular expression matching with support for '.' and '*' where: 
 *     '.' Matches any single character.​​​​
 *     '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <br/>
 * https://leetcode.com/problems/valid-parentheses/
 */
class Solution {
    val cl = hashMapOf(Pair(')', '('), Pair('}', '{'), Pair(']', '['))
    
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>(s.length / 2 + 1)
        var tmp: Char?
        for(ch in s) {
            tmp = cl[ch]
            if(tmp == null) {
                stack.push(ch)
            } else {
                if(stack.isEmpty()) return false
                if(stack.pop() != tmp) return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    println("Valid Parentheses: test is not implemented")
} 
