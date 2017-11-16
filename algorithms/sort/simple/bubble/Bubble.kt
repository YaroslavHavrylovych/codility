import java.util.Arrays;

/** Check README to find description */
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
    val array = intArrayOf(10, 2, 11, 31, 60, 90, 81,
        85, 75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(array))
    Bubble().sort(array)
    System.out.println(Arrays.toString(array))
}
