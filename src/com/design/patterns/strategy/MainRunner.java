package com.design.patterns.strategy;

import static com.design.patterns.strategy.EvictionPolicy.LFU;
import static com.design.patterns.strategy.EvictionPolicy.LRU;

public class MainRunner {
    public static void main(String[] args) {
        EvictionStrategyBuilder<String,String> lru = new EvictionStrategyBuilder<>(LRU);
        lru.put("name", "Mukul");
        lru.put("lastName", "Jha");
        lru.get("name");

        EvictionStrategyBuilder<String,String> lfu = new EvictionStrategyBuilder<>(LFU);
        lfu.put("name", "Mukul");
        lfu.put("lastName", "Jha");
        lfu.get("name");
    }
}
