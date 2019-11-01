public class Test {
    public static void main(String[] args) {
        Solution sl = new Solution();
        Solution.ListNode A = new Solution.ListNode(1);
        boolean success = true;
        A.next = new Solution.ListNode(2);
        A.next.next = new Solution.ListNode(3);
        A.next.next.next = new Solution.ListNode(4);
        A.next.next.next.next = new Solution.ListNode(5);
        success = success && print(A).equals("1->2->3->4->5");
        success = success && print(sl.subtract(A)).equals("4->2->3->4->5");
        success = success && print((sl.subtract(new Solution.ListNode(10))))
            .equals("10");
        A = new Solution.ListNode(2);
        A.next = new Solution.ListNode(2);
        success = success && print(A).equals("2->2");
        print((sl.subtract(A))).equals("0->2");
        A = new Solution.ListNode(1);
        A.next = new Solution.ListNode(2);
        A.next.next = new Solution.ListNode(3);
        success = success && print(A).equals("1->2->3");
        success = success && print((sl.subtract(A))).equals("2->2->3");
        A = new Solution.ListNode(1);
        A.next = new Solution.ListNode(2);
        A.next.next = new Solution.ListNode(3);
        A.next.next.next = new Solution.ListNode(4);
        success = success && print(A).equals("1->2->3->4");
        success = success && print((sl.subtract(A))).equals("3->1->3->4");
        System.out.println("Substract lst: " +
                (success ? "SUCCESS" : "FAIL"));
    }

    private static String print(Solution.ListNode A) {
        StringBuilder res = new StringBuilder();
        do {
            if (A.next != null) res.append(A.val).append("->");
            else res.append(A.val);
        } while ((A = A.next) != null);
        return res.toString();
    }
}
