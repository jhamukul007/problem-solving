package com.linkedlist;

import com.utils.ListNode;

public class LinkedListMid {

    public ListNode midElement(ListNode node) {
        ListNode slowPointer = node;
        ListNode fastPointer = node;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        LinkedListMid obj = new LinkedListMid();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        System.out.println("Mid "+ obj.midElement(head1));
    }
}

