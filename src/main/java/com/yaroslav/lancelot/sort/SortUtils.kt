package com.yaroslav.lancelot.sort

/** Bubble sort examlpe algitrythm  */
object SortUtils {
    fun readArray(fileName: String): IntArray {
        return intArrayOf(10, 2, 11, 31, 60, 90, 81, 85, 75, 21, 13, 32, 42, 90, 1)
    }

    fun print(str: String) {
        System.out.print(str)
    }

    fun println(str: String) {
        System.out.println(str)
    }

    fun print(array: IntArray) {
        print("[")
        for (i in 0..array.size - 1 - 1) {
            print("" + array[i] + ", ")
        }
        print(Integer.toString(array[array.size - 1]))
        println("]")
    }
}
