package com.dp;

import com.utils.Utils;

import java.util.Arrays;

/**
 * * 44. Wildcard Matching
 * *https://leetcode.com/problems/wildcard-matching/
 */
public class WildCard {

    /**
     * * Recursion
     * * Time: O(2^n)
     * * Space: O(n)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        return isMatch(s, s.length() - 1, p, p.length() - 1);
    }

    public boolean isMatch(String s, int i, String p, int j) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (j < 0) return false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return isMatch(s, i - 1, p, j - 1);
        if (p.charAt(j) == '*')
            // taking * as zero and more size
            return isMatch(s, i, p, j - 1) || isMatch(s, i - 1, p, j);
        return false;
    }

    /**
     * * Memorization
     * * Time: O(m * n)
     * * Space: O(n) + O(m * n)
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchMemorization(String s, String p) {
        // -1 default, 0 false and 1 = true
        int[][] dp = new int[s.length()][p.length()];
        for (int[] col : dp)
            Arrays.fill(col, -1);

        return isMatchMemorization(s, s.length() - 1, p, p.length() - 1, dp);
    }

    public boolean isMatchMemorization(String s, int i, String p, int j, int[][] dp) {
        if (i < 0 && j < 0)
            return true;
        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if (j < 0) return false;
        if (dp[i][j] != -1)
            return convert(dp[i][j]);

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            boolean result = isMatchMemorization(s, i - 1, p, j - 1, dp);
            dp[i][j] = convert(result);
            return result;
        }

        if (p.charAt(j) == '*') {
            // taking * as zero and more size
            boolean result = isMatchMemorization(s, i, p, j - 1, dp) || isMatchMemorization(s, i - 1, p, j, dp);
            dp[i][j] = convert(result);
            return result;
        }
        return false;
    }

    boolean convert(int data) {
        return data == 0 ? false : true;
    }

    int convert(boolean data) {
        return data ? 1 : 0;
    }

    /**
     * * DP Optimized
     * * Time Complexity: O(m*n)
     * * Space: O(n)
     * @param s
     * @param p
     * @return
     */

    public boolean isMatchDP(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i < dp[0].length; i++) {
            if (p.charAt(i - 1) == '*')
                dp[0][i] = true;
            else
                break;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public boolean isMatchDPOptimized(String s, String p) {
        boolean[] prev = new boolean[p.length()+1];
        prev[0] = true;

        for (int i = 1; i < prev.length; i++) {
            if (p.charAt(i - 1) == '*')
                prev[i] = true;
            else
                break;
        }
        boolean[] current = new boolean[p.length()+1];

        for (int i = 1; i < s.length() + 1; i++) {
            current[0] = false;
            for (int j = 1; j < current.length; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                   current[j] = prev[j - 1];
                else if (p.charAt(j - 1) == '*')
                    current[j] = current[j - 1] || prev[j];
                else
                    current[j] = false;
            }
            boolean[] temp = prev;
            prev = current;
            current = temp;
        }

        return prev[prev.length-1];
    }


    public static void main(String[] args) {
        WildCard obj = new WildCard();

        String s = "abcgvgf";
        String p = "a*gf";


        String s1 = "abcgvgf";
        String p1 = "a*g?";

        String s2 = "cb";
        String p2 = "?a";

        String s3 = "acdcb";
        String p3 = "a*c?b";

        String s4 ="abcdefde";
        String p4 = "abc*def";

        Utils.printHeadLine("Recursion");
        System.out.println(obj.isMatch(s, p));
        System.out.println(obj.isMatch(s1, p1));
        System.out.println(obj.isMatch(s2, p2));
        System.out.println(obj.isMatch(s3, p3));
        System.out.println(obj.isMatch(s4, p4));

        Utils.printHeadLine("Memorization");
        System.out.println(obj.isMatchMemorization(s, p));
        System.out.println(obj.isMatchMemorization(s1, p1));
        System.out.println(obj.isMatchMemorization(s2, p2));
        System.out.println(obj.isMatchMemorization(s3, p3));
        System.out.println(obj.isMatchMemorization(s4, p4));

        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.isMatchDP(s, p));
        System.out.println(obj.isMatchDP(s1, p1));
        System.out.println(obj.isMatchDP(s2, p2));
        System.out.println(obj.isMatchDP(s3, p3));
        System.out.println(obj.isMatchDP(s4, p4));

        Utils.printHeadLine("Dynamic Programming Space optimized");
        System.out.println(obj.isMatchDPOptimized(s, p));
        System.out.println(obj.isMatchDPOptimized(s1, p1));
        System.out.println(obj.isMatchDPOptimized(s2, p2));
        System.out.println(obj.isMatchDPOptimized(s3, p3));
        System.out.println(obj.isMatchDPOptimized(s4, p4));
    }
}
