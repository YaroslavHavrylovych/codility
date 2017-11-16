import java.util.Arrays

/** Check README to find description */
class Heap {
    fun sort(a: IntArray) {
        for (end in (a.size - 1) downTo 1) {
            maxHeap(a, 0, end)
            swap(a, 0, end)
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
    val a = intArrayOf(10, 2, 11, 31, 60, 90, 81, 85, 
        75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(a))
    Heap().sort(a)
    System.out.println(Arrays.toString(a))
}
