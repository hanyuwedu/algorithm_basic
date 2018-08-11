package linkedlist;

public class CopyListwithRandomPointer {
    private class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }


    /**
     * 7/29/2018
     * Inplace copy
     *
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        /// Copy next pointer
        RandomListNode current = head;
        while (current != null) {
            RandomListNode copy = new RandomListNode(current.label);
            copy.next = current.next;
            current.next = copy;
            current = copy.next;
        }

        /// Copy random pointer
        current = head;
        while (current != null) {
            if (current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        /// Break down next pointer
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode tail = dummy;
        current = head;
        while (current != null) {
            tail.next = current.next;
            tail = tail.next;
            current = tail.next;
            tail.next = null;
        }

        return dummy.next;
    }
}
