package linkedlist;


public class Util {
    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @param n nth node to be found
     * @return nth node from head to be found
     */
    public ListNode findNthNode(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int count = 0;
        ListNode current = dummy;

        while (count < n && current != null) {
            current = current.next;
            count++;
        }

        return current;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @param n nth node from the tail to be found
     * @return nth node from the tail
     */
    public ListNode findNthToLast(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;

        int step = 0;
        while (step < n && prev != null) {
            prev = prev.next;
            step++;
        }

        if (prev == null) {
            return null;
        }

        ListNode post = dummy;

        while (prev != null) {
            prev = prev.next;
            post = post.next;
        }

        return post;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @return mid node of the list,
     * if list size is even number, return n/2 th node
     * if list size is odd number, return n/2 + 1th node
     */
    public ListNode findMidNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast, slow;
        fast = slow = dummy;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @param target target value to be removed from the listnode
     * @return the head of the output listnode
     */
    public ListNode removeAll(ListNode head, int target) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while(current != null && current.next != null) {
            if (current.next.val == target) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the sorted listnode
     * @param target target value to be insertedd
     * @return head of the output listnode
     */
    public ListNode insertInSortedList(ListNode head, int target) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            if (current.next.val < target) {
                current = current.next;
            } else {
                break;
            }
        }

        ListNode node = new ListNode(target);
        node.next = current.next;
        current.next = node;

        return dummy.next;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @return head of the reversed listnode
     */
    public ListNode reverseNode(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode temp = current;
            current = current.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }

    /**
     * 7/13/2018
     *
     * @param a sorted listnode
     * @param b sorted listnode
     * @return head of the merged sorted list
     */
    public ListNode mergeTwoSortedList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);

        ListNode left = a, right = b;
        ListNode current = dummy;

        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
                current = current.next;
            } else {
                current.next = right;
                right = right.next;
                current = current.next;
            }
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }

    /**
     * 7/13/2018
     *
     * @param head head of the current listnode
     * @param target pivot number to partition origin list
     * @return a list partitioned by target by < and >=
     */
    public ListNode partitionList(ListNode head, int target) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode leftHead = left;
        ListNode rightHead = right;

        ListNode current = head;

        while (current != null) {
            if (current.val < target) {
                left.next = current;
                left = left.next;
                current = current.next;
            } else {
                right.next = current;
                right = right.next;
                current = current.next;
            }
        }

        right.next = null;
        left.next = rightHead.next;
        return leftHead.next;
    }
}
