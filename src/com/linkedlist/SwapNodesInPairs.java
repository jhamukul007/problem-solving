package com.linkedlist;

import com.utils.ListNode;
import com.utils.Utils;

public class SwapNodesInPairs {
    //
    public ListNode swapPairsValues(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            int temp = cur.next.val;
            cur.next.val = cur.val;
            cur.val = temp;
            cur = cur.next.next;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode nextNode;
        ListNode prevNode = head;
        ListNode cur = head.next;
        head = cur;

        while (prevNode != null && cur != null) {
            nextNode = cur.next;
            cur.next = prevNode;
            prevNode.next = nextNode;
            if (nextNode == null)
                break;
            prevNode = nextNode;
            cur = prevNode.next;
        }
        return head;
    }

    // 1 -> 2 -> 3 -> 4

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        SwapNodesInPairs obj = new SwapNodesInPairs();
        Utils.printListNode(obj.swapPairs(head));
    }
}

// 1 2 3 4


