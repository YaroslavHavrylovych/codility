/**
 * Given a sentence that consists of some words separated by a single space, 
 * and a searchWord. You have to check if searchWord 
 * is a prefix of any word in sentence. 
 * Return the index of the word in sentence 
 * where searchWord is a prefix of this word (1-indexed).
 * If searchWord is a prefix of more than one word, 
 * return the index of the first word (minimum index). 
 * If there is no such word return -1.
 * A prefix of a string S is any leading contiguous substring of S.
 * <br>
 * https://leetcode.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence/
 */
class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        var i = 0
        var word = 1
        var start = true
        for (ch in sentence) {
            if (ch == ' ') {
                start = true
                word += 1
                continue
            }
            if (start && searchWord[i] == ch) {
                i += 1
                if (i >= searchWord.length) return word
            } else {
                start = false
                i = 0
            }
        }
        return -1
    }
}

fun main() {
    println("Check If a Word Occurs As a Prefix of Any Word in a Sentence" +
        ": test is not implemented")
} 
