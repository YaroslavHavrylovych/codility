/**
 * A robot is located at the top-left corner of a m x n grid 
 * (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. 
 * The robot is trying to reach the bottom-right corner of the grid 
 * (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. 
 * How many unique paths would there be?
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 * <br>
 * https://leetcode.com/problems/unique-paths-ii/
 */
typealias Matrix = Array<IntArray>
class Solution {
    fun uniquePathsWithObstacles(ip: Matrix): Int {
        if(ip.size == 0 || ip[0].size == 0) return 0
        val cache = Array(ip.size) { IntArray(ip[0].size) }
        cache[0][0] = if(ip[0][0] == 1) 0 else 1
        for(i in 1..ip.indices.last) cache[i][0] = if(ip[i][0] == 1) 0 else cache[i-1][0]
        for(j in 1..ip[0].indices.last) cache[0][j] = if(ip[0][j] == 1) 0 else cache[0][j-1]
        for(i in 1..ip.indices.last) {
            for(j in 1..ip[0].indices.last) {
                cache[i][j] = if(ip[i][j] == 1) 0 else cache[i-1][j] + cache[i][j-1]
            }
        }
        return cache[cache.indices.last][cache[0].indices.last]
    }
}

fun main() {
    println("Unique Paths II: test is not implemented")
} 
