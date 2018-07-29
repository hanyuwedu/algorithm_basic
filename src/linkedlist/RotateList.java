package linkedlist;

public class RotateList {
    /**
     * 7/28/2018
     *
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }

        /// Dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        /// find size
        int length = getSize(head);

        /// Find node pre to k and separate
        ListNode preKtoLastNode = findNtoLastNode(k % length + 1, dummy);
        if (preKtoLastNode == null) {
            return head;
        }

        /// connect right to left
        ListNode right = preKtoLastNode.next;
        preKtoLastNode.next = null;
        dummy.next = connect(right, dummy.next);

        return dummy.next;
    }

    private int getSize(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }

        return length;
    }

    private ListNode findNtoLastNode(int n, ListNode dummy) {
        ListNode left, right;
        left = right = dummy;

        for (int i = 1; i <= n; i++) {
            if (right == null) {
                return null;
            }
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        return left;
    }

    private ListNode connect(ListNode left, ListNode right) {
        ListNode head = left;

        while (head != null && head.next != null) {
            head = head.next;
        }

        if (head == null) {
            return right;
        } else {
            head.next = right;
            return left;
        }
    }
}
