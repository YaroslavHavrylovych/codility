package com.yaroslav.lancelot.exercises

/**
 * Simple balancer:
 * balance brackets in the input value with only possibility to remove brackets
 */
class BracketsSimpleBalancer {
    /**
     * trying to balance brackets in the string with only possibility to remove not needed brackets
     */
    fun balance(str: String): String {
        val result = StringBuilder()
        val closeBracketsBalanceResult = updateCloseBrackets(str, result)
        if (closeBracketsBalanceResult > 0) {
            updateOpenBrackets(result, closeBracketsBalanceResult)
        }
        return result.toString().trim { it <= ' ' }
    }

    /**
     * removing misplaced open brackets (as we can't be sure about their placement, we're removing them from the end
     * (we could only guess which bracket should be there)
     */
    private fun updateOpenBrackets(result: StringBuilder, unbalancedOpenBracketsAmount: Int) {
        var startIndex = result.length
        for (i in 0..unbalancedOpenBracketsAmount - 1) {
            val bracketsSearchResult = result.lastIndexOf("(", startIndex)
            result.delete(bracketsSearchResult, bracketsSearchResult + 1)
            startIndex = bracketsSearchResult
        }
    }

    /**
     * removing misplaced close brackets
     * @return unbalanced open brackets amount (if 0 than string is balanced)
     */
    private fun updateCloseBrackets(str: String, strBuilder: StringBuilder): Int {
        var openBracketsCounter = 0
        for (i in 0..str.length - 1) {
            val ch = str[i]
            if (ch == ')') {
                if (openBracketsCounter == 0) {
                    continue
                } else {
                    openBracketsCounter -= 1
                }
            }
            if (ch == '(') {
                openBracketsCounter += 1
            }
            strBuilder.append(ch)
        }
        return openBracketsCounter
    }
}

fun main(args: Array<String>) {
    val balancer = BracketsSimpleBalancer()
    val test = "((((a))sdsa)ds))  vs  (((sa) (()asdas)) (("
    println(balancer.balance(test))
}
