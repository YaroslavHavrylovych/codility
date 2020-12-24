import kotlin.math.sign
import java.lang.Integer.max

/**
 * 1672. Richest Customer Wealth.
 * <br/>
 * You are given an m x n integer grid accounts where accounts[i][j] is 
 * the amount of money the i-th customer has in the j-th bank. 
 * Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in 
 * all their bank accounts. The richest customer is the customer 
 * that has the maximum wealth.
 * <br/>
 * https://leetcode.com/problems/richest-customer-wealth/
 */
fun maximumWealth(accounts: Array<IntArray>) = accounts.map { c -> c.sum() }.max() ?: 0

fun main() {
    print("1672. Richest Customer Wealth.:")
    var a = true
    a = a && maximumWealth(emptyArray()) == 0
    a = a && maximumWealth(arrayOf(intArrayOf(1,5), intArrayOf(7,3), 
        intArrayOf(3,5))) == 10
    println(if(a) "SUCCESS" else "FAIL")
} 
