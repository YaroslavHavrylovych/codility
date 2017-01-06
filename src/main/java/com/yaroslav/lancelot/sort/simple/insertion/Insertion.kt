package com.yaroslav.lancelot.sort.simple.insertion

import com.yaroslav.lancelot.sort.SortUtils

/** */
class Insertion {
    fun sort(a: IntArray) {
        for (i in 2..a.size) {
            var j = i
            while (--j > 0) {
                if (a[j - 1] > a[j]) {
                    var tmp = a[j - 1]
                    a[j - 1] = a[j]
                    a[j] = tmp
                }
            }
        }
    }
}


fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = Insertion()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
