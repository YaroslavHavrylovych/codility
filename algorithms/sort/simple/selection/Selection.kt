import java.util.Arrays;

/** Check README to find description */
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
    val array = intArrayOf(10, 2, 11, 31, 60, 90, 81,
        85, 75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(array))
    Selection().sort(array)
    System.out.println(Arrays.toString(array))
}
