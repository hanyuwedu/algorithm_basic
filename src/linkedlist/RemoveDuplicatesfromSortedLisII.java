package linkedlist;

public class RemoveDuplicatesfromSortedLisII {
    /**
     * 7/28/2018
     *
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates0(ListNode head) {
        if (head == null) {
            return head;
        }

        /// dummy
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            ListNode next = current.next;
            if (next.next == null) {
                break;
            }

            if (next.next.val != next.val) {
                current = current.next;
            } else {
                int remove = next.val;
                while (next != null && next.val == remove) {
                    next = next.next;
                }
                current.next = next;
            }
        }

        return dummy.next;
    }


    /**
     * 7/28/2018
     *
     * @param head: head is the head of the linked list
     * @return: head of the linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        /// dummy
        ListNode dummy = new ListNode(head.val + 1);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            int duplicate = current.next.val;
            if (current.next.next != null && current.next.next.val == duplicate) {
                while (current.next != null && current.next.val == duplicate) {
                    current.next = current.next.next;
                }
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
