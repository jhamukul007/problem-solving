package com.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1658. Minimum Operations to Reduce X to Zero
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 */
public class MinimumOperationsToReduceXToZero {

    public int minOperations(int[] nums, int x) {
        Map<Integer, Integer>  prefixSumTill = new HashMap<>();
        int sum = 0;
        if(nums[0] == x || nums[nums.length-1] == x)
            return 1;
        for(int i = 0 ; i < nums.length; i++){
            sum += nums[i];
            prefixSumTill.put(sum, i);
        }
        System.out.println(prefixSumTill);
        int right = nums.length-1;
        int rightSum = 0;
        int min = Integer.MAX_VALUE;
        while(right >= 0){

            rightSum += nums[right];
            int leftPrefixSumIndex = prefixSumTill.getOrDefault(x-rightSum, -1);
            if((leftPrefixSumIndex != -1 || rightSum == x) && leftPrefixSumIndex < right) {
                min = Math.min(min, (leftPrefixSumIndex+1) + (nums.length -right));
            }
            right--;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }


    public static void main(String[] args) {
        MinimumOperationsToReduceXToZero obj = new MinimumOperationsToReduceXToZero();
        //int[] arr = {1,1,4,2,3};

        //int[] arr = {3,2,20,1,1,3};
        int[] arr = {1,1};
        /*len = 6
        right = 5

         */
        System.out.println(obj.minOperations(arr,3));
    }
    // (left +1)
   /*
    3 - 0
    5 - 1
    25 - 2
    26 - 3
    27 - 4
    30 - 5

    [1,1,4,2,3]
    1+1
    5
    len = 5
    */


}
