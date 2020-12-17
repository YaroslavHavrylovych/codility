/**
 * Count the number of prime numbers less than a non-negative number, n.
 * <br>
 * https://leetcode.com/problems/count-primes/
 */
fun countPrimes(n: Int): Int {
    if(n < 3) return 0
    val cache = arrayListOf(2)
    outer@ for(v in 3 until n step 2) {
        val sn: Int = kotlin.math.sqrt(v.toDouble()).toInt()
        for(i in cache.indices) {
            if(cache[i] > sn) break
            if(v % cache[i] == 0) continue@outer
        }
        cache.add(v)
    }
    return cache.size
}

fun main() {
    println("Count primes: " + 
        if(countPrimes(5_000_000) == 348513) { "SUCCESS" }
        else { "FAIL" })
} 
