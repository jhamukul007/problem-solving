package com.dp;

import com.utils.Utils;

public class CoinChange {

    /** Recursion
     * * Time 2 ^ n
     * * Space: O(n)
     * @param coins
     * @param amount
     * @return
     */
    public int minNumberOfCoins(int[] coins, int amount){
       int minCoins = minNumberOfCoins(coins, coins.length-1, amount);
       return minCoins == 1000000 ? -1 : minCoins;
    }

    private int minNumberOfCoins(int[] coins, int index, int remainingAmount){
        if(remainingAmount == 0)
            return 0;
        if(index == 0)
            return remainingAmount % coins[0] == 0 ?  remainingAmount / coins[0] : 1000000;

        int notPicked = minNumberOfCoins(coins, index-1, remainingAmount);

        int picked = 1000000;

        if(coins[index] <= remainingAmount)
            picked = 1 + minNumberOfCoins(coins, index , remainingAmount - coins[index]);

        return Math.min(notPicked, picked);
    }

    /** Memorization
     * * Time : O(n * m)
     * * Space: O(n) + O(n * m)
     * @param
     */
    public int coinChange(int[] coins, int amount) {
        int[][] temp = new int[coins.length][amount+1];
        int minCoins = coinChange(coins, coins.length-1, amount, temp);
        return minCoins == 1000000 ? -1 : minCoins;
    }

    public int coinChange(int[] coins, int index, int remainingAmount, int[][] temp){
        if(remainingAmount == 0)
            return 0;

        if(index == 0)
            return remainingAmount % coins[0] == 0 ?  remainingAmount / coins[0] : 1000000;
        if(temp[index][remainingAmount] != 0)
            return temp[index][remainingAmount];

        int notPick = coinChange(coins, index-1, remainingAmount, temp);

        int pick = 1000000;

        if(coins[index] <= remainingAmount)
            pick = 1 + coinChange(coins, index, remainingAmount- coins[index], temp);

        return temp[index][remainingAmount] = Math.min(notPick, pick);
    }

    /**
     * * Tabulation
     * * Time: O(m*n)
     * *  Space: O(m*n)
     * @param coins
     * @param amount
     * @return
     */

    public int coinChangeTabulation(int[] coins, int amount) {
        int[][] dp = new int[coins.length][amount+1];
        int rows = dp.length, col = dp[0].length;
        for(int i = 0; i < col; i++)
            dp[0][i] = i % coins[0] == 0 ?  i / coins[0] : 1000000;

        for(int i = 1; i < rows; i++){
            for(int j = 1; j < col; j++){
                int notPicked = dp[i-1][j];
                int picked = 1000000;
                if(coins[i] <= j)
                    picked = 1 + dp[i][j-coins[i]];
                dp[i][j] = Math.min(notPicked, picked);
            }
        }
        return dp[rows-1][col-1] == 1000000 ? -1 : dp[rows-1][col-1];
    }

    /**
     * * Tabulation with space optimized
     * * Time: O(m*n)
     * *  Space: O(amount)
     * @param coins
     * @param amount
     * @return
     */
    public int coinChangeTabulationSpaceOptimized(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        int rows = dp.length;
        for(int i = 0; i < dp.length; i++)
            dp[i] = i % coins[0] == 0 ?  i / coins[0] : 1000000;

        for(int i = 1; i < coins.length; i++){
            for(int j = 1; j < rows; j++){
                int notPicked = dp[j];
                int picked = 1000000;
                if(coins[i] <= j)
                    picked = 1 + dp[j-coins[i]];
                dp[j] = Math.min(notPicked, picked);
            }
        }
        return dp[rows-1] == 1000000 ? -1 : dp[rows-1];
    }

    public static void main(String[] args) {
        CoinChange obj = new CoinChange();
        int[] coins = {1,2,5};
        int amount = 11;

        int[] coins1 = {2};
        int amount1 = 3;

        int[] coins2 = {1};
        int amount2 = 0;

        Utils.printHeadLine("Recursion");
        System.out.println(obj.minNumberOfCoins(coins, amount));
        System.out.println(obj.minNumberOfCoins(coins1, amount1));
        System.out.println(obj.minNumberOfCoins(coins2, amount2));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.coinChange(coins, amount));
        System.out.println(obj.coinChange(coins1, amount1));
        System.out.println(obj.coinChange(coins2, amount2));
    }


}
