package gameday;

public class ReverseLinkedListII {
    /**
     * 7/28/2018
     *
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        /// Find m-1th node
        ListNode preMNode = getNthNode(m - 1, dummy);

        /// Find nth node
        ListNode nthNode = getNthNode(n, dummy);

        /// Reverse node
        ListNode postNNode = nthNode.next;
        nthNode.next = null;
        preMNode.next = getReversed(preMNode.next, postNNode);

        return dummy.next;
    }

    private ListNode getNthNode(int n, ListNode dummy) {
        for (int i = 1; i <= n; i++) {
            if (dummy != null) {
                dummy = dummy.next;
            } else {
                return null;
            }
        }

        return dummy;
    }

    private ListNode getReversed(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        dummy.next = right;

        while (left != null) {
            ListNode current = left;
            left = left.next;
            current.next = dummy.next;
            dummy.next = current;
        }

        return dummy.next;
    }
}
