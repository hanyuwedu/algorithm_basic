package linkedlist;

public class AddTwoNumbers {
    /**
     * 7/28/2018
     *
     * Refined version
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            if (carry != 0) {
                sum += carry;
            }

            ListNode digit = new ListNode(sum % 10);
            carry = sum / 10;

            current.next = digit;
            current = current.next;
        }

        return dummy.next;
    }



    /**
     * 7/28/2018
     *
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2
     */
    public ListNode addLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ListNode next = new ListNode((l2.val + carry) % 10);
                carry = (l2.val + carry) / 10;
                current.next = next;
                l2 = l2.next;
            } else if (l2 == null) {
                ListNode next = new ListNode((l1.val + carry) % 10);
                carry = (l1.val + carry) / 10;
                current.next = next;
                l1 = l1.next;
            } else {
                ListNode next = new ListNode((l1.val + l2.val + carry) % 10);
                carry = (l1.val + l2.val + carry) / 10;
                current.next = next;
                l1 = l1.next;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (carry != 0) {
            ListNode next = new ListNode(carry);
            current.next = next;
        }

        return dummy.next;
    }
}
