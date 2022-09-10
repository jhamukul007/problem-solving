package com.design.cache;

import com.utils.linkedlist.DoublyLinkedList;
import com.utils.pairs.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache design
 */
public class LeastRecentlyUsedCache {

    Map<Integer, DoublyLinkedList<Pair<Integer, Integer>>> cache;
    DoublyLinkedList<Pair<Integer, Integer>> recentlyUsed;
    DoublyLinkedList<Pair<Integer, Integer>> leastUsed;
    int cacheSize;

    public LeastRecentlyUsedCache(int size) {
        this.cache = new HashMap<>();
        this.cacheSize = size;
        recentlyUsed = leastUsed = null;
    }

    public void put(int key, int value) {
        DoublyLinkedList<Pair<Integer, Integer>> existedNode = cache.get(key);
        if (existedNode != null) {
            update(existedNode, key, value);
            return;
        }
        DoublyLinkedList<Pair<Integer, Integer>> newNode = getNode(key, value);
        if (cache.size() < cacheSize) {
            addLast(newNode);
        } else {
            removeLeastUsed();
            addLast(newNode);
            //put(key, value);
        }
        cache.put(key, newNode);
    }

    void update(DoublyLinkedList<Pair<Integer, Integer>> node, int key, int value) {

        if (recentlyUsed == node)
            recentlyUsed.data.setValue(value);
        else {
            DoublyLinkedList<Pair<Integer, Integer>> previousNode = node.previous;
            if (previousNode != null) {
                previousNode.next = node.next;
                node.next.previous = previousNode;
            }
            node.next.previous = null;
            leastUsed = node.next;
            node.data.setValue(value);
            addLast(node);
            cache.put(key, node);
        }
    }

    public int get(int key) {
        DoublyLinkedList<Pair<Integer, Integer>> existedNode = cache.get(key);
        if (existedNode == null)
            return -1;
        if (recentlyUsed == existedNode)
            return existedNode.data.getValue();
        else {
            DoublyLinkedList<Pair<Integer, Integer>> previousNode = existedNode.previous;
            if (previousNode != null) {
                previousNode.next = existedNode.next;
                existedNode.next.previous = previousNode;
            }
            existedNode.next.previous = null;
            leastUsed = existedNode.next;
        }
        addLast(existedNode);
        return existedNode.data.getValue();
    }

    void removeLeastUsed() {
        if (leastUsed == null)
            return;
        int key = leastUsed.data.getKey();
        if (leastUsed.next != null)
            leastUsed.next.previous = null;
        leastUsed = leastUsed.next;
        cache.remove(key);
    }
    // 1 <->  2 <-> 3

    void addLast(DoublyLinkedList<Pair<Integer, Integer>> node) {
        if (recentlyUsed != null) {
            node.previous = recentlyUsed;
            recentlyUsed.next = node;
        }
        recentlyUsed = node;
        if (leastUsed == null)
            leastUsed = node;
    }

    public DoublyLinkedList<Pair<Integer, Integer>> getNode(int key, int value) {
        DoublyLinkedList<Pair<Integer, Integer>> newNode = new DoublyLinkedList<>(new Pair<>(key, value));
        return newNode;
    }



    public static void main(String[] args) {
        //LeastRecentlyUsedCache lru = new LeastRecentlyUsedCache(3);
//        lru.put(1, 1);
//        lru.put(2, 2);
//        lru.put(3, 3);
//        System.out.println(lru.get(1)); // 2 3 1
//        lru.put(4, 4); // 3 1 4
//        System.out.println(lru.get(2)); // -1
//        System.out.println(lru.get(3)); // 3 --> 1 4 3
//        lru.put(5, 5); // 4 3 5
//
//        System.out.println(lru.get(3)); // 4 5 3
//        lru.put(6, 6); // 5 3 6
//        // System.out.println(lru.get(4));

//        ["LRUCache","put","put","get","put","get","put","get","get","get"]
        //[[2],[1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
//        LeastRecentlyUsedCache lru = new LeastRecentlyUsedCache(2);
//        lru.put(1,1);
//        lru.put(2,2);
//        System.out.println(lru.get(1)); // 2 1
//        lru.put(3,3); // 1 3
//        System.out.println(lru.get(2)); // -1
//        lru.put(4,4); // 3 4
//        System.out.println(lru.get(1)); // -1
//        System.out.println(lru.get(3)); // 4 3
//        System.out.println(lru.get(4)); // 3 4


//        ["LRUCache","get","put","get","put","put","get","get"]
//           [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
//        LeastRecentlyUsedCache lru = new LeastRecentlyUsedCache(2);
//        System.out.println(lru.get(2)); // -1
//        lru.put(2, 6); // 2
//        System.out.println(lru.get(1)); // -1
//        lru.put(1, 5); // 2 1
//        lru.put(1, 2); // 2 1
//        System.out.println(lru.get(1)); // 2
//        System.out.println(lru.get(2)); //  6



        LeastRecentlyUsedCache lru = new LeastRecentlyUsedCache(2);
        lru.put(2, 1); // 2
        lru.put(1, 1); // 2 1
        lru.put(2, 3); // 1 2
        lru.put(4, 1); // 2 4
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(2)); // 3

//        ["LRUCache","put","put","put","put","get","get"]
            //[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]





    }

}
