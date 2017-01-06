package com.yaroslav.lancelot.sort.improved.quick

import com.yaroslav.lancelot.sort.SortUtils

/** */
class QuickK {
    fun sort(a: IntArray) {
        sort(a, 0, a.size - 1)
    }

    fun sort(a: IntArray, low: Int, hi: Int) {
        if (low > hi)
            return
        val splitPos = split(a, low, hi)
        sort(a, low, splitPos - 1)
        sort(a, splitPos + 1, hi)
    }

    fun split(a: IntArray, low: Int, hi: Int): Int {
        var i = low
        var j = hi - 1
        val pivot = hi
        var done = false
        do {
            while (i < j && a[i] < a[pivot]) {
                i++
            }
            while (j > i && a[j] > a[pivot]) {
                j--
            }
            if (i >= j) {
                done = true
            } else {
                swap(a, i, j)
            }
        } while (!done)
        swap(a, j, pivot)
        return low
    }

    fun swap(a: IntArray, ind1: Int, ind2: Int) {
        val tmp = a[ind1]
        a[ind1] = a[ind2]
        a[ind2] = tmp
    }
}

fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = QuickK()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
