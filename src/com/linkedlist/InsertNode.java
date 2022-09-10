package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class InsertNode {
    //InOrder
    public static ListNode insert(ListNode head, int data) {
        //insert as head
        if (head == null) {
            head = new ListNode(data);
            return head;
        }
        ListNode cur = head;
        ListNode prev = null;
        boolean added = false;
        while (cur != null) {
            ListNode newNode = new ListNode(data);
            if (data < cur.val) {
                if (prev == null) {
                    newNode.next = cur;
                    head = newNode;
                    return head;
                } else {
                    prev.next = newNode;
                    newNode.next = cur;
                    return head;
                }
            }
            prev = cur;
            cur = cur.next;
        }
        prev.next = new ListNode(data);
        return head;
    }

    public static void main(String[] args) {
        ListNode head = insert(null, 2);
        ListNode head1 = insert(head, 1);
        ListNode head3 = insert(head1, 0);
        ListNode head4 = insert(head3, 6);
        ListNode head5 = insert(head4, 4);
        ListNode head6 = insert(head5, -1);
        ListNode head7 = insert(head6, 3);
        ListNode head8 = insert(head7, 9);
        ListNode head9 = insert(head8, 3);
        ListNode head10 = insert(head9, 5);
        ListNode head11 = insert(head10, 7);
        Utils.printListNode(head11);
    }


}


