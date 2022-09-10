package com.utils;

public class DoublyLinkedList<K, V> {

    public DoublyLinkedList<K, V> next;
    public DoublyLinkedList<K, V> prev;
    public K key;
    public V value;

    public DoublyLinkedList(K key, V value) {
        this.prev = null;
        this.next = null;
        this.key = key;
        this.value = value;
    }

    public DoublyLinkedList() {
        this.prev = null;
        this.next = null;
    }

}
