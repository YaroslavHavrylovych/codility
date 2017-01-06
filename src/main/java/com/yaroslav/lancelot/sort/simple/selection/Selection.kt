package com.yaroslav.lancelot.sort.simple.selection

import com.yaroslav.lancelot.sort.SortUtils

/** */
class Selection {
    fun sort(a: IntArray) {
        for (i in 0 until a.size - 1) {
            var minPos = i
            for (j in minPos + 1 until a.size) {
                if (a[minPos] > a[j]) {
                    minPos = j
                }
            }
            if (minPos != i) {
                val tmp = a[minPos]
                a[minPos] = a[i]
                a[i] = tmp
            }
        }
    }
}

fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = Selection()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
