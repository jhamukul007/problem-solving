package com.subarray;

/**
 * 713. Subarray Product Less Than K
 * https://leetcode.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public static int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k <= 1)
            return 0;

        int total = 0, product = 1, i = 0;

        for (int j = 0; j < nums.length; j++) {
            product *= nums[j];
            while (product >= k) {
                product /= nums[i++];
            }
            total += j - i + 1;
        }
        return total;
    }

    public static void main(String[] args) {
        //  int[] arr = {10,5,2,6};
        int[] arr1 = {1, 1, 1};
        System.out.println(numSubarrayProductLessThanK(arr1, 2));
    }

}
/*
total = 1+2+2+3 = 8
    i
[10,5,2,6], k = 100
        j

  total = 6
        j
 [1, 1, 1]   k = 2
     i
*/
