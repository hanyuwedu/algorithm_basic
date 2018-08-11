package linkedlist;

public class ConvertSortedListtoBinarySearchTree {
    /*
     * 7/29/2018
     *
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        /// Base case
        if (head == null) {
            return null;
        }

        if (getSize(head) == 1) {
            return new TreeNode(head.val);
        }

        /// Divide
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preMid = getPremid(dummy);

        ListNode midListNode = preMid.next;
        ListNode rightListNode = midListNode.next;
        midListNode.next = null;
        preMid.next = null;

        TreeNode left = sortedListToBST(dummy.next);
        TreeNode right = sortedListToBST(rightListNode);

        /// Conquer
        TreeNode mid = new TreeNode(midListNode.val);
        mid.left = left;
        mid.right = right;

        return mid;
    }

    private int getSize(ListNode node) {
        if (node == null) {
            return 0;
        }

        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }

        return size;
    }

    private ListNode getPremid(ListNode dummy) {
        ListNode fast = dummy.next, slow = dummy;

        while(fast != null && fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
