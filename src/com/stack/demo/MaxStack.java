package com.stack.demo;

import com.utils.linkedlist.DoublyLinkedList;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * * 716. Max Stack
 * * https://leetcode.com/problems/max-stack/
 */
public class MaxStack {

    DoublyLinkedList<Integer> stack;
    PriorityQueue<Data> maxStack;
    Set<DoublyLinkedList<Integer>> alreadyDeleted;
    int count;

    public MaxStack() {
        stack = new DoublyLinkedList<>(-1);
        maxStack = new PriorityQueue<>(cmp);
        alreadyDeleted = new HashSet<>();
        count = 0;
    }

    /**
     * * Push into stack top
     * * Push into maxStack
     */

    public void push(int data) {
        DoublyLinkedList<Integer> newTop = new DoublyLinkedList<>(data);
        DoublyLinkedList<Integer> nextNode = stack.next;
        newTop.next = nextNode;
        if (nextNode != null)
            nextNode.previous = newTop;
        newTop.previous = stack;
        stack.next = newTop;

        // Adding newTop node into maxStack
        maxStack.add(new Data(newTop, count+1));
        count++;
    }


    public int top() {
        return stack.next != null ? stack.next.data : 0;
    }

    public int peekMax() {
        // check if top element exist in alreadyDeleted if yes delete top element from stack
        Data max = maxStack.peek();
        if (max == null)
            return -1;
        if (alreadyDeleted.contains(max.val)) {
            alreadyDeleted.remove(max.val);
            maxStack.poll();
            return maxStack.poll().val.data;
        }
        return max.val.data;
    }

    public int pop() {
        DoublyLinkedList<Integer> topNode = stack.next;
        if (topNode != null) {
            DoublyLinkedList<Integer> nextTopNode = topNode.next;
            if (nextTopNode != null) {
                nextTopNode.previous = stack;
            }
            stack.next = nextTopNode;
        }
        Data maxNode = maxStack.peek();
        if (maxNode.val == topNode) {
            maxStack.poll();
        } else {
            alreadyDeleted.add(topNode);
        }
        return topNode != null ? topNode.data : -1;
    }

    public int popMax() {
        Data maxTop = maxStack.poll();
        if (alreadyDeleted.contains(maxTop.val)) {
            alreadyDeleted.remove(maxTop);
            maxTop = maxStack.poll();
        }
        DoublyLinkedList<Integer> nextEle = maxTop.val.next;
        DoublyLinkedList<Integer> prev = maxTop.val.previous;
        if (prev != null)
            prev.next = nextEle;

        if (nextEle != null)
            nextEle.previous = prev;

        return maxTop.val.data;
    }

    Comparator<Data> cmp = (o1, o2) -> {
        if (o1.val.data == o2.val.data)
            return o2.count - o1.count;

        else
            return o2.val.data - o1.val.data;
    };

    public static void main(String[] args) {
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        //"top","popMax","top","peekMax","pop","top"]

        System.out.println("top : " + stack.top());
        System.out.println("popMax : " + stack.popMax());
        System.out.println("top : " + stack.top());
        System.out.println("peekMax : " + stack.peekMax());
        System.out.println("pop : " + stack.pop());
        System.out.println("top : " + stack.top());
    }

}

class Data {
    DoublyLinkedList<Integer> val;
    int count;

    public Data(DoublyLinkedList<Integer> val, int count) {
        this.count = count;
        this.val = val;
    }
}
