/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, el;
        int val = l1.val + l2.val;
        int v1, v2;
        head = el = new ListNode(val % 10);
        val = val / 10;
        l1 = l1.next;
        l2 = l2.next;
        while(!(l1 == null && l2 == null)) {
            if(l1 == null) {
                v1 = 0;
            } else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if(l2 == null) {
                v2 = 0;
            } else {
                v2 = l2.val;
                l2 = l2.next;
            }
            val = v1 + v2 + val;
            el = el.next = new ListNode(val % 10);
            val = val / 10;
        }
        if(val != 0) {
            el.next = new ListNode(val);
        }
        return head;
    }

    public static void main(String[] args) {
    }

    private void test(int value1, int value2) {

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
