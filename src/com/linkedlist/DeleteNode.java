package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class DeleteNode {

    public static ListNode removeElements(ListNode head, int val) {

        if (head == null)
            return null;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode cur = head;
        ListNode prev = temp;

        while (cur != null) {
            if (cur.val == val)
                prev.next = cur.next;
            else
                prev = cur;
            cur = cur.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        head.next = new ListNode(6);
        head.next.next = new ListNode(7);
        head.next.next.next = new ListNode(6);
        Utils.printListNode(removeElements(head, 7));
    }
}
