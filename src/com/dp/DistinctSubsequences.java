package com.dp;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * * 115. Distinct Subsequences
 * * https://leetcode.com/problems/distinct-subsequences/
 */
public class DistinctSubsequences {
    /**
     * * Recursion
     * * Time : 2^m * 2 ^n
     * * Space: O(m);
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        return numDistinct(s, s.length()-1, t, t.length()-1);
    }

    private int numDistinct(String s, int s1, String t, int t1){
        if(t1 < 0)
            return 1;
        if(s1 < 0)
            return 0;

        if(s.charAt(s1) == t.charAt(t1))
            return numDistinct(s, s1-1, t, t1-1) +  numDistinct(s, s1-1, t, t1);
        else
            return numDistinct(s, s1-1, t, t1);
    }

    /**
     * * Memorization
     * * Time : O(m*n)
     * * Space: O(m*n) + O(m);
     * @param s
     * @param t
     * @return
     */
    public int numDistinctMemorization(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        MatrixUtil.fill(dp, -1);
        return numDistinctMemorization(s, s.length()-1, t, t.length()-1, dp);
    }

    private int numDistinctMemorization(String s, int s1, String t, int t1, int[][] dp){
        if(t1 < 0)
            return 1;
        if(s1 < 0)
            return 0;
        if(dp[s1][t1] != -1)
            return dp[s1][t1];
        if(s.charAt(s1) == t.charAt(t1))
            return dp[s1][t1] = numDistinctMemorization(s, s1-1, t, t1-1, dp) +  numDistinctMemorization(s, s1-1, t, t1, dp);
        else
            return dp[s1][t1] = numDistinctMemorization(s, s1-1, t, t1, dp);
    }

    /**
     * * Dynamic Programming
     * * Time : O(m*n)
     * * Space: O(m*n)
     * @param s
     * @param t
     * @return
     */
    public int numDistinctDP(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];

        int rows = dp.length, col = dp[0].length;
        for(int i = 0; i < rows; i++)
            dp[i][0] = 1;

        for(int i = 1; i <  rows ; i++){
            for(int j = 1; j < col; j++){

                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[rows-1][col-1];
    }

    /**
     * *
     * @param s
     * @param t
     * @return
     */
    public int numDistinctOptimized(String s, String t) {
        int[] prev = new int[t.length()+1];
        int[] cur;

        prev[0] = 1;

        for(int i = 1; i <  s.length()+1 ; i++){
            cur = new int[t.length()+1];
            cur[0] = 1;
            for(int j = 1; j < t.length()+1; j++){

                if(s.charAt(i-1) == t.charAt(j-1))
                    cur[j] = prev[j-1] + prev[j];
                else
                    cur[j] = prev[j];
            }
            //int[] temp = prev;
            prev = cur;
            //cur = prev;
        }

        return prev[t.length()];
    }

    /**
     * * Optimized DP
     * * Time : O(m*n)
     * * Space: O(n)
     * @param s
     * @param t
     * @return
     */
    public int numDistinctOptimized1(String s, String t) {

        int[] dp = new int[t.length()+1];
        dp[0] = 1;

        for(int i = 1 ; i <= s.length() ; i++){
            for(int j = t.length(); j >= 1; j--){

                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[j] += dp[j-1];
            }
        }

        return dp[t.length()];
    }

    public static void main(String[] args) {
        DistinctSubsequences obj = new DistinctSubsequences();

        String s1 = "rabbbit", t1 = "rabbit";
        String s2 = "babgbag", t2 = "bag";

        Utils.printHeadLine("Recursion");
        System.out.println(obj.numDistinct(s1, t1));
        System.out.println(obj.numDistinct(s2, t2));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.numDistinctMemorization(s1, t1));
        System.out.println(obj.numDistinctMemorization(s2, t2));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.numDistinctDP(s1, t1));
        System.out.println(obj.numDistinctDP(s2, t2));


    }

}
