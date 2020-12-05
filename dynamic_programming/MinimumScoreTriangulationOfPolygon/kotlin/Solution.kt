/**
 * Given N, consider a convex N-sided polygon with vertices 
 * labelled A[0], A[i], ..., A[N-1] in clockwise order.
 * 
 * Suppose you triangulate the polygon into N-2 triangles.  
 * For each triangle, the value of that triangle is the product of the 
 * labels of the vertices, and the total score of the triangulation 
 * is the sum of these values over all N-2 triangles in the triangulation.
 * 
 * Return the smallest possible total score that you can achieve 
 * with some triangulation of the polygon.
 * <br>
 * https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
 */
class Solution {
    lateinit var cache: Array<Array<Int>>
    
    fun minScoreTriangulation(A: IntArray): Int {
        cache = Array(A.size) { Array(A.size) { Int.MAX_VALUE } }
        return findMin(A, 0, A.indices.last)
    }
    
    fun findMin(A:IntArray, l: Int, r: Int): Int {
        if(r - l <= 1) return 0 //neighbours
        if(cache[l][r] != Int.MAX_VALUE) return cache[l][r]
        for(m in r-1 downTo l + 1) {
            cache[l][r] = Math.min(cache[l][r],
                                      A[l] * A[r] * A[m]
                                      + findMin(A, l, m)
                                      + findMin(A, m, r))
        }
        return cache[l][r]
    }
}

fun main() {
    println("Minimum Score Triangulation of Polygon: test is not implemented")
} 
