package com.dp;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * * 2393. Count Strictly Increasing Subarrays
 * https://leetcode.com/problems/count-strictly-increasing-subarrays/
 */
public class CountStrictlyIncreasingSubarrays {

    public long countSubarrays(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 1;
        int i = 0, j = 1;
        long totalSubArray = 0;
        while (j < len) {
            if (j == len - 1) {
                long lengthOfSubArray = j - i;
                if (nums[j] <= nums[j - 1])
                    totalSubArray += totalSubString(lengthOfSubArray) + 1;
                else
                    totalSubArray += totalSubString(lengthOfSubArray + 1);
            } else if (nums[j] <= nums[j - 1]) {
                long lengthOfSubArray = j - i;
                totalSubArray += totalSubString(lengthOfSubArray);
                i = j;
            }

            j++;
        }
        return totalSubArray;
    }

    public long countSubarraysOptimized(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return 1;
        long increasingSubArrayLen = 1;
        long totalSubArray = 0;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                increasingSubArrayLen++;
            else {
                totalSubArray += totalSubString(increasingSubArrayLen);
                increasingSubArrayLen = 1;
            }
        }
        totalSubArray += totalSubString(increasingSubArrayLen);
        return totalSubArray;
    }

    long totalSubString(long n) {
        return (n * (n + 1) / 2);
    }

    public static void main(String[] args) {
        CountStrictlyIncreasingSubarrays obj = new CountStrictlyIncreasingSubarrays();
        int[] arr = {755585, 893960, 905533, 995560, 999710, 999897, 999949, 999977, 999985, 999989, 999998, 999999, 1000000, 113743, 375508, 383803, 771723, 305652};
        //System.out.println(obj.countSubarrays(arr));

        Map<Integer, Integer> counter = new HashMap<>();
        counter.put(1, 1);
        counter.put(2, 2);
        counter.put(3, 3);

        Set<Integer> sets = counter.values().stream().collect(Collectors.toSet());

        System.out.println(counter.size() == sets.size());
    }

}
