package com.yaroslav.lancelot.sort.improved.shell

import com.yaroslav.lancelot.sort.SortUtils

/** */
class ShellK {
    private val distance = intArrayOf(701, 301, 132, 57, 23, 10, 4, 1)

    fun sort(a: IntArray) {
        var interval = distance.asSequence().first { value -> value < a.size / 2 }
        while (interval > 0) {
            for (i in 0 until a.size - interval) {
                var minInd = i
                for (j in i + interval until a.size step interval) {
                    if (a[minInd] > a[j]) {
                        minInd = j
                    }
                }
                if (minInd != i) {
                    val tmp = a[i]
                    a[i] = a[minInd]
                    a[minInd] = tmp
                }
            }
            val intervalInd = distance.indexOf(interval) + 1
            interval = if (intervalInd >= distance.size) -1 else distance[intervalInd]
        }
    }
}

fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = ShellK()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
