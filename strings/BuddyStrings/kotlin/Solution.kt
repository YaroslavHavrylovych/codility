import kotlin.math.sign

/**
 * 859. Buddy Strings.
 * <br/>
 * Given two strings A and B of lowercase letters, 
 * return true if you can swap two letters in A so the result is equal to B, 
 * otherwise, return false.
 * Swapping letters is defined as taking two indices 
 * i and j (0-indexed) such that i != j and swapping the characters 
 * at A[i] and A[j]. For example, swapping at indices 
 * 0 and 2 in "abcd" results in "cbad".
 * <br/>
 * https://leetcode.com/problems/buddy-strings/
 */
fun buddyStrings(A: String, B: String): Boolean {
    if(A.length != B.length || A.length < 2) return false
    var l1 = -1
    var l2 = -1
    for(i in A.indices) {
        if(A[i] != B[i]) {
            if(l1 == -1) {
                l1 = i
                continue
            }
            if(l2 == -1) {
                l2 = i
                if(A[l1] != B[l2] || A[l2] != B[l1]) return false //swap doesn't help
                continue
            }
            return false //more than 2 chars are diff
        }
    }
    if (l1 == -1) { //same, but maybe we could swap two similar letters
        return A.groupBy { it.toInt() }.any { (_, v) -> v.size > 1 }
    }
    if(l2 == -1) return false
    return A[l1] == B[l2] && A[l2] == B[l1]
}

fun main() {
    print("Buddy Strings:")
    var a = true
    a = a && buddyStrings("ab", "ba")
    a = a && !buddyStrings("ab", "ab")
    a = a && buddyStrings("aa", "aa")
    a = a && buddyStrings("aaaaaaabc", "aaaaaaacb")
    a = a && !buddyStrings("", "aa")
    println(if(a) "SUCCESS" else "FAIL")
} 
