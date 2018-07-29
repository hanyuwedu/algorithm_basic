package linkedlist;


public class UtilTest {
    public static void main(String[] args) {
        ListNode sampleListNode = ListNode.getSampleListNode();
        Util utility = new Util();

//        findNthNodeTest(sampleListNode, utility);
//        findNthToLastTest(sampleListNode, utility);
//        reorderListTest(utility);

        reverseBetweenTest(sampleListNode);
    }

    private static void reverseBetweenTest(ListNode sampleListNode) {
        System.out.println(sampleListNode.toString());

        ListNode reversed = new ReverseLinkedListII().reverseBetween(sampleListNode, 2, 4);
        System.out.println(reversed.toString());
    }

    private static void reorderListTest(Util utility) {
        ListNode listNode0 = new ListNode(0);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);

        listNode2.next = listNode0;
        listNode0.next = listNode1;
        new ReorderList().reorderList(listNode2);

        System.out.println(listNode2);
    }


    public static void findNthNodeTest(ListNode head, Util utility) {
        System.out.println(utility.findNthNode(head, 1));
        System.out.println(utility.findNthNode(head, 3));
        System.out.println(utility.findNthNode(head, 5));
        System.out.println(utility.findNthNode(head, 7));
    }

    private static void findNthToLastTest(ListNode head, Util utility) {
        System.out.println(utility.findNthToLast(head, 3));
        System.out.println(utility.findNthToLast(head, 5));
        System.out.println(utility.findNthToLast(head, 6));
    }


}
