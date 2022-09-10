package com.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380.Insert Delete GetRandom O(1)
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class InsertDeleteRandom {


    List<Integer> dataList;
    Map<Integer, Integer> indexMap;
    Random random;
    int size;

    public InsertDeleteRandom() {
        dataList = new ArrayList<>();
        indexMap = new HashMap<>();
        random = new Random();
        size = 0;
    }

    public boolean insert(int val) {
        boolean isExist = indexMap.containsKey(val);
        if (isExist)
            return false;
        int index = -1;

        if (dataList.size() > size) {
            index = size;
            dataList.set(index, val);
        } else {
            dataList.add(val);
            index = dataList.size() - 1;
        }

        indexMap.put(val, index);
        size++;
        return true;
    }

    public boolean remove(int val) {
        int index = indexMap.getOrDefault(val, -1);
        if (index == -1)
            return false;

        int dataToBeDeleted = dataList.get(index);
        int lastData = dataList.get(size - 1);
        dataList.set(size - 1, dataToBeDeleted);
        dataList.set(index, lastData);
        indexMap.put(lastData, index);
        indexMap.remove(val);
        size--;
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(size);
        return dataList.get(randomIndex);
    }


    public static void main(String[] args) {
        InsertDeleteRandom obj = new InsertDeleteRandom();
        obj.insert(0);
        obj.insert(1);
        obj.remove(0);
        obj.insert(2);
        obj.remove(1);
        System.out.println(obj.getRandom());
    }
}
