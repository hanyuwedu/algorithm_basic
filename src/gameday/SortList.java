package gameday;

import util.ListNode;

public class SortList {
    /**
     * 2/21/2019
     * GameDay
     * https://www.lintcode.com/problem/sort-list/description
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = getMid(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        ListNode merge = getMerge(left, right);
        return merge;
    }

    private ListNode getMid(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode getMerge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
            current.next = null;
        }

        if (left == null) {
            current.next = right;
        } else {
            current.next = left;
        }

        return dummy.next;
    }




    /**
     * 8/4/2018
     * partition sort
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList2(ListNode head) {
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
