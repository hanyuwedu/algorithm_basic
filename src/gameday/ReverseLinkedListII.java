package gameday;

import util.ListNode;

public class ReverseLinkedListII {
    /**
     * 2/21/2019
     * GameDay
     * https://www.lintcode.com/problem/reverse-linked-list-ii/description
     *
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preM = getPreNode(dummy, m);
        ListNode N = getPreNode(dummy, n).next;
        ListNode tail = N.next;
        ListNode current = preM.next;

        N.next = null;
        preM.next = tail;

        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = preM.next;
            preM.next = temp;
        }

        return dummy.next;
    }

    private ListNode getPreNode(ListNode dummy, int m) {
        for (int i = 1; i <= m - 1; i++) {
            dummy = dummy.next;
        }

        return dummy;
    }

}
