package gameday;

public class SortList {
    /**
     * 8/4/2018
     * partition sort
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode left = partition(head);

        ListNode right = head.next;
        head.next = null;

        left = sortList(left);
        right = sortList(right);
        left = connect(left, right);
        return left;
    }

    /**
     * partition by < and >=
     */
    private ListNode partition(ListNode head) {
        ListNode left = new ListNode(-1);
        ListNode right = new ListNode(1);

        ListNode leftPointer = left, rightPointer = right;
        int partitionVal = head.val;
        while (head != null) {
            if (head.val < partitionVal) {
                leftPointer.next = head;
                leftPointer = leftPointer.next;
                head = head.next;
                leftPointer.next = null;
            } else {
                rightPointer.next = head;
                rightPointer = rightPointer.next;
                head = head.next;
                rightPointer.next = null;
            }
        }

        rightPointer.next = right.next;
        return left.next;
    }

    private ListNode connect(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        dummy.next = left;
        ListNode connect = dummy;
        while (connect.next != null) {
            connect = connect.next;
        }

        connect.next = right;
        return dummy.next;
    }
}
