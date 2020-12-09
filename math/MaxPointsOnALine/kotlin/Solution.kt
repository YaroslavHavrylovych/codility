import kotlin.math.sign

/**
 * Given n points on a 2D plane, find the maximum number of points that 
 * lie on the same straight line.
 * <br>
 * https://leetcode.com/problems/max-points-on-a-line/
 */
class Solution {
    fun maxPoints(points: Array<IntArray>): Int {
        if (points.size < 2) return points.size
        var max = 2
        for (i in 0 until points.size - max) {
            val lines = HashMap<String, Int>()
            var same = 1
            //k = (y2 - y1) / (x2 - x1) - this we can save as the fraction
            var nextPointMax = 0
            for (j in i + 1 until points.size) {
                var pts:Int
                if (points[i][0] == points[j][0]
                        && points[i][1] == points[j][1]) {
                    same += 1
                    continue
                } else if (points[i][0] == points[j][0]) {
                    pts = lines.inc("inf")
                } else if (points[i][1] == points[j][1]) {
                    pts = lines.inc("0")
                } else {
                    val dx = points[i][0] - points[j][0] // dx != 0 (checked before)
                    val dy = points[i][1] - points[j][1] // dy != 0 (checked before)
                    val d = gcd(dx, dy)
                    val sign = if (dx.sign + dy.sign == 0) "-" else ""
                    pts = lines.inc("$sign${kotlin.math.abs(dx / d)}${kotlin.math.abs(dy / d)}")
                }
                nextPointMax = kotlin.math.max(nextPointMax, pts)
            }
            nextPointMax += same
            max = kotlin.math.max(nextPointMax, max)
        }
        return max
    }

    private fun gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private fun MutableMap<String, Int>.inc(k: String): Int = this.let { m ->
        m[k] = getOrDefault(k, 0) + 1
        m[k]!!
    }
}

fun main() {
    println("Max Point in a line: test is not implemented")
} 
