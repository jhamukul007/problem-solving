package com.linkedlist;

import com.utils.ListNode;

class Operations {

    static void addNode(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode current = head;
        ListNode prevNode = null;
        while (current != null) {
            if (data < current.val && data >= prevNode.val) {
                ListNode node = new ListNode(data);
                prevNode.next = node;
                node.next = current;
            }


        }
    }
}
