package com.yaroslav.lancelot.sort.improved.merge

import com.yaroslav.lancelot.sort.SortUtils

/** */
class Merge {
    fun sort(a: IntArray) {
        if (a.size < 2)
            return

        val mid = a.size / 2
        val leftArray = a.sliceArray(0 until mid)
        val rightArray = a.sliceArray(mid until a.size)
        sort(leftArray)
        sort(rightArray)

        var i = 0
        var j = 0
        var k = 0
        while (i < leftArray.size && j < rightArray.size) {
            if (leftArray[i] < rightArray[j]) {
                a[k] = leftArray[i++]
            } else {
                a[k] = rightArray[j++]
            }
            k += 1
        }
        while (i < leftArray.size) {
            a[k++] = leftArray[i++]
        }
        while (j < rightArray.size) {
            a[k++] = rightArray[j++]
        }
    }
}

fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = Merge()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
