package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class DeleteANode {

    public static ListNode delete(ListNode head, int node) {
        if (head == null)
            return null;
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val == node) {
                if (prev == null)
                    head = head.next;
                else
                    prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(10);
        Utils.printListNode(head);
        System.out.println("-----------------------");
        Utils.printListNode(delete(head, 2));
    }
}


