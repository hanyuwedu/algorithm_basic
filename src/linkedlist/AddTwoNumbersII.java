package linkedlist;

public class AddTwoNumbersII {
    /**
     * 7/28/2018
     *
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        ListNode l1Reversed = getReverse(l1);
        ListNode l2Reversed = getReverse(l2);

        ListNode sumReversed = addList(l1Reversed, l2Reversed);

        return getReverse(sumReversed);
    }

    private ListNode getReverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode current = head;

        while (current != null) {
            ListNode temp = new ListNode(current.val);
            current = current.next;
            temp.next = dummy.next;
            dummy.next = temp;
        }

        return dummy.next;
    }

    private ListNode addList(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (left != null || right != null || carry != 0) {
            int sum = 0;

            if (left != null) {
                sum += left.val;
                left = left.next;
            }

            if (right != null) {
                sum += right.val;
                right = right.next;
            }

            sum += carry;

            ListNode digit = new ListNode(sum % 10);
            carry = sum / 10;

            current.next = digit;
            current = current.next;
        }

        return dummy.next;
    }
}
