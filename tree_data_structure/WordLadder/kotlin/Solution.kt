import java.util.LinkedList

/**
 * 127. Word Ladder.
 * <br/>
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence
 * from beginWord to endWord, such that:
 *     Only one letter can be changed at a time.
 *     Each transformed word must exist in the word list.
 *         Note:
 *             Return 0 if there is no such transformation sequence.
 *             All words have the same length.
 *             All words contain only lowercase alphabetic characters.
 *             You may assume no duplicates in the word list.
 *             You may assume beginWord and endWord 
 *                 are non-empty and are not the same.
 *                             
 * <br>
 * https://leetcode.com/problems/word-ladder/
 */
class Solution {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        //init map for nodes
        val graph = HashMap<String, Node>()
        graph[beginWord] = Node(beginWord)
        wordList.forEach { graph[it] = Node(it) }
        val e = graph[endWord] ?: return 0
        //create graph
        wordList.forEachIndexed { i, w -> addToGraph(graph, wordList, i + 1, w) }
        val s = addToGraph(graph, wordList, 0, beginWord)
        //search for the shorted (dijkstra)
        val stack = LinkedList<Node>()
        stack.add(s)
        s.w = 1
        while (stack.isNotEmpty()) {
            val q = stack.removeFirst()
            val w = q.w + 1
            for (n in q.cons.values) {
                if (n == e) return w
                if (w < n.w) {
                    n.w = w
                    stack.add(n)
                }
            }
        }
        return 0
    }

    private fun addToGraph(graph: HashMap<String, Node> = HashMap(), wordList: List<String>, from: Int, word: String): Node {
        val head: Node = graph[word]!!
        for (i in from..wordList.indices.last) {
            val nextWord = graph[wordList[i]]!!
            if (!neighbors(word, wordList[i])) continue
            head.cons.put(wordList[i], nextWord)
            nextWord.cons.put(word, head)
        }
        return head
    }

    private fun neighbors(w1: String, w2: String): Boolean {
        var d = false
        for (i in w1.indices) {
            if (w1[i] != w2[i]) {
                if (d) return false
                d = true
            }
        }
        return d
    }

    class Node(val word: String, val cons: HashMap<String, Node> = HashMap(), var w: Int = Int.MAX_VALUE)
}

fun main() {
    print("Word Ladder: ")
    val sl = Solution()
    var a = sl.ladderLength("hit", "cog", 
        listOf("hot","dot","dog","lot","log","cog")) == 5
    a = a && sl.ladderLength("hit", "cog", 
        listOf("hot","dot","dog","lot","log")) == 0
    println(if(a) "SUCCESS" else "FAIL")
} 
