/**
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. 
 * In how many distinct ways can you climb to the top?
 * <br>
 * https://leetcode.com/problems/climbing-stairs/
 */
class Solution {
    fun climbStairs(n: Int): Int {
        if(n < 2) return n
        val steps = IntArray(2)
        steps[0] = 1
        steps[1] = 2
        var next:Int
        for(i in 2..(n-1)) {
            next = steps[0] + steps[1]
            steps[0] = steps[1]
            steps[1] = next
        }
        return steps[1]
    }
}

fun main() {
    println("Climbing Stairs: test is not implemented")
} 
