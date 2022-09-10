package com.design.patterns.strategy;

public class LRUCacheEvictionStrategy<K,V> implements CacheEvictionStrategy<K,V> {

    @Override
    public void put(K key, V value) {
        System.out.println("Added key and value as per LRU policy: " + key);
    }

    @Override
    public V get(K key) {
        System.out.println("get value as per LFU policy: " + key);
        return null;
    }
}
