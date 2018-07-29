package linkedlist;

public class PalindromeLinkedList {
    /**
     * 7/28/2018
     * Reverse and Comparing equal
     *
     * @param head: A ListNode.
     * @return: A boolean.
     */
    public boolean isPalindrome(ListNode head) {
        /// reverse the List
        ListNode reverse = getReversedNode(head);

        /// Comparing each element
        return isEqual(head, reverse);
    }

    private ListNode getReversedNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pointer = head;

        while (pointer != null) {
            ListNode next = new ListNode(pointer.val);
            next.next = dummy.next;
            dummy.next = next;
            pointer = pointer.next;
        }

        return dummy.next;
    }

    private boolean isEqual(ListNode listNode1, ListNode listNode2) {
        while (listNode1 != null) {
            if (listNode2 == null) {
                return false;
            }

            if (listNode1.val != listNode2.val) {
                return false;
            }

            listNode1 = listNode1.next;
            listNode2 = listNode2.next;
        }

        return listNode2 == null;
    }
}
