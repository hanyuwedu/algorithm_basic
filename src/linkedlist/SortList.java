package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortList {
    /**
     * 7/29/2018
     * heap sort
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        Queue<ListNode> heap = new PriorityQueue<>(Comparator.comparingInt((node) -> node.val));

        while (head != null) {
            heap.add(head);
            head = head.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!heap.isEmpty()) {
            ListNode next = heap.remove();
            current.next = next;
            current = next;
            next.next = null;
        }

        return dummy.next;
    }

    /**
     * 7/29/2018
     * merge sort
     *
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList1(ListNode head) {
        /// Base case
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        /// Divide
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;

        ListNode left = sortList(head);
        right = sortList(right);

        /// Conquer
        ListNode merge = mergeNode(left, right);
        return merge;
    }

    private ListNode getMid(ListNode head) {
        ListNode fast, slow;
        fast = slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode mergeNode(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null || right != null) {
            if (left == null) {
                current.next = right;
                break;
            }

            if (right == null) {
                current.next = left;
                break;
            }

            if (left.val < right.val) {
                current.next = left;
                current = current.next;
                left = left.next;
            } else {
                current.next = right;
                current = current.next;
                right = right.next;
            }
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
