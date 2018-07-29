package linkedlist;

public class RemoveDuplicatesfromSortedList {
    /**
     * 7/28/2018
     *
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        /// Dummy
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;

        ListNode current = dummy;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
