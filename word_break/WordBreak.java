import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

/**
 * Check README to find description.
 * <br/>
 * Current solutions builds a tree (each node is a letter) out of
 * all given words (from "vocabulary"). If the node is the end
 * of the word, it has special mark and in the same time can be connected
 * with other nodes (if a word is connection of multiple words).
 */
public class WordBreak {
    final Node rootNode;

    WordBreak(String[] dictionary) {
        rootNode = createDictionary(dictionary);
    }

    public String wordBreak(String notBreakedString) {
        return wordBreak(notBreakedString, 0, rootNode, new ArrayList<>());
    }

    private String wordBreak(String notBreakedString, int ind, Node parentNode,
            List<Integer> breaks) {
        if(ind == notBreakedString.length()) {
            //we break every possible word
            if(parentNode == rootNode) 
                return breakWords(notBreakedString, breaks);
            //last word not broken
            return null;
        }
        //breaking next symbol from the vocabulary
        Node node = parentNode.checkNode(notBreakedString.charAt(ind));
        //no words with given combination of characters
        if(node == null) return null;
        //if the current symbol ends the word row vocabulary
        if(node.wordEnd) {
            breaks.add(ind + 1);
            String result = wordBreak(notBreakedString, ind + 1,
                    rootNode, breaks);
            //if null, than next part of the sentence can't be broken
            //so we reverting our current break and search for other solutions
            if(result == null) breaks.remove(breaks.size() - 1);
            else return result;
        }
        //move to next letter
        return wordBreak(notBreakedString, ind + 1, node, breaks);
    }

    private String breakWords(String notBreakedString, List<Integer> breaks) {
        String result = notBreakedString.substring(0, breaks.get(0));
        for(int i = 1; i < breaks.size(); i++) {
            result += (" " + notBreakedString
                    .substring(breaks.get(i - 1), breaks.get(i)));
        }
        return result;
    }

    public static void main(String[] args) {
        String[] vocabulary = new String[] {"not", "a", "Jane", "I",
            "probably", "know", "that", "and", "you", "am", "are"};
        WordBreak wordBreak = new WordBreak(vocabulary);
        String sentence = "IamnotJaneandyouareprobablyknowthat";
        String result = wordBreak.wordBreak(sentence);
        System.out.println("original: " + sentence);
        System.out.println("result: " + result);
    }

    private Node createDictionary(String[] dictionary) {
        Node rootNode = new Node();
        for(int i = 0; i < dictionary.length; i++) {
            Node currentNode = rootNode.getNode(dictionary[i].charAt(0));
            for(int j = 1; j < dictionary[i].length(); j++) {
                currentNode = currentNode.getNode(dictionary[i].charAt(j));
            }
            currentNode.wordEnd = true;
        }
        return rootNode;
    }

    private static class Node {
        char letter;
        boolean wordEnd;
        Set<Node> nodes = new HashSet<>();

        Node() {
        }

        Node(char ch) {
            letter = ch;
        }

        Node getNode(char ch) {
            Node node = checkNode(ch);
            if(node == null) {
                node = new Node(ch);
                nodes.add(node);
            }
            return node;
        }

        Node checkNode(char ch) {
            for (Node node : nodes)
                if(node.letter == ch) return node;
            return null;
        }
    }
}
