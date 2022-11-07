package com.bloom.filter;

public class BloomFilter {

    int[] arr;
    int capacity;
    public BloomFilter(int capacity){
        arr = new int[capacity];
        this.capacity = capacity;
    }

    private int hashOne(Integer data){
        return data.hashCode() % capacity;
    }

    private int hashTwo(Integer data){
        return data.hashCode() * 2 % capacity;
    }

    public void put(Integer data){
        int index = getFinalHash(data);
        arr[index] = data;
    }

    public int getFinalHash(Integer data){
        int hash1 = hashOne(data);
        int hash2 = hashTwo(hash1);
        int hash3 = hashOne(3 * hash2);
        int hash4 = hashTwo(2 * 100* hash3);
        return hash4;
    }

    public boolean doesNotExist(Integer data){
       int index = getFinalHash(data);
        return data != arr[index];
    }

    public static void main(String[] args) {
        BloomFilter bf = new BloomFilter(11);
        bf.put(5);
        bf.put(1);
        System.out.println(bf.doesNotExist(2));
        bf.put(8);
        bf.put(6);
        System.out.println(bf.doesNotExist(7));
        System.out.println(bf.doesNotExist(4));
        System.out.println(bf.doesNotExist(10));
        System.out.println(bf.doesNotExist(3));
        System.out.println(bf.doesNotExist(1));
    }

}
