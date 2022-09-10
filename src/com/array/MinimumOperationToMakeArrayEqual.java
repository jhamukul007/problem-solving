package com.array;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationToMakeArrayEqual {

    public static int minimumOperation(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int data : arr) {
            countMap.put(data, countMap.getOrDefault(data, 0) + 1);
        }
        int maxCount = 0;
        for (int data : countMap.values()) {
            maxCount = Math.max(maxCount, data);
        }
        return len - maxCount;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperation(new int[]{1, 5, 2, 1, 3, 2, 1}));
        System.out.println(minimumOperation(new int[]{1, 2, 3, 4}));
        System.out.println(minimumOperation(new int[]{1, 1, 1, 1}));
    }

}
