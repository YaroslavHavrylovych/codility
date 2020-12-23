import kotlin.math.sign
import java.lang.Integer.max

/**
 * 1073. Adding Two Negabinary Numbers.
 * <br>
 * Given two numbers arr1 and arr2 in base -2, return the result 
 * of adding them together.
 * Each number is given in array format:  as an array of 0s and 1s, 
 * from most significant bit to least significant bit.  
 * For example, arr = [1,1,0,1] represents the number 
 * (-2)^3 + (-2)^2 + (-2)^0 = -3.  A number arr in array, format is also 
 * guaranteed to have no leading zeros: either arr == [0] or arr[0] == 1.
 * 
 * Return the result of adding arr1 and arr2 in the same format: 
 * as an array of 0s and 1s with no leading zeros.
 * <br/>
 * https://leetcode.com/problems/adding-two-negabinary-numbers/
 */
fun addNegabinary(arr1: IntArray, arr2: IntArray): IntArray {
    val res = IntArray(max(arr1.size, arr2.size) + 4) { 0 }
    for (i in res.indices) {
        val v1 = if (i < arr1.size) arr1[arr1.size - i - 1] else 0
        val v2 = if (i < arr2.size) arr2[arr2.size - i - 1] else 0
        if (v1 == 0 && v2 == 0) continue
        if (v1 == 1 && v2 == 1) {
            res.addOne(i + 1)
            res.addOne(i + 2)
        } else {
            res.addOne(i)
        }
    }
    val lastInd = res.indexOfLast { it == 1 }
    if (lastInd == -1) return intArrayOf(0)
    return res.take(lastInd + 1).reversed().toIntArray()
}

fun IntArray.addOne(pos: Int) {
    if (this[pos] == 0) {
        this[pos] = 1
        return
    }
    if (this[pos + 1] == 1) { //this[pos] == 1
        this[pos] = 0
        this[pos + 1] = 0
        return
    }
    this[pos] = 0
    addOne(pos + 1)
    addOne(pos + 2)
}

fun main() {
    print("Adding Two Negabinary Numbers:")
    var a = true
    a = a && addNegabinary(intArrayOf(1,0 /* -2 */), intArrayOf(1,1,0 /* 2 */)).contentToString() == "[0]"
    a = a && addNegabinary(intArrayOf(1,1,1,1,1 /* 11 */), intArrayOf(1,0,1 /* 5 */)).contentToString() == "[1, 0, 0, 0, 0]"
    a = a && addNegabinary(intArrayOf(1 /* 1 */), intArrayOf(0 /* 0 */)).contentToString() == "[1]"
    a = a && addNegabinary(intArrayOf(1 /* 1 */), intArrayOf(1 /* 1 */)).contentToString() == "[1, 1, 0]"
    a = a && addNegabinary(intArrayOf(0 /* 0 */), intArrayOf(0 /* 0 */)).contentToString() == "[0]"
    a = a && addNegabinary(intArrayOf(1,1,1,1,1 /* 11 */), intArrayOf(1,1,1,1,1 /* 11 */)).contentToString() == "[1, 1, 0, 1, 0, 1, 0]"
    a = a && addNegabinary(intArrayOf(1,1 /* -1 */), intArrayOf(1,1 /* -1 */)).contentToString() == "[1, 0]"
    println(if(a) "SUCCESS" else "FAIL")
} 
