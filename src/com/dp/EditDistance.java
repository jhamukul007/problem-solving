package com.dp;

import com.utils.Utils;

import java.util.Arrays;

/**
 * * https://leetcode.com/problems/edit-distance/
 * * 72. Edit Distance
 */
public class EditDistance {
    /**
     * * Recursion
     * * Time O(3^m)
     * * Space : O(m)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceRecursion(String word1, String word2) {
        return minDistanceRecursion(word1, word1.length()-1, word2, word2.length()-1);
    }

    public int minDistanceRecursion(String word1, int i,  String word2, int j) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(word1.charAt(i) == word2.charAt(j))
            return minDistanceRecursion(word1, i-1, word2, j-1);
        else{
            int insert = 1 + minDistanceRecursion(word1, i, word2, j-1);
            int delete = 1 + minDistanceRecursion(word1, i-1, word2, j);
            int replace = 1 + minDistanceRecursion(word1, i-1, word2, j-1);
            return Math.min(insert, Math.min(delete, replace));
        }
    }


    /**
     * * Recursion
     * * Time O(m*n)
     * * Space : O(m) + O(m*n)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceMemorization(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] col: dp)
            Arrays.fill(col, -1);
        return minDistanceMemorization(word1, word1.length()-1, word2, word2.length()-1, dp);
    }

    public int minDistanceMemorization(String word1, int i,  String word2, int j, int[][] dp) {
        if(i < 0) return j+1;
        if(j < 0) return i+1;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j))
            return minDistanceMemorization(word1, i-1, word2, j-1, dp);
        else{
            int insert = 1 + minDistanceMemorization(word1, i, word2, j-1, dp);
            int delete = 1 + minDistanceMemorization(word1, i-1, word2, j, dp);
            int replace = 1 + minDistanceMemorization(word1, i-1, word2, j-1, dp);
            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }
    }

    /**
     * * Dynamic Programming
     * * Time : O(m*n)
     * * Space: O(m*n)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for(int i = 1 ; i < dp.length; i++)
            dp[i][0] = i;
        for(int i = 1 ; i < dp[0].length; i++)
            dp[0][i] = i;

        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    /**
     * * Dynamic Programming Optimized
     * * Time : O(m*n)
     * * Space : O(n)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistanceOptimized(String word1, String word2) {
        int[] prev = new int[word2.length()+1];
        int[] cur = new int[word2.length()+1];

        for(int i = 1 ; i < prev.length; i++) {
            prev[i] = i;
            cur[i] = i;
        }

        for(int i = 1; i <= word1.length(); i++){
            cur[0] = i;
            for(int j = 1; j < prev.length; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    cur[j] = prev[j-1];
                else{
                    int insert = 1 + cur[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    cur[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[prev.length-1];
    }


    public static void main(String[] args) {
        EditDistance obj = new EditDistance();

        String word1 = "horse", word2 = "ros";
        String word3 = "intention", word4 = "execution";

        Utils.printHeadLine("Recursion");
        System.out.println(obj.minDistanceRecursion(word1, word2));
        System.out.println(obj.minDistanceRecursion(word3, word4));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.minDistanceMemorization(word1, word2));
        System.out.println(obj.minDistanceMemorization(word3, word4));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.minDistance(word1, word2));
        System.out.println(obj.minDistance(word3, word4));

        Utils.printHeadLine("Dynamic Programming Optimized");
        System.out.println(obj.minDistanceOptimized(word1, word2));
        System.out.println(obj.minDistanceOptimized(word3, word4));
    }

}
