package linkedlist;

public class RemoveNthNodeFromEndofList {
    /**
     * 7/28/2018
     *
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return head;
        }

        /// Create the dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;

        /// find the last n + 1th node to the extends
        for (int i = 1; i <= n + 1; i++) {
            if (right == null) {
                return dummy.next;
            }
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        /// Remove it
        left.next = left.next.next;
        return dummy.next;
    }
}
