import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * https://www.interviewbit.com/problems/merge-k-sorted-lists/
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            ListNode ptr = a.get(i);
            if (ptr == null) continue;
            queue.add(ptr.val);
            while ((ptr = ptr.next) != null) queue.add(ptr.val);
        }
        if (queue.isEmpty()) return null;
        ListNode head = new ListNode(queue.poll());
        ListNode tmp = head;
        while (!queue.isEmpty()) {
            tmp.next = new ListNode(queue.poll());
            tmp = tmp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(3);
        ArrayList<ListNode> lstlst = new ArrayList<>();
        lstlst.add(l1);
        lstlst.add(l2);
        print(sl.mergeKLists(lstlst));
    }

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) { val = x; next = null; }
    }

    private static void print(ListNode lst) {
        if (lst == null) {
            System.out.println("empty");
            return;
        }
        System.out.print(lst.val);
        while ((lst = lst.next) != null) System.out.print("->" + lst.val);
        System.out.println();
    }
}


