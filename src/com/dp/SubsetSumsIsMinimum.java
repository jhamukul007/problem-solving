package com.dp;

import com.utils.Utils;

/**
 * * Partition a set into two subsets such that the difference of subset sums is minimum.
 * * https://www.codingninjas.com/codestudio/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494
 */
public class SubsetSumsIsMinimum {

    int subsetSumsIsMinimum(int[] arr){
        int len = arr.length;
        if(len == 1)
            return arr[0];
        int totalSum = 0;
        for(int data : arr)
            totalSum += data;
        boolean[][] dp = subsetEqualToK(arr, totalSum);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length; i++){
            if(dp[len-1][arr[i]]){
                int secSum = totalSum - arr[i];
                minDiff = Math.min(minDiff, Math.abs(arr[i] - secSum));
            }
        }
        return minDiff;
    }

    private boolean[][] subsetEqualToK(int[] arr, int k) {
        boolean[][] matrix = new boolean[arr.length][k];
        for (int index = 0; index < matrix.length; index++)
            matrix[index][0] = true;
        if (arr[0] <= k)
            matrix[0][arr[0]] = true;

        for (int index = 1; index < matrix.length; index++) {
            for (int target = 1; target < matrix[0].length; target++) {
                matrix[index][target] = matrix[index - 1][target] || matrix[index - 1][target - arr[index]];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
//        SubsetSumsIsMinimum obj = new SubsetSumsIsMinimum();
//        int[] a1 = {1,2,3,4};
//        int[] a2 = {8,6,5};
//
//        Utils.printHeadLine("Dynamic Programming");
//        obj.subsetSumsIsMinimum(a1);
//        obj.subsetSumsIsMinimum(a2);








    }
}
