package com.utils;

import java.util.HashMap;
import java.util.Map;

public class TriesNode {
    public Map<Character, TriesNode> child;
    public boolean isEnd;

    public TriesNode() {
        child = new HashMap<>();
        isEnd = false;
    }

    @Override
    public String toString() {
        return "TriesNode{" +
                "child=" + child +
                ", isEnd=" + isEnd +
                '}';
    }
}
