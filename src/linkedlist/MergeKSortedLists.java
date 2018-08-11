package linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedLists {
    /**
     * 7/28/2018
     * PriorityQueue
     *
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        Queue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode listnode : lists) {
            if (listnode != null) {
                pq.add(listnode);
            }
        }

        while (!pq.isEmpty()) {
            ListNode next = pq.remove();
            if (next.next != null) {
                pq.add(next.next);
            }
            next.next = null;
            current.next = next;
            current = current.next;
        }

        return dummy.next;
    }

    /**
     * 7/29/2018
     * Divide and Conquer
     *
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists1(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        if (lists.size() == 1) {
            return lists.get(0);
        }

        /// Divide
        int mid = lists.size() / 2;
        ListNode left = mergeKLists1(lists.subList(0, mid));
        ListNode right = mergeKLists1(lists.subList(mid, lists.size()));

        /// Conquer
        ListNode merge = mergeNode(left, right);
        return merge;
    }


    /**
     * 7/29/2018
     * merge two by two
     *
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        while (lists.size() > 1) {
            ListNode node1 = lists.get(0);
            ListNode node2 = lists.get(1);
            ListNode merge = mergeNode(node1, node2);

            lists.remove(1);
            lists.remove(0);

            lists.add(merge);
        }

        return lists.get(0);
    }

    private ListNode mergeNode(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                current.next = node2;
                break;
            }

            if (node2 == null) {
                current.next = node1;
                break;
            }

            if (node1.val < node2.val) {
                current.next = node1;
                node1 = node1.next;
                current = current.next;
            } else {
                current.next = node2;
                node2 = node2.next;
                current = current.next;
            }
        }

        return dummy.next;
    }
}
