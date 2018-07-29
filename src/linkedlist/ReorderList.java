package linkedlist;

public class ReorderList {
    /**
     * 7/28/2018
     * In place alteration
     *
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        /// find mid(left preferred)
        ListNode mid = findMid(head);

        /// Reverse the right part
        ListNode right = getReversed(mid.next);
        mid.next = null;

        /// Interleaving insertion
        interLeave(head, right);
    }

    private ListNode findMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left, right;
        left = right = dummy;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }

        return left;
    }

    private ListNode getReversed(ListNode head) {
        ListNode dummy = new ListNode(0);

        while (head != null) {
            ListNode current = head;
            head = head.next;
            current.next = dummy.next;
            dummy.next = current;
        }

        return dummy.next;
    }

    private void interLeave(ListNode left, ListNode right) {
        while (left != null && right != null) {
            ListNode leftPointer = left;
            ListNode rightPointer = right;

            left = left.next;
            right = right.next;

            rightPointer.next = left;
            leftPointer.next = rightPointer;
        }
    }
}
