package com.array;

/**
 * https://leetcode.com/problems/maximum-subarray/
 * 53. Maximum Subarray
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int maximumSubArraySum = Integer.MIN_VALUE;
        int sumTill = 0;
        int len = nums.length;
        if(len == 1)
            return nums[0];
        for(int i = 0; i < len; i++){
            sumTill += nums[i];
            maximumSubArraySum = Math.max(maximumSubArraySum,sumTill );
            if(sumTill < 0)
                sumTill = 0;

        }
        return maximumSubArraySum;
    }

}
