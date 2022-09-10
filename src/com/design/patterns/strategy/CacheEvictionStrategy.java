package com.design.patterns.strategy;

public interface CacheEvictionStrategy<K,V> {
    void put(K key, V value);
    V get(K key);
}
