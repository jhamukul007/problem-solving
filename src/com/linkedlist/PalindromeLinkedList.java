package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class PalindromeLinkedList {

    public static boolean isPalindrome(ListNode head) {

        if (head.next == null)
            return true;
        ListNode current = head;
        ListNode reversed = reverse(current);
        Utils.print(head);
        //Utils.print(reversed);

        while (current != null) {
            if (current.val != reversed.val)
                return false;
            current = current.next;
            reversed = reversed.next;
        }
        return true;
    }

    public static ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        //[1,1,2,1]
        System.out.println(isPalindrome(head));
    }
}
