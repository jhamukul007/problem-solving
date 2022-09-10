package com.array;

/**
 * https://leetcode.com/problems/longest-palindromic-subsequence/
 * 516. Longest Palindromic Subsequence
 */
public class LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        StringBuilder builder = new StringBuilder(s);
        String s2 = builder.reverse().toString();

        // finding longest common sub sequence
        int[][] temp = new int[s.length()+1][s2.length()+1];
        for(int i = 1; i < temp.length; i++){
            for(int j = 1; j < temp[0].length; j++){
                if(s.charAt(i-1) == s2.charAt(j-1))
                    temp[i][j] = 1 + temp[i-1][j-1];
                else
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
            }
        }
        return temp[temp.length-1][temp[0].length-1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
        System.out.println(obj.longestPalindromeSubseq("bacabaaa"));
    }
}
