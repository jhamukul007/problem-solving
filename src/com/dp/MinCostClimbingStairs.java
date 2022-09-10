package com.dp;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 *
 */
public class MinCostClimbingStairs {
    /**
     * Recusrsion
     *
     */
    public int minCostClimbingStairsRecursion(int[] cost) {
        int len = cost.length;
        if(len == 1)
            return cost[0];
        if(len == 2)
            return Math.min(cost[0], cost[1]);
        return Math.min(minCostClimbingStairsRecursion(cost, 0, 0), minCostClimbingStairsRecursion(cost, 1, 0));
    }

    int minCostClimbingStairsRecursion(int[] arr, int index, int cost){
        if(index >= arr.length)
            return cost;
        cost += arr[index];
        return Math.min(minCostClimbingStairsRecursion(arr, index+1, cost), minCostClimbingStairsRecursion(arr, index+2, cost));
    }


    /**
     * DP
     * Space: O(n)
     * Time: O(n)
     */

    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if(len == 1)
            return cost[0];

        if(len == 2)
            return Math.min(cost[0], cost[1]);
        int[] dp = new int[len+1];
        for(int i = 0 ; i < cost.length; i++){
            dp[i] = cost[i];
        }
        for(int i = 2; i < dp.length; i++){
            dp[i] += Math.min(dp[i-1] , dp[i-2]);
        }
        return dp[dp.length-1];
    }

    /**
     * Dp optimized
     * Time : O(n)
     * Space : O(1)
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        int len = cost.length;
        if(len == 1)
            return cost[0];

        if(len == 2)
            return Math.min(cost[0], cost[1]);

        for(int i = 2; i < cost.length; i++){
            cost[i] += Math.min(cost[i-1] , cost[i-2]);
        }
        int totalCost = Math.min(cost[cost.length-1], cost[cost.length-2]);
        return totalCost;
    }

    /**
     * Dp optimized
     * Time : O(n)
     * Space : O(1)
     * @param cost
     * @return
     */
    public int minCostClimbingStairsOptimized(int[] cost) {
        int secLastStairsCost = cost[0];
        int lastStairsCost = cost[1];

        for(int i = 2; i < cost.length; i++){
            int currentCost = cost[i] + Math.min(lastStairsCost, secLastStairsCost);
            secLastStairsCost = lastStairsCost;
            lastStairsCost = currentCost;
        }
        return Math.min(lastStairsCost,secLastStairsCost) ;
    }



}
