package com.linkedlist;

import com.utils.ListNode;

public class Length {
    static int len = 0;

    public static int findLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    public static int findLengthRec(ListNode head) {
        if (head == null)
            return 0;
        return 1 + findLengthRec(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(10);
        System.out.println(findLengthRec(head));
        System.out.println(findLength(head));
    }
}
