package com.yaroslav.lancelot.exercises

/**
 * The task is to return "equilibrium index" (sum of indexes before and after that index are equals) of an array.
 * <br></br>
 * If index is zero or N-1 (where N - number of elements in array) that's mean that sum of elements from [1..N-1]
 * (or [N-2..0]) is equal to zero.
 */
class FindEquilibriumIndex {
    fun findIndex(a: IntArray): Int {
        if (a.size == 1) {
            return 0
        }
        if (a.size == 0) {
            return -1
        }
        val b = IntArray(a.size)
        System.arraycopy(a, 0, b, 0, a.size)
        //now we have 2 arrays with visa versa sums in both
        for (i in 1..b.size - 1) {
            b[i] = b[i - 1] + b[i]
        }
        if (b[b.size - 2] == 0) {// if it's last index
            return b.size - 1
        }
        for (i in a.size - 2 downTo 0) {
            a[i] = a[i] + a[i + 1]
        }
        if (a[1] == 0) {// if it's first index
            return 1
        }
        //any other
        for (i in 1..a.size - 1 - 1) {
            if (b[i - 1] == a[i + 1]) {
                return i
            }
        }
        return -1
    }
}

fun main(r: Array<String>) {
    val s = FindEquilibriumIndex()
    System.out.println(s.findIndex(intArrayOf(5, 5, 4, 3, 2, 3, 4, 5, 5)))
    System.out.println(s.findIndex(intArrayOf(0, 1, -1, 1, 0, 1, -1)))
    System.out.println(s.findIndex(intArrayOf(-1, 1, -1, 1, 1, 0)))
    System.out.println(s.findIndex(intArrayOf(-1, 1, -1, 1, -1, 1, 56)))
    System.out.println(s.findIndex(intArrayOf(65, -1, 1, -1, 1, -1, 1)))
    System.out.println(s.findIndex(IntArray(0)))
    System.out.println(s.findIndex(IntArray(1)))
    System.out.println(s.findIndex(intArrayOf(65, 96)))
    System.out.println(s.findIndex(intArrayOf(65, -1, 30, 35)))
    System.out.println(s.findIndex(intArrayOf(30, 35, -1, 65)))
}
