package com.basics;

import java.util.LinkedList;

public class Deque {

    java.util.Deque<Integer> deque;

    public Deque(int capacity) {
        deque = new LinkedList<>();
    }

    public void addFirst(int data) {
        deque.addFirst(data);
    }

    public void addLast(int data) {
        deque.addLast(data);
    }

    public static void main(String[] args) {
        Deque deque = new Deque(3);
        deque.addLast(2);
        System.out.println(deque.deque.getFirst());
        deque.addLast(3);
        System.out.println(deque.deque.getFirst());
        deque.addLast(4);
        System.out.println(deque.deque.getFirst());
        deque.deque.remove(3);
        System.out.println(deque.deque);
        deque.deque.removeFirst();


    }

}
