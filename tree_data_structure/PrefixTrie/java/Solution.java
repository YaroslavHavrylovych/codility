import java.util.Map;
import java.util.HashMap;

/**
 * Implement a trie with insert, search, and starts With methods.
 *
 * <br />
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
public class Solution {
    private Node head;

    /** Initialize your data structure here. */
    public Solution() {
        head = new Node('0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node current = head;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Node node = current.vertices.get(ch);
            if(node == null) {
                node = new Node(ch);
                current.vertices.put(ch, node);
            }
            current = node;
        }
        current.word = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node current = head;
        for(int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            Node node = current.vertices.get(ch);
            if(node == null) return false;
            current = node;
        }
        return current.isWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node current = head;
        for(int i = 0; i < prefix.length(); i++) {
            Character ch = prefix.charAt(i);
            Node node = current.vertices.get(ch);
            if(node == null) return false;
            current = node;
        }
        return true;
    }
    
    private class Node {
        private Character val;
        private Map<Character, Node> vertices = new HashMap<>();
        boolean word = false;
        
        Node(Character val) {
            this.val = val;
        }
        
        private void setVal(Character val) {
            this.val = val;
        }
        
        private void markWord() {
            word = true;
        }
        
        private boolean isWord() {
            return word;
        }
        
        @Override
        public int hashCode() {
            return val.hashCode();
        }
        
        @Override
        public boolean equals(Object obj) {
            if(obj == null || !(obj instanceof Node)) return false;
            Node n1 = (Node) obj;
            return n1.val.equals(val);
        }
    }
}
