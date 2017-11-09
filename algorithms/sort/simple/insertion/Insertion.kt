import java.util.Arrays;

class Insertion {
    fun sort(a: IntArray) {
        for (i in 1..(a.size - 1))
            for(j in i downTo 1)
                if(a[j-1] > a[j]) swap(a, j-1, j)
                else break;
    }

    fun swap(a: IntArray, ind1: Int, ind2: Int) {
        val tmp = a[ind1]
        a[ind1] = a[ind2]
        a[ind2] = tmp
    }
}


fun main(args: Array<String>) {
    val array = intArrayOf(10, 2, 11, 31, 60, 90, 81,
        85, 75, 21, 13, 32, 42, 90, 1)
    System.out.println("Stat array " + Arrays.toString(array))
    Insertion().sort(array)
    System.out.println("Sorted array " + Arrays.toString(array))
}
