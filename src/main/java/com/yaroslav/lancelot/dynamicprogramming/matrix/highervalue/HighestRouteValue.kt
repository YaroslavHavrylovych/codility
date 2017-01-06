package com.yaroslav.lancelot.dynamicprogramming.matrix.highervalue

/**
 * A table composed of N x M cells, each having a certain quantity of apples, is given.
 * You start from the upper-left corner. At each step you can go down or right one cell.
 * Find the maximum number of apples you can collect.
 */
class HighestRouteValue {
    fun nextStep(cell: Coordinates): Int {
        if (cell.n == 0 && cell.m == 0) {
            return matrix[0][0]
        }
        if (cell.n > 0 && cell.m > 0) {
            return matrix[cell.n][cell.m] + Math.max(
                    nextStep(Coordinates(cell.n - 1, cell.m)),
                    nextStep(Coordinates(cell.n, cell.m - 1)))
        }
        if (cell.n > 0) {
            return matrix[cell.n][cell.m] + nextStep(Coordinates(cell.n - 1, cell.m))
        }
        return matrix[cell.n][cell.m] + nextStep(Coordinates(cell.n, cell.m - 1))
    }

    class Coordinates constructor(val n: Int, val m: Int) {

        override fun toString(): String {
            return "{$n, $m}"
        }

        override fun hashCode(): Int {
            return Integer.hashCode((n + 1) * (m + 1) + m)
        }

        override fun equals(o: Any?): Boolean {
            if (o !is Coordinates) {
                return false
            }
            return o.n == n && o.m == m
        }
    }
}

private val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(6, 9, 11), intArrayOf(8, 10, 7), intArrayOf(4, 9, 5), intArrayOf(10, 8, 3))
private val N = 5
private val M = 3

fun printMatrix(matrix: Array<IntArray>) {
    for (n in matrix.indices) {
        for (m in 0..matrix[n].size - 1) {
            print(matrix[n][m].toString() + "\t")
        }
        println("")
    }
}

fun print(value: String) {
    System.out.print(value)
}

fun println(value: String) {
    System.out.println(value)
}

fun main(args: Array<String>) {
    val highestRouteValue = HighestRouteValue()
    printMatrix(matrix)
    println("")
    val value = highestRouteValue.nextStep(HighestRouteValue.Coordinates(N - 1, M - 1))
    println(Integer.toString(value))
}
