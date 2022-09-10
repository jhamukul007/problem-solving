package com.array;

import java.util.HashMap;
import java.util.Map;

public class MaximumDistanceBetweenTwoOccurrences {

    public static int maximalDistanceBetweenTwoOccurrences(int[] arr) {
        int len = arr.length;
        if (len == 1)
            return 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        int maxDistance = 0;
        for (int i = 0; i < arr.length; i++) {
            int existedIndex = indexMap.getOrDefault(arr[i], -1);
            if (existedIndex == -1)
                indexMap.put(arr[i], i);
            else
                maxDistance = Math.max(maxDistance, i - existedIndex);
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2};
        System.out.println(maximalDistanceBetweenTwoOccurrences(arr));
    }
}
