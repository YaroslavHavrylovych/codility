/**
 * https://www.interviewbit.com/problems/reverse-link-list-ii/
 */
public class Solution {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (B >= C) return A;
        ListNode cur = A;
        int i = 1;
        ListNode lst = null, frst = null, prev = null;
        ListNode beforeFrst = null;
        while (cur != null) {
            if (i == B - 1) beforeFrst = cur;
            if (i == B) lst = cur;
            if (i == C) frst = cur;
            if (i < B) {
                cur = cur.next;
                i++;
                continue;
            }
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
            if (i > C) {
                lst.next = cur;
                break;
            }
        }
        if (beforeFrst != null) beforeFrst.next = frst;
        else A = frst;
        if (lst.next == lst) lst.next = null;
        return A;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = null;
        print(node);
        sl.reverseBetween(node, 2, 4);
        print(node);
        node = sl.reverseBetween(node, 1, 2);
        print(node);
        node = sl.reverseBetween(node, 4, 5);
        print(node);
    }

    private static void print(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println();
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) { val = x; next = null; }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}


