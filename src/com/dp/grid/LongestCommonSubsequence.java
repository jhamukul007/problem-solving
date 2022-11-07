package com.dp.grid;

import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/longest-common-subsequence_624879
 */
public class LongestCommonSubsequence {
    /**
     * Recursion
     * @param s
     * @param t
     * @return
     */
    public static int lcs(String s, String t) {
        return lcs(s, s.length()-1, t, t.length()-1);
    }

    public static int lcs(String s, int i1, String t, int i2) {
        if(i1 < 0 || i2 < 0)
            return 0;
        if(s.charAt(i1) == t.charAt(i2))
            return 1 + lcs(s, i1-1, t, i2-1);
        return Math.max(lcs(s, i1, t, i2-1), lcs(s, i1-1, t, i2));
    }

    /**
     * * Memorization
     * @param s
     * @param t
     * @return
     */
    public static int lcsMemorization(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        return lcsMemorization(s, s.length()-1, t, t.length()-1, dp);
    }

    public static int lcsMemorization(String s, int i1, String t, int i2, int[][] dp) {
        if(i1 < 0 || i2 < 0)
            return 0;
        if(dp[i1][i2] != 0)
            return dp[i1][i2];
        if(s.charAt(i1) == t.charAt(i2))
            return 1 + lcsMemorization(s, i1-1, t, i2-1,dp);
        return dp[i1][i2] = Math.max(lcsMemorization(s, i1, t, i2-1, dp), lcsMemorization(s, i1-1, t, i2, dp));
    }

    /**
     * * Dynamic Programming
     * @param s
     * @param t
     * @return
     */
    public static int lcsDP(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        return dp[s.length()][t.length()];
    }


    /**
     * * Dynamic Programming space Optimized
     * * Time : O(m * n)
     * * Space: O(len(t))
     * @param s
     * @param t
     * @return
     */
    public static int lcsDPSpaceOptimized(String s, String t) {
        int[] lastDP = new int[t.length()+1];
        int[] currentDP;

        for(int i = 1; i < s.length()+1; i++){
            currentDP = new int[t.length()+1];
            for(int j = 1; j < lastDP.length; j++){
                if(s.charAt(i-1) == t.charAt(j-1))
                    currentDP[j] = 1 + lastDP[j-1];
                else
                    currentDP[j] = Math.max(lastDP[j], currentDP[j-1]);
            }
            lastDP = currentDP;
        }

        return lastDP[lastDP.length-1];
    }

    /**
     * * Dynamic Programming space Optimized
     * * Time : O(m * n)
     * * Space: O(len(t))
     * @param s
     * @param t
     * @return
     */
    public int longestCommonSubsequence(String s, String t) {
        int[] lastDP = new int[t.length() + 1];
        int[] currentDP = new int[t.length() + 1];
        ;

        for (int i = 1; i < s.length() + 1; i++) {

            for (int j = 1; j < lastDP.length; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    currentDP[j] = 1 + lastDP[j - 1];
                else
                    currentDP[j] = Math.max(lastDP[j], currentDP[j - 1]);
            }
            int[] temp = lastDP;
            lastDP = currentDP;
            currentDP = temp;
        }

        return lastDP[lastDP.length - 1];
    }

    public static void main(String[] args) {
        String s1 = "adebc";
        String t1 = "dcadb";

        String s2 = "ab";
        String t2 = "defg";

        String s3 = "def";
        String t3 = "fed";

        String s4 = "abcdb";
        String t4 = "bcacdhb";


        Utils.printHeadLine("Recursion");
        System.out.println(lcs(s1,t1));
        System.out.println(lcs(s2,t2));
        System.out.println(lcs(s3,t3));
        System.out.println(lcs(s4,t4));

        Utils.printHeadLine("Memorization");
        System.out.println(lcsMemorization(s1,t1));
        System.out.println(lcsMemorization(s2,t2));
        System.out.println(lcsMemorization(s3,t3));
        System.out.println(lcsMemorization(s4,t4));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(lcsDP(s1,t1));
        System.out.println(lcsDP(s2,t2));
        System.out.println(lcsDP(s3,t3));
        System.out.println(lcsDP(s4,t4));


        Utils.printHeadLine("Dynamic Programming Optimized");
        System.out.println(lcsDPSpaceOptimized(s1,t1));
        System.out.println(lcsDPSpaceOptimized(s2,t2));
        System.out.println(lcsDPSpaceOptimized(s3,t3));
        System.out.println(lcsDPSpaceOptimized(s4,t4));
    }
}
