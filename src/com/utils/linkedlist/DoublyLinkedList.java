package com.utils.linkedlist;

public class DoublyLinkedList<T> {
    public T data;
    public DoublyLinkedList<T> previous;
    public DoublyLinkedList<T> next;

    public DoublyLinkedList(T data) {
        this.data = data;
        previous = next = null;
    }
}
