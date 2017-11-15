import java.util.Arrays;

/** Check README to find description */
class Quick {
    fun sort(a: IntArray) {
        sort(a, 0, a.size - 1)
    }

    fun sort(a: IntArray, low: Int, hi: Int) {
        if(low >= hi) return
        val splitPos = split(a, low, hi)
        sort(a, low, splitPos - 1)
        sort(a, splitPos + 1, hi)
    }

    fun split(a: IntArray, low: Int, hi: Int): Int {
        var i = low
        var j = hi - 1
        val pivot = hi
        do {
            while (i < j && a[i] < a[pivot]) {
                i++
            }
            while (j > i && a[j] > a[pivot]) {
                j--
            }
            if (i >= j) {
                if(a[j] > a[pivot]) swap(a, j, pivot)
                return j
            } 
            swap(a, i, j)
        } while (true)
    }

    fun swap(a: IntArray, ind1: Int, ind2: Int) {
        val tmp = a[ind1]
        a[ind1] = a[ind2]
        a[ind2] = tmp
    }
}

fun main(args: Array<String>) {
    val a = intArrayOf(10, 2, 11, 31, 60, 90, 81, 85, 
        75, 21, 13, 32, 42, 90, 1)
    System.out.println(Arrays.toString(a))
    Quick().sort(a)
    System.out.println(Arrays.toString(a))
}
