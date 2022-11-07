package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;
        ListNode firstHalfLastNode = getEndNodeOfFirstHalf(head);
        ListNode secondHalfFirstNode = reverse(firstHalfLastNode.next);
        ListNode firstHalfFirstNode = head;
        ListNode firstNodeSecondHalf = secondHalfFirstNode;
        boolean isMatch = true;
        while (isMatch && firstNodeSecondHalf != null) {
            if (firstHalfFirstNode.val != firstNodeSecondHalf.val)
                return false;
            firstHalfFirstNode = firstHalfFirstNode.next;
            firstNodeSecondHalf = firstNodeSecondHalf.next;
        }
        reverse(secondHalfFirstNode);
        return true;
    }

    public ListNode getEndNodeOfFirstHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        PalindromeLinkedList obj = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(3);
        System.out.println(obj.isPalindrome(head));
    }

}
