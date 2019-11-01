/**
 * Given a singly linked list, modify the value of first half nodes such that : 
 * 1st node’s new value = the last node’s value - first node’s current value 
 * 2nd node’s new value = the second last node’s value - 2nd node’s current value, 
 * and so on …
 * <br/>
 * https://www.interviewbit.com/problems/subtract/
 */
public class Solution {
    public ListNode subtract(ListNode A) {
        if (A == null) return null;
        int count = count(A);
        if (count == 1) return A;
        int fst = count / 2 + (count % 2 == 0 ? 0 : 1);
        reverse(A, fst, count - 1);
        makeOperation(A, fst);
        reverse(A, fst, count - 1);
        return A;
    }

    private void makeOperation(ListNode A, int from) {
        ListNode start = A;
        int i = 1;
        while ((A = A.next) != null) {
            if (i++ < from) continue;
            start.val = A.val - start.val;
            start = start.next;
        }
    }

    private void reverse(ListNode A, int from, int to) {
        int i = 0;
        ListNode beforeFirst = null, first = null, prev = null;
        while (A != null) {
            if (i == from - 1) beforeFirst = A;
            if (i == to) first = A;
            if (i++ < from) {
                A = A.next;
                continue;
            }
            ListNode tmp = A.next;
            A.next = prev;
            prev = A;
            A = tmp;
        }
        beforeFirst.next = first;
    }

    private int count(ListNode A) {
        int cnt = 1;
        while ((A = A.next) != null) cnt++;
        return cnt;
    }

    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) { val = x; next = null; }
    }
}


