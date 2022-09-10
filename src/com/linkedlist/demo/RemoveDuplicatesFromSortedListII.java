package com.linkedlist.demo;

import com.utils.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {
    /**
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode tempNode = new ListNode(0, head);
        ListNode prev = tempNode;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                //Moving pointer to end of matching node, so we are directly mark as prev to next. and skipping same values.
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                //now we have reach at last duplicate node, it's time to remove all duplicate node from linked list
                prev.next = head.next;
            }
            // if next value is not same as current so there is no duplicate here
            else
                prev = prev.next;

            head = head.next;
        }

        return tempNode.next;
    }
}
