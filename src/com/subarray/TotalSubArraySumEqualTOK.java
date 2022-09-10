package com.subarray;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/subarray-sum-equals-k/
 * 560. Subarray Sum Equals K
 */
public class TotalSubArraySumEqualTOK {

    public static int totalSubArraySumEqualTOK(int[] arr, int k) {
        if (arr.length == 1)
            return arr[0] == k ? 1 : 0;
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);
        int prefixSum = 0;
        int totalSubArray = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            int prefixCount = prefixCounts.getOrDefault(prefixSum - k, 0);
            totalSubArray += prefixCount;
            prefixCounts.put(prefixSum, prefixCounts.getOrDefault(prefixSum, 0) + 1);
        }
        return totalSubArray;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(totalSubArraySumEqualTOK(arr, 2));
    }
}
