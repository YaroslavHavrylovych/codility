/**
 * Given a positive integer, return its corresponding 
 * column title as appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 *     ...
 * <br>
 * https://leetcode.com/problems/excel-sheet-column-title/
 */
fun convertToTitle(n: Int): String {
    val letters = arrayListOf<Char>()
    ('A'..'Z').forEach { letters.add(it) }
    var rest = n
    var ret = ""
    do {
        rest -= 1
        ret += letters[rest % letters.size]
        rest /= letters.size
    } while (rest != 0)
    return ret.reversed()
}

fun main() {
    print("Excel Sheet Column Titler:")
    println(if(convertToTitle(703) == "AAA") "SUCCESS" else "FAIL")
} 
