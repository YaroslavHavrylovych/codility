import kotlin.math.sign

/**
 * Given an array A of integers, return the length of the longest 
 * arithmetic subsequence in A.
 * Recall that a subsequence of A is a 
 * list A[i_1], A[i_2], ..., A[i_k] 
 * with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence 
 * B is arithmetic if B[i+1] - B[i] are all the same value 
 * (for 0 <= i < B.length - 1).
 * <br>
 * https://leetcode.com/problems/longest-arithmetic-subsequence/
 */
class Solution {
    fun longestArithSeqLength(A: IntArray): Int {
        if(A.size <= 2) return A.size
        var max = 2
        val diffs = Array<MutableMap<Int, Int>>(A.size) { HashMap() }
        for(i in 1..A.indices.last) {
            for(j in i-1 downTo 0) {
                val diff = A[i] - A[j]
                if(diffs[j][diff] == null) {
                    if(diffs[i][diff] == null) {
                        diffs[i][diff] = 2
                    }
                } else {
                    if(diffs[i][diff] == null) {
                        diffs[i][diff] = diffs[j][diff]!! + 1
                    } else {
                        diffs[i][diff] = kotlin.math.max(
                            diffs[i][diff]!!, diffs[j][diff]!! + 1
                        )
                    }
                    if(max < diffs[i][diff]!!) {
                        max = diffs[i][diff]!!
                    }
                }
            }
        }
        return max
    }
}

fun main() {
    println("Longest Arithmetic Subsequence: test is not implemented")
} 
