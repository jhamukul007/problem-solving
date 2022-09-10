package com.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * Time  Complexity worst case : O(n)
     * Space Complexity worst case : O(no of unique element)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            int count = countMap.getOrDefault(num,0);
            if(count + 1 > nums.length/2)
                return num;
            else
                countMap.put(num, count+1);
        }
        return -1;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @return
     */
    public int majorityElementOptimized(int[] nums){
        int majority = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(majority != nums[i])
                count --;
            else
                count++;
            if(count == 0){
                majority = nums[i];
                count = 1;
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        MajorityElement obj = new MajorityElement();
        //int[] arr = {2,3,2,1,2,1};
        //System.out.println(obj.majorityElement(arr));
    }

}
