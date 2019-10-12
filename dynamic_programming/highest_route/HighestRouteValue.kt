/**
 * TODO it's an old implementation I did which is not
 * dynamic programming approach. I hope soon I would replace that with the new
 * solution (today I'm focused on java).
 * <br/>
 * Check README to find the description.
 */
class HighestRouteValue {
    fun calculate(cell: Coordinate): Int {
        return nextStep(cell)
    }

    fun nextStep(cell: Coordinate): Int {
        if (cell.n == 0 && cell.m == 0) return matrix[0][0]
        if (cell.n > 0 && cell.m > 0)
            return matrix[cell.n][cell.m] + Math.max(
                    nextStep(Coordinate(cell.n - 1, cell.m)),
                    nextStep(Coordinate(cell.n, cell.m - 1)))
        if (cell.n > 0)
            return matrix[cell.n][cell.m] + nextStep(
                    Coordinate(cell.n - 1, cell.m))
        return matrix[cell.n][cell.m] + nextStep(
                Coordinate(cell.n, cell.m - 1))
    }

    class Coordinate constructor(val n: Int, val m: Int) {

        override fun toString(): String {
            return "{$n, $m}"
        }

        override fun hashCode(): Int {
            return Integer.hashCode((n + 1) * (m + 1) + m)
        }

        override fun equals(other: Any?): Boolean {
            if (other !is Coordinate) {
                return false
            }
            return other.n == n && other.m == m
        }
    }
}

private val matrix = arrayOf(
        intArrayOf(1, 2, 3), 
        intArrayOf(6, 9, 11), 
        intArrayOf(8, 10, 7), 
        intArrayOf(4, 9, 5), 
        intArrayOf(10, 8, 3))
private val N = 5
private val M = 3

fun printMatrix(matrix: Array<IntArray>) {
    for (n in matrix.indices) {
        for (m in 0..matrix[n].size - 1) {
            System.out.print(matrix[n][m].toString() + "\t")
        }
        System.out.println("")
    }
}

fun main(args: Array<String>) {
    printMatrix(matrix)
    System.out.println()
    val value = HighestRouteValue().calculate(
            HighestRouteValue.Coordinate(N - 1, M - 1))
    System.out.println(Integer.toString(value))
}
