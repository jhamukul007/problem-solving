package com.array;

/**
 *  Minimum Swaps to Group All 1's Together
 *  https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/
 */
public class MinimumSwapsToGroupAll1STogether {

    /**
     * Time : O(n)
     * Space: O(1)
     * Approach: Sliding Window
     * @param data
     * @return
     */
    public int minSwaps(int[] data) {
        int len = data.length;
        if(len == 1)
            return 0;
        int totalOne = 0;

        for(int d: data){
            totalOne += d;
        }

        if(totalOne == 1 || totalOne == len)
            return 0;

        int oneInThisWindow = 0;

        for(int i = 0; i < totalOne; i++ ){
            oneInThisWindow += data[i];
        }
        int minSwap = totalOne - oneInThisWindow;
        for(int i = totalOne; i < len; i++){
            oneInThisWindow -= data[i-totalOne];
            oneInThisWindow += data[i];
            minSwap = Math.min(minSwap,totalOne-oneInThisWindow );
        }
        return minSwap;
    }

// k = 2
// k = n

// // less than k < n


// Maximum continous 1's in a window of size k.
// 1) what is the actual value of k. k < n
// 2)

// Total no of 1's in array ?


// totalOnce =

// 1 0 0 0 1 0 0 0 = 2;

// 1 0 1 0 1 0 0 1 1 0 1

// total : 6

// Algo:
// step 1: count no of once in array that is winow size.
// step 2: start window from zero to i = window size.
// step 3: minSwap = totalNoOfOnce - totalOneInThisWindow.
}


