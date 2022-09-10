package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class MergeTwoArray {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode cur = null;
        ListNode node = null;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                int data;
                if (list1.val < list2.val) {
                    data = list1.val;
                    list1 = list1.next;
                } else {
                    data = list2.val;
                    list2 = list2.next;
                }

                if (cur == null) {
                    cur = new ListNode(data);
                    node = cur;
                } else {
                    cur.next = new ListNode(data);
                    cur = cur.next;
                }
            } else {
                if (list1 == null) {
                    cur.next = list2;
                    list2 = list2.next;
                } else if (list2 == null) {
                    cur.next = list1;
                    list1 = list1.next;
                }
                cur = cur.next;
            }

        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(4);
        //------------
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);

        Utils.printListNode(mergeTwoLists(head, head1));
    }
}
