package com.linkedlist;

import com.utils.ListNode;

public class MinimizeFirstNode {

    public static int minimizeFirstNode(ListNode head, int k) {
        if (head == null || k == 0) return -1;
        ListNode cur = head;
        int i = 0;
        int min = Integer.MAX_VALUE;
        if (k == 1) {
            return head.next != null ? head.next.val : -1;
        }
        while (cur != null && i <= k) {
            if (i == k) {
                if (cur.next != null && cur.next.val < min) {
                    min = cur.next.val;
                    return min;
                }
            }
            min = Math.min(min, cur.val);
            cur = cur.next;
            i++;
        }
        return min;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);
        System.out.println(minimizeFirstNode(head, 1));
        ListNode head1 = new ListNode(5);
        // System.out.println(minimizeFirstNode(head1, 1));
    }
}


//if (k+1)th element is smallest among all first k
//worth to delete k element

// k == 1
// and first element is smaller then next
// we can delete but wont insert

// if we find minimum element in between 0 and K-1
// then insert the smallest element as head of list


// list size is smaller than k
// then -1