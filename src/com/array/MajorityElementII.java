package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. Majority Element II
 * https://leetcode.com/problems/majority-element-ii/
 */
public class MajorityElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums)
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);

        for (int num : countMap.keySet()) {
            if (countMap.get(num) > nums.length / 3)
                result.add(num);
        }
        return result;
    }

}
