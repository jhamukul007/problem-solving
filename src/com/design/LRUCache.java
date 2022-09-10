package com.design;



import com.utils.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    DoublyLinkedList<Integer, Integer> first;
    DoublyLinkedList<Integer, Integer> last;
    Map<Integer, DoublyLinkedList<Integer, Integer>> cache;

    int capacity;

    public LRUCache(int capacity) {
        first = last = null;
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        int data = 0;
        if (data != -1) {
            // lruOrder.remove(key);
            // lruOrder.addLast(key);
        }
        return data;
    }

    public void put(int key, int value) {
        if (cache.size() < capacity) {

            //cache.put(key, value);
            //lruOrder.addLast(key);
        } else {
//            if(lruOrder.getLast() == key){
//            }
//            else {
//                int leastUsed = lruOrder.removeFirst();
//                cache.remove(leastUsed);
//                lruOrder.addLast(key);
//            }
//            cache.put(key, value);
        }
    }

    void addLast(int key, int val) {
        DoublyLinkedList<Integer, Integer> curr = new DoublyLinkedList<>(key, val);
        curr.prev = last;
        last.next = curr;
        last = curr;
    }

    void addFirst(int key, int val) {
        DoublyLinkedList<Integer, Integer> curr = new DoublyLinkedList<>(key, val);
        first.prev = curr;
        curr.next = first;
        first = curr;
    }

    void remove(int key) {
        DoublyLinkedList<Integer, Integer> toRemove = cache.get(key);

        if (toRemove != null) {
            DoublyLinkedList<Integer, Integer> nextNode = toRemove.next;
            DoublyLinkedList<Integer, Integer> preNode = toRemove.prev;
            if (preNode != null)
                preNode.next = nextNode;
            if (nextNode != null)
                nextNode.prev = preNode;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        System.out.println(lru.get(2));
        lru.put(2, 6);
        System.out.println(lru.get(1));
        lru.put(1, 5);
        lru.put(1, 2);
        // System.out.println("------ put ------- "+ lru.lruOrder+   " cache " + lru.cache  );
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
}


