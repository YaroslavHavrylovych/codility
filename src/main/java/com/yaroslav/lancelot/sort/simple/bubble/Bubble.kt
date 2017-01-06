package com.yaroslav.lancelot.sort.simple.bubble

import com.yaroslav.lancelot.sort.SortUtils

/** Same as java but kotlin version */
class Bubble {
    fun sort(a: IntArray) {
        for (i in 1 until a.size) {
            for (j in 0 until a.size - i) {
                if (a[j] > a[j + 1]) {
                    val tmp = a[j + 1]
                    a[j + 1] = a[j]
                    a[j] = tmp
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val sorter = Bubble()
    val array = SortUtils.readArray("")
    SortUtils.print(array)
    sorter.sort(array)
    SortUtils.print(array)
}
