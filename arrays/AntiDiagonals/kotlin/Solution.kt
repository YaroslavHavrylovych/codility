typealias IntArray2d = Array<IntArray>

/**
 * Give a N*N square matrix, return an array of its anti-diagonals.
 * <br />
 * https://www.interviewbit.com/problems/anti-diagonals/
 */

fun diagonal(a: IntArray2d): IntArray2d {
    val n = a.size
    val res: MutableList<IntArray> = ArrayList(2 * n - 1)
    var i = 0
    while (i < 2 * n - 1) {
        var ind1 = if (i < n) 0 else i - n + 1
        var ind2 = if (i < n) i else n - 1
        val row = IntArray(ind2 - ind1 + 1)
        var ind = 0
        while (ind1 < n && ind2 >= 0) {
            row[ind++] = a[ind1++][ind2--]
        }
        res.add(row)
        i++
    }
    return res.toTypedArray()
}

//Test
fun main() {
    val param = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    val res = diagonal(param)
    val success = res[0][0] == 1
            && res[1].contentEquals(intArrayOf(2, 4))
            && res[2].contentEquals(intArrayOf(3, 5, 7))
            && res[3].contentEquals(intArrayOf(6, 8))
            && res[4][0] == 9
    println("Anti Diagonals: ${if (success) "SUCCESS" else "FAIL"}")
}

