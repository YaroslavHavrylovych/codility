import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given a set of reviews provided by the customers for different hotels 
 * and a string containing “Good Words”, you need to sort the reviews 
 * in descending order according 
 * to their “Goodness Value” (Higher goodness value first). 
 * We define the “Goodness Value” of a string as the number of 
 * “Good Words” in that string.  
 * <br/> 
 * Note: Sorting should be stable. If review i and review j have the 
 * same “Goodness Value” then their original order would be preserved. 
 * <br/>
 * You are expected to use Trie in an Interview for such problems
 * <br/>
 * https://www.interviewbit.com/problems/hotel-reviews/
 */
public class Solution {
    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        List<Review> reviewList = buildReviewList(B, buildTrie(A));
        reviewList.sort((o1, o2) -> Integer.compare(o2.score, o1.score));
        return reviewList.stream().map(r -> r.pos)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Node buildTrie(String A) {
        Node head = new Node('_');
        Node curr = head;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (ch == '_') {
                curr.word = true;
                curr = head;
                continue;
            }
            if (curr.children.containsKey(ch)) {
                curr = curr.children.get(ch);
            } else {
                Node next = new Node(ch);
                curr.children.put(ch, next);
                curr = next;
            }
        }
        curr.word = true;
        head.word = false;
        return head;
    }

    private List<Review> buildReviewList(ArrayList<String> B, Node trie) {
        List<Review> lst = new ArrayList<>(B.size());
        for (int i = 0; i < B.size(); i++) {
            Review review = new Review(i);
            Node curr = trie;
            int j = 0;
            while (j >= 0 && j < B.get(i).length()) {
                char ch = B.get(i).charAt(j++);
                if (ch == '_') {
                    if (curr.word) review.score++;
                    curr = trie;
                    continue;
                }
                if (curr.children.containsKey(ch)) {
                    curr = curr.children.get(ch);
                } else {
                    curr = trie;
                    j = B.get(i).indexOf('_', j);
                }
            }
            if (curr.word) review.score++;
            lst.add(review);
        }
        return lst;
    }

    class Review implements Comparator<Review> {
        int pos;
        int score;

        Review(int pos) {
            this.pos = pos;
        }

        @Override
        public int compare(Review o1, Review o2) {
            return Integer.compare(o1.score, o2.score);
        }
    }

    class Node {
        char val;
        boolean word;
        Map<Character, Node> children = new HashMap<>();

        Node(char val) {
            this.val = val;
        }
    }
}


