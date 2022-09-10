package com.dp;

import com.utils.Utils;

/**
 * https://www.codingninjas.com/codestudio/problems/frog-jump_3621012
 */
public class FrogJump {

    /**
     * DP
     * Time Complexity: O(n)
     * Space: O(n)
     *
     * @param n
     * @param height
     * @return
     */
    public static int frogJump(int n, int height[]) {
        int[] dp = new int[n];
        if (n == 1)
            return height[0];
        if (n == 2)
            return Integer.min(height[0], height[1]);
        dp[1] = Math.abs(height[1] - height[0]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(Math.abs(height[i - 2] - height[i]) + dp[i - 2],
                    Math.abs(height[i - 1] - height[i]) + dp[i - 1]);
        }
        Utils.print(dp);
        return dp[n - 1];
    }

    /**
     * Dp optimized
     * Time : O(n)
     * Space : O(1)
     *
     * @param n
     * @param height
     * @return
     */
    public static int frogJumpDpOptimized(int n, int height[]) {

        if (n == 1)
            return height[0];
        if (n == 2)
            return Integer.min(height[0], height[1]);
        int lastEnergyLost = Math.abs(height[1] - height[0]);
        int secLastEnergyCount = 0;

        for (int i = 2; i < n; i++) {
            int current = Math.min(Math.abs(height[i - 2] - height[i]) + secLastEnergyCount,
                    Math.abs(height[i - 1] - height[i]) + lastEnergyLost);
            secLastEnergyCount = lastEnergyLost;
            lastEnergyLost = current;
        }
        return lastEnergyLost;
    }

    /**
     * recursion
     *
     * @param
     */

    public static int frogJumpRecursion(int n, int height[]) {
        if (n == 1) return height[0];
        return frogJumpRecursion(height, 0, 0, 0);
    }

    static int frogJumpRecursion(int[] height, int pos, int lastPos, int cost) {
        if (pos >= height.length)
            return cost;

        cost += Math.abs(height[pos] - height[lastPos]);
        return Math.min(frogJumpRecursion(height, pos + 1, pos, cost), frogJumpRecursion(height, pos + 2, pos, cost));
    }


    /**
     * Memorization
     * Time: O(n)
     * Space : O(n) + O(n) -> Stack Space
     *
     * @param
     */
    public static int frogJumpMemorization(int n, int height[]) {
        if (n == 1) return height[0];
        int[] isExecuted = new int[n];
        for (int i = 0; i < n; i++)
            isExecuted[i] = -1;
        return frogJumpMemorization(height, 0, 0, 0, isExecuted);
    }

    static int frogJumpMemorization(int[] height, int pos, int lastPos, int cost, int[] isExecuted) {
        if (pos >= height.length)
            return cost;
        if (isExecuted[pos] != -1)
            return isExecuted[pos];
        cost += Math.abs(height[pos] - height[lastPos]);
        return isExecuted[pos] = Math.min(frogJumpRecursion(height, pos + 1, pos, cost), frogJumpRecursion(height, pos + 2, pos, cost));
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 4, 2, 6, 6, 3, 4};
        int[] arr1 = {10, 20, 30, 10};
        System.out.println(frogJump(arr1.length, arr1));
        System.out.println(frogJumpDpOptimized(arr1.length, arr1));
        System.out.println(frogJumpRecursion(arr1.length, arr1));
        System.out.println(frogJumpMemorization(arr.length, arr));

    }
}
