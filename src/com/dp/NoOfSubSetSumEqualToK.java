package com.dp;

import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/number-of-subsets_3952532
 */
public class NoOfSubSetSumEqualToK {
    /**
     * * Recursion
     * @param arr
     * @param target
     * @return
     */
    public int totalSubSet(int[] arr, int target){
        return totalSubSet(arr, arr.length-1, target);
    }

    int totalSubSet(int[] arr, int index, int target){
        if(target == 0)
            return 1;
        if(index == 0)
            return target == arr[index] ? 1 : 0;
        int notPicked = totalSubSet(arr, index-1, target);
        int picked = 0;
        if(arr[index] <= target)
            picked = totalSubSet(arr, index-1, target - arr[index]);
        return picked + notPicked;
    }


    public static int findWays(int num[], int tar) {
        int[][] matrix = new int[num.length][tar];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = -1;
            }
        }
        Utils.print(matrix);
        return totalSubSet(num, num.length-1, tar, matrix);
    }

    static int totalSubSet(int[] arr, int index, int target, int[][] matrix){
        if(target == 0)
            return 1;
        if(index == 0)
            return target == arr[index] ? 1 : 0;
        if(matrix[index][target] != -1)
            return matrix[index][target];

        int notPicked = totalSubSet(arr, index-1, target, matrix);
        int picked = 0;
        if(arr[index] <= target)
            picked = totalSubSet(arr, index-1, target - arr[index], matrix);
        return matrix[index][target] = picked + notPicked;
    }

    public static void main(String[] args) {
        int[] a1 = {1,2,2,3};
        int t1 = 3;
        int[] a2 = {1,2,1,3} ;
        int t2 = 4;
        System.out.println(findWays(a1, t1));
        System.out.println(findWays(a2, t2));

    }

}
