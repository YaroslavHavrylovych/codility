/**
 * Roman numerals are represented by seven different symbols: 
 * I, V, X, L, C, D and M.
 *     Symbol       Value
 *     I             1
 *     V             5
 *     X             10
 *     L             50
 *     C             100
 *     D             500
 *     M             1000
 * For example, 2 is written as II in Roman numeral, just two one's 
 * added together. 12 is written as XII, which is simply X + II. 
 * The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right. 
 * However, the numeral for four is not IIII. Instead, 
 * the number four is written as IV. Because the one is before 
 * the five we subtract it making four. 
 * The same principle applies to the number nine, which is written as IX. 
 * There are six instances where subtraction is used:
 *     I can be placed before V (5) and X (10) to make 4 and 9. 
 *     X can be placed before L (50) and C (100) to make 40 and 90. 
 *     C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 * <br/>
 * https://leetcode.com/problems/roman-to-integer/
 */
class Solution {
    val sing = hashMapOf(
        Pair('I', 1), Pair('V', 5), Pair('X', 10), Pair('L', 50),
        Pair('C', 100), Pair('D', 500), Pair('M', 1000)
    )
    
    fun romanToInt(s: String): Int {
        var i = 0
        var res = 0
        while(i < s.length) {
            val ch = s[i]
            if(ch == 'I' && i < s.length - 1 && s[i+1] == 'V') {
                i += 1
                res += 4
            } else if(ch == 'I' && i < s.length - 1 && s[i+1] == 'X') {
                i += 1
                res += 9
            } else if(ch == 'X' && i < s.length - 1 && s[i+1] == 'L') {
                i += 1
                res += 40
            } else if(ch == 'X' && i < s.length - 1 && s[i+1] == 'C') {
                i += 1
                res += 90
            } else if(ch == 'C' && i < s.length - 1 && s[i+1] == 'D') {
                i += 1
                res += 400
            } else if(ch == 'C' && i < s.length - 1 && s[i+1] == 'M') {
                i += 1
                res += 900
            }
            else {
                res += sing[ch]!!
            }
            i += 1
        }
        return res
    }
}

fun main() {
    println("Roman to Integer: test is not implemented")
} 
