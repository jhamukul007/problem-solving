package com.linkedlist;

import com.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        int index = 0;
        int borrow = 0;
        while (l2 != null || index < list1.size() || borrow > 0) {
            int l1D = index < list1.size() ? list1.get(index) : 0;
            int l2D = l2 != null ? l2.val : 0;
            int total = l1D + borrow + l2D;
            borrow = total / 10;

            if (index >= list1.size()) {
                list1.add(total % 10);
            } else
                list1.set(index, total % 10);

            if (l2 != null)
                l2 = l2.next;
            index++;
        }
        ListNode result = null;
        ListNode current = result;

        for (int i = 0; i < list1.size(); i++) {
            if (i == 0) {
                current = new ListNode(list1.get(i));
                result = current;
                continue;
            }
            current.next = new ListNode(list1.get(i));
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(9);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(9);

        ListNode n2 = new ListNode(9);
        n2.next = new ListNode(9);
        n2.next.next = new ListNode(9);
        n2.next.next.next = new ListNode(9);

        AddTwoNumbers obj = new AddTwoNumbers();
        //Utils.printListNode(obj.addTwoNumbers(head, n2));
        System.out.println(1534236469 > 2147483647);
    }

}
