/**
 * Implement strStr().
 * Return the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack.
 * Clarification:
 * What should we return when needle is an empty string? 
 * This is a great question to ask during an interview.
 * For the purpose of this problem, we will return 0 when needle 
 * is an empty string. 
 * This is consistent to C's strstr() and Java's indexOf().
 * <br>
 * https://leetcode.com/problems/implement-strstr/
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        if(needle.isEmpty()) return 0
        if(haystack.isEmpty()) return -1
        val t = lsp(needle)
        return kmp(haystack, needle, t)
    }
    
    fun lsp(w: String): IntArray {
        val res = IntArray(w.length) { 0 }
        var i = 1
        var j = 0
        while(i < w.length) {
            if(w[i] == w[j]) {
                j += 1
                res[i] = j
            } else {
                if(j != 0) {
                    j = res[i - 1]
                    while(j != 0) {
                        if(w[i] == w[j]) {
                            j += 1
                            res[i] = j
                            break
                        } else {
                            j = res[j - 1]
                        }
                    }
                    if (j == 0 && w[i] == w[j]) j += 1
                }
            }
            i += 1
        }
        return res
    }
    
    fun kmp(s: String, w: String, t: IntArray): Int {
        var j = 0
        var i = 0
        while(i < s.length && j < w.length) {
            if(s[i] == w[j]) {
                j += 1
            } else {
                if(j != 0) {
                    j = t[j - 1]
                    while(j != 0) {
                        if(s[i] == w[j]) {
                            j += 1
                            break
                        } else {
                            j = t[j - 1]
                        }
                    }
                    if (j == 0 && s[i] == w[j]) j += 1
                }
            }
            i += 1
        }
        return if(j == w.length) i - j else -1
    }
}


fun main() {
    println("Implement strStr(): test is not implemented")
} 
