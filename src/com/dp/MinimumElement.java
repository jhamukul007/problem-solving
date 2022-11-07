package com.dp;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/minimum-elements_3843091
 */
public class MinimumElement {
    /**
     * *  Recursion
     * * Time: O(2 ^ n)
     * * Space : O(n)
     *
     * @param num
     * @param x
     * @return
     */
    public static int minimumElements(int num[], int x) {
        int totalCoins = minimumElements(num, num.length - 1, x);
        return totalCoins == 10000000 ? -1 : totalCoins;
    }

    private static int minimumElements(int[] nums, int index, int total) {
        if (total == 0) return 0;
        if (index == 0) {
            int lastCoin = nums[index];
            return total % lastCoin == 0 ? total / lastCoin : 10000000;
        }

        int notPicked = minimumElements(nums, index - 1, total);
        int picked = Integer.MAX_VALUE;

        if (total >= nums[index])
            picked = 1 + minimumElements(nums, index, total - nums[index]);

        return Math.min(picked, notPicked);
    }

    /**
     * * Memorization
     * * Time : O(n)
     * * Space: O(n*x) + O(n)
     *
     * @param num
     * @param x
     * @return
     */
    public static int minimumElementsMemorization(int num[], int x) {
        int[][] dp = new int[num.length][x + 1];

        int totalCoins = minimumElementsMemorization(num, num.length - 1, x, dp);
        return totalCoins == 10000000 ? -1 : totalCoins;
    }

    private static int minimumElementsMemorization(int[] nums, int index, int total, int[][] dp) {
        if (total == 0) return 0;
        if (index == 0) {
            int lastCoin = nums[index];
            return total % lastCoin == 0 ? total / lastCoin : 10000000;
        }
        if (dp[index][total] != 0)
            return dp[index][total];

        int notPicked = minimumElementsMemorization(nums, index - 1, total, dp);
        int picked = Integer.MAX_VALUE;

        if (total >= nums[index])
            picked = 1 + minimumElementsMemorization(nums, index, total - nums[index], dp);

        return dp[index][total] = Math.min(picked, notPicked);
    }

    /**
     * * DP
     * * Time : O(n*x)
     * * Space: O(n*x)
     *
     * @param nums
     * @param x
     * @return
     */
    public static int minimumElementsDP(int nums[], int x) {
        int[][] dp = new int[nums.length][x + 1];
        int m = dp.length, n = dp[0].length;
        for (int i = 1; i < n; i++) {
            int coin = nums[0];
            dp[0][i] = i % coin == 0 ? i / coin : 1000000;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int notPick = dp[i - 1][j];
                int pick = Integer.MAX_VALUE;
                if (j >= nums[i])
                    pick = 1 + dp[i][j - nums[i]];
                dp[i][j] = Math.min(pick, notPick);
            }
        }
       // Utils.print(dp);
        return dp[m - 1][n - 1] == 1000000 ? -1 : dp[m - 1][n - 1];
    }

    /**
     * * DP Optimized
     * * Time : O(n*x)
     * * Space: O(x)
     *
     * @param nums
     * @param x
     * @return
     */
    public static int minimumElementsDPOptimized(int nums[], int x) {
        int[] last = new int[x+1];
        int len = last.length;
        for(int i = 1; i < len; i++){
            int coin = nums[0];
            last[i] = i % coin == 0 ? i/coin : 1000000;
        }
        int[] cur = new int[x+1];
        for(int i = 1; i < nums.length; i++){

            for(int j = 1; j < len; j++){
                int pick = Integer.MAX_VALUE;
                if(j >= nums[i])
                    pick = 1 + cur[j-nums[i]];
                cur[j] = Math.min(last[j], pick);
            }
            last = cur;
        }
        return last[len-1] == 1000000 ? -1 : last[len-1];
    }

    public static void main(String[] args) {

        int[] nums = {12, 1, 3};
        int x = 4;

        int[] nums1 = {1, 2, 3};
        int x1 = 10;

        int[] nums2 = {2, 1};
        int x2 = 11;

        int[] nums3 = {1,2,3};
        int x3 = 7;

        Utils.printHeadLine("Recursion");
        System.out.println(minimumElements(nums, x));
        System.out.println(minimumElements(nums1, x1));
        System.out.println(minimumElements(nums2, x2));
        System.out.println(minimumElements(nums3, x3));


        Utils.printHeadLine("Memorization");
        System.out.println(minimumElementsMemorization(nums, x));
        System.out.println(minimumElementsMemorization(nums1, x1));
        System.out.println(minimumElementsMemorization(nums2, x2));
        System.out.println(minimumElementsMemorization(nums3, x3));

        Utils.printHeadLine("DP");
        System.out.println(minimumElementsDP(nums, x));
        System.out.println(minimumElementsDP(nums1, x1));
        System.out.println(minimumElementsDP(nums2, x2));
        System.out.println(minimumElementsDP(nums3, x3));

        Utils.printHeadLine("DP Optimized");
        System.out.println(minimumElementsDPOptimized(nums, x));
        System.out.println(minimumElementsDPOptimized(nums1, x1));
        System.out.println(minimumElementsDPOptimized(nums2, x2));
        System.out.println(minimumElementsDPOptimized(nums3, x3));

    }
}
