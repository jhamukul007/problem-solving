package com.array;

/**
 * https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/submissions/
 * 2134. Minimum Swaps to Group All 1's Together II
 */
public class MinimumSwapsToGroupAll1STogetherII {
    /**
     * Time : O(n)
     * Space: O(1)
     * Approach: Sliding window
     * @param nums
     * @return
     */
    public int minSwaps(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        int noOfOnce = 0;
        for(int i : nums){
            noOfOnce += i;
        }
        int windowOnces = 0;
        for(int i = 0; i < noOfOnce; i++){
            windowOnces += nums[i];
        }
        int minSwap = noOfOnce - windowOnces;
        int startingWindow = 0;
        int endOfWindow = noOfOnce;
        while(startingWindow <  len){
            windowOnces -= nums[startingWindow];
            windowOnces += nums[endOfWindow%len];
            startingWindow++;
            endOfWindow++;
            minSwap = Math.min(minSwap, noOfOnce - windowOnces);
        }
        return   minSwap;
    }
    public static void main(String[] args) {
        /*2*(len-windowSize);
          2*(8-3) = 10
          startTingWindow =
          int windowSize = 3;
          // 1,2 ,3,4,5,6,7,8
             0 1  2  3 4 5 6 7
             windowSize = 0
             startTingWindow = currentIndex - windowSize
                              = 0 - 3 = -3 =

        */

    }

}
