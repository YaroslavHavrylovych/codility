/**
 * Check README to find description.
 */
class HighestRouteValue {
    fun calculate(cell: Coordinates): Int {
        return nextStep(cell)
    }

    fun nextStep(cell: Coordinates): Int {
        if (cell.n == 0 && cell.m == 0) return matrix[0][0]
        if (cell.n > 0 && cell.m > 0)
            return matrix[cell.n][cell.m] + Math.max(
                    nextStep(Coordinates(cell.n - 1, cell.m)),
                    nextStep(Coordinates(cell.n, cell.m - 1)))
        if (cell.n > 0)
            return matrix[cell.n][cell.m] + nextStep(
                    Coordinates(cell.n - 1, cell.m))
        return matrix[cell.n][cell.m] + nextStep(
                Coordinates(cell.n, cell.m - 1))
    }

    class Coordinates constructor(val n: Int, val m: Int) {

        override fun toString(): String {
            return "{$n, $m}"
        }

        override fun hashCode(): Int {
            return Integer.hashCode((n + 1) * (m + 1) + m)
        }

        override fun equals(other: Any?): Boolean {
            if (other !is Coordinates) {
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
            HighestRouteValue.Coordinates(N - 1, M - 1))
    System.out.println(Integer.toString(value))
}
