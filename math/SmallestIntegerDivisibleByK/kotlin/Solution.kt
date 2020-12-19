import java.util.LinkedList

/**
 * Given a positive integer K, you need to find the length of the smallest 
 * positive integer N such that N is divisible by K, 
 * and N only contains the digit 1.
 * Return the length of N. If there is no such N, return -1.
 * Note: N may not fit in a 64-bit signed integer.
 * <br>
 * https://leetcode.com/problems/smallest-integer-divisible-by-k/
 */
fun smallestRepunitDivByK(K: Int): Int {
    if (K % 2 == 0 || K % 5 == 0) return -1
    var l = 1L
    var n = 1
    while (l < K) {
        n++
        l = l * 10 + 1
    }
    l %= K
    while (l != 0L) {
        l = (((l % K) * (10 % K)) % K + 1) % K
        if (n == Int.MAX_VALUE) return -1
        n++
    }
    return n
}

fun main() {
    print("Smallest Integer Divisible by K: ")
    var a = true
    a = a && smallestRepunitDivByK(1) == 1
    a = a && smallestRepunitDivByK(3) == 3
    a = a && smallestRepunitDivByK(7) == 6
    a = a && smallestRepunitDivByK(12371) == 1012 
    println(if(a) "SUCCESS" else "FAIL")
} 
