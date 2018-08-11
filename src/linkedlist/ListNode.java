package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode current = this;

        while (current != null) {
            sb.append(current.val);
            sb.append(" -> ");
            current = current.next;
        }

        sb.append("null");
        return sb.toString();
    }

    public static ListNode getSampleListNode() {
        ListNode nodeA = new ListNode(1);
        ListNode nodeB = new ListNode(1);
        ListNode nodeC = new ListNode(3);
        ListNode nodeD = new ListNode(2);
        ListNode nodeE = new ListNode(3);

        nodeA.next = nodeB;
        nodeB.next = nodeC;
        nodeC.next = nodeD;
        nodeD.next = nodeE;

        return nodeA;
    }
}
