package com.linkedlist;

import com.utils.ListNode;

public class LinkedListSorted {

    static boolean isSorted(ListNode head) {
        Boolean isSorted = false;
        return isSorted(head, head.next);
    }

    static boolean isSorted(ListNode prev, ListNode current) {
        if (prev == null || current == null)
            return true;
        boolean isSorted = isSorted(current, current.next);
        if (!isSorted)
            return false;
        if (prev.val < current.val)
            return true;
        else if (prev.val > current.val)
            return false;
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(17);
        head.next.next.next.next = new ListNode(16);
        System.out.println(isSorted(head));
    }
}

// 1 2 3 4 5
//isSorted(1,2 ) true
//isSorted(2,3 )  true
//isSorted(3,4)  true
//isSorted(4,5)  true
//isSorted(5,null)


// 1 2 4 3 5
//isSorted(1,2 ) true
//isSorted(2,4 )  true
//isSorted(4,3)  false
//isSorted(4,5)  true
//isSorted(5,null)