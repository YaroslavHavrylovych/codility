import java.util.Arrays;

/** Check README to find description */
class Shell {
    private val distance = intArrayOf(701, 301, 132, 57, 23, 10, 4, 1)

    fun sort(a: IntArray) {
        var interval = distance.asSequence()
            .first { value -> value < a.size / 2 }
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
    val a = intArrayOf(10, 2, 11, 31, 60, 90, 81, 85, 
        75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(a))
    Shell().sort(a)
    System.out.println(Arrays.toString(a))
}
