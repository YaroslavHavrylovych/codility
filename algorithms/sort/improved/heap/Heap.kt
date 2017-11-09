package com.yaroslav.lancelot.sort.improved.heap

import com.yaroslav.lancelot.sort.SortUtils

/** */
class Heap {
    fun sort(a: IntArray) {
        var end = a.size - 1
        maxHeap(a, 0, end)
        swap(a, 0, end--)

        for (newEnd in end downTo 1) {
            maxHeap(a, 0, newEnd)
            swap(a, 0, newEnd)
        }
    }

    private fun swap(a: IntArray, pos1: Int, pos2: Int) {
        val tmp = a[pos1]
        a[pos1] = a[pos2]
        a[pos2] = tmp
    }

    private fun maxHeap(a: IntArray, start: Int, end: Int) {
        val count = (end - start + 1) / 2
        val endCondition = (end + 1) / 2
        for (i in count downTo 0) {
            var root = i
            var swap = root
            while (root < endCondition) {
                val child = root * 2 + 1
                if (a[swap] < a[child]) {
                    swap = child
                }
                if (child + 1 < end && a[swap] < a[child + 1]) {
                    swap = child + 1
                }
                if (swap == root) {
                    break
                }
                swap(a, swap, root)
                root = swap
            }
        }
    }
}

fun main(args: Array<String>) {
    val a = SortUtils.readArray("")
    val sorter = Heap()
    SortUtils.print(a)
    sorter.sort(a)
    SortUtils.print(a)
}
