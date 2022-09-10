package com.dp;

import com.utils.Utils;

public class ClimbingStairs {

    /**
     * Recursion
     * Time Complexity: O(2^n)
     * Space: O(n) recursion stack
     */
    public int climbingStairsRecursion(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return climbingStairsRecursion(n - 1) + climbingStairsRecursion(n - 2);
    }

    /**
     * Memorization
     * Time : O(n)
     * Space: O(n) + O(n) -> Stack Space
     * @param n
     */
    public int climbingStairsMemorization(int n) {
        int[] dp = new int[n + 1];
        return climbingStairsMemorization(n, dp);
    }

    private int climbingStairsMemorization(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = climbingStairsMemorization(n - 1) + climbingStairsMemorization(n - 2);
    }

    /**
     * Tabulation
     * Space: O(n) -> Dp array
     * Time : O(n)
     * @param n
     * @return
     */
    public int climbingStairsTabulation(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    /**
     * Optimized
     * Space: O(1)
     * Time : O(n)
     * @param n
     * @return
     */
    public int climbingStairsOptimized(int n) {
        int lastStairsCount = 1;
        int secLastStairsCount = 1;
        for(int i = 2 ; i <= n; i++){
            int currentStairsCount = lastStairsCount + secLastStairsCount;
            secLastStairsCount = lastStairsCount;
            lastStairsCount = currentStairsCount;
        }
        return lastStairsCount;
    }



    public static void main(String[] args) {

        ClimbingStairs obj = new ClimbingStairs();

        System.out.println("------------**Recursion**----------");
        Utils.print(obj.climbingStairsRecursion(4));
        Utils.print(obj.climbingStairsRecursion(3));

        System.out.println("------------**Memorization**----------");
        Utils.print(obj.climbingStairsMemorization(4));
        Utils.print(obj.climbingStairsMemorization(3));

        System.out.println("------------**Tabulation**----------");
        Utils.print(obj.climbingStairsTabulation(4));
        Utils.print(obj.climbingStairsTabulation(3));

        System.out.println("------------**Optimized**----------");
        Utils.print(obj.climbingStairsOptimized(4));
        Utils.print(obj.climbingStairsOptimized(3));
    }

}
