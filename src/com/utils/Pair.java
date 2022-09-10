package com.utils;

public class Pair {
    public String data;
    public int count;

    public Pair() {
    }

    public Pair(String data, int count) {
        this.data = data;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Pair{" + "data='" + data + '\'' + ", count=" + count + '}';
    }
}
