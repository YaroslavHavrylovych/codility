fun repeatedNumber(a: IntArray): Int {
    val tmp = IntArray(a.size) { _ -> -1 }
    for (v in a) {
        if (tmp[v] != -1) return v
        tmp[v] = v
    }
    return -1
}

//Test
fun main() {
    val res = repeatedNumber(intArrayOf(3, 4, 1, 4, 1))
    println("Duplicate in Array: " +
            if (res == 1 || res == 4) "SUCCESS" else "FAIL")
}

