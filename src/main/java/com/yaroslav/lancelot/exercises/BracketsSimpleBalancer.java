package com.yaroslav.lancelot.exercises;

/** */
public class BracketsSimpleBalancer {
    /**
     * trying to balance brackets in the string with only possibility to remove not needed brackets
     */
    public String balance(String str) {
        StringBuilder result = new StringBuilder();
        int closeBracketsBalanceResult = updateCloseBrackets(str, result);
        if (closeBracketsBalanceResult > 0) {
            updateOpenBrackets(result, closeBracketsBalanceResult);
        }
        return result.toString().trim();
    }

    /**
     * removing misplaced open brackets
     */
    private void updateOpenBrackets(StringBuilder result, int unbalancedOpenBracketsAmount) {
        int startIndex = result.length();
        for (int i = 0; i < unbalancedOpenBracketsAmount; i++) {
            int bracketsSearchResult = result.lastIndexOf("(", startIndex);
            result.delete(bracketsSearchResult, bracketsSearchResult + 1);
            startIndex = bracketsSearchResult;
        }
    }

    /**
     * removing misplaced close brackets
     *
     * @return unbalanced open brackets amount (if 0 than string is balanced)
     */
    private int updateCloseBrackets(String str, StringBuilder strBuilder) {
        int openBracketsCounter = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {
                if (openBracketsCounter == 0) {
                    continue;
                } else {
                    openBracketsCounter -= 1;
                }
            }
            if (ch == '(') {
                openBracketsCounter += 1;
            }
            strBuilder.append(ch);
        }
        return openBracketsCounter;
    }

    public static void main(String... args) {
        BracketsSimpleBalancer balancer = new BracketsSimpleBalancer();
        String test = "((((a))sdsa)ds))  vs  (((sa) (()asdas)) ((";
//        String test = "((ab)";
//        String test = ") (";
//        String test = "()";
//        String test = "(((((((((((()))))))";
//        String test = "";
        System.out.println(balancer.balance(test));
    }
}
