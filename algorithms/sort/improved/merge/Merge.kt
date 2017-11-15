import java.util.Arrays;

/** Check README to find description */
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
    val a = intArrayOf(10, 2, 11, 31, 60, 90, 81, 85, 
        75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(a))
    Merge().sort(a)
    System.out.println(Arrays.toString(a))
}
