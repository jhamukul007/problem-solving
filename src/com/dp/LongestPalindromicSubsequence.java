package com.dp;

/**
 * * 516. Longest Palindromic Subsequence
 * * https://leetcode.com/problems/longest-palindromic-subsequence/
 */
public class LongestPalindromicSubsequence {
    /**
     * * Time: O(n^2)
     * * Space: O(n)
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        return longestCommonSubSeq(s, sb.reverse().toString());
    }

    public int longestCommonSubSeq(String s1, String s2){
        int len = s1.length();
        int[] prev = new int[len+1];
        int[] cur = new int[len+1];

        for(int i = 1 ; i < len+1 ; i++){
            for(int j = 1; j < len+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    cur[j] = 1 + prev[j-1];
                else
                    cur[j] = Math.max(cur[j-1], prev[j]);
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[len];
    }


}
