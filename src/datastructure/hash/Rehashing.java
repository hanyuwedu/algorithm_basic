package datastructure.hash;

import linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Rehashing {
    /**
     * 8/11/2018
     *
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return new ListNode[0];
        }

        ListNode[] rehash = new ListNode[hashTable.length * 2];
        int size = rehash.length;

        Set<ListNode> nodes = new HashSet<>();
        for (ListNode node : hashTable) {
            while (node != null) {
                ListNode head = node;
                nodes.add(node);
                node = node.next;
                head.next = null;
            }
        }

        for (ListNode node : nodes) {
            int index = (node.val % size + size) % size;
            if (rehash[index] == null) {
                rehash[index] = node;
            } else {
                ListNode head = rehash[index];
                while (head.next != null) {
                    head = head.next;
                }
                head.next = node;
            }
        }

        return rehash;
    }
}
