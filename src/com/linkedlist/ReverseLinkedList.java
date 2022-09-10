package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class ReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode nextNode;
        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(5);
        Utils.printListNode(reverse(head));
    }

}
