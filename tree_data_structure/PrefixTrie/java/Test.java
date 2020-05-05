import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Solution trie = new Solution();
        var success = true;
        trie.insert("apple");
        success = success && trie.search("apple"); 
        success = success && !trie.search("app");
        success = success && trie.startsWith("app");
        trie.insert("app");   
        success = success && trie.search("app");
        System.out.println("Prefix trie: " + 
                (success ? "SUCCESS" : " FAILED"));
    }
}

