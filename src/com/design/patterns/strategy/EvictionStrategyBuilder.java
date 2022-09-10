package com.design.patterns.strategy;

public class EvictionStrategyBuilder<K, V> {

    private CacheEvictionStrategy<K, V> strategy;

    public EvictionStrategyBuilder(EvictionPolicy evictionPolicy) {
        this.strategy = getStrategy(evictionPolicy);
    }

    CacheEvictionStrategy<K, V> getStrategy(EvictionPolicy evictionPolicy) {
        if (evictionPolicy == null)
            throw new IllegalArgumentException("EvictionPolicy must not be null");
        switch (evictionPolicy) {
            case LRU:
                return new LRUCacheEvictionStrategy<>();
            case LFU:
                return new LFUCacheEvictionStrategy<>();
            default:
                throw new IllegalArgumentException("Strategy does not supported");
        }
    }

    public void put(K key, V value) {
        strategy.put(key, value);
    }

    public V get(K key) {
        return strategy.get(key);
    }
}
