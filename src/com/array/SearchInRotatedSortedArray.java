package com.array;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 33. Search in Rotated Sorted Array
 * https://jamboard.google.com/d/1lQSEjd1OUCPR8GutvT1uwo7ud5P8fw2idc_Kef0KcdI/viewer?f=2
 */
public class SearchInRotatedSortedArray {
    /*
            Find sorted part of array find if number exists in between sorted subarray.
     */
    public int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 1)
            return nums[0] == target ? 0:-1;
        int start = 0, end = len-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] >= nums[start]){
                if(nums[start] <= target && nums[mid] > target)
                    end = mid-1;
                else
                    start = mid+1;
            }
            else{
                if(target <= nums[end] && target > nums[mid] )
                    start = mid + 1;
                else
                    end = mid-1;
            }
        }
        return -1;
    }

}

