package com.dp;

/**
 * * 1312. Minimum Insertion Steps to Make a String Palindrome
 * * https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/
 */
public class MakePalindrome {

    /**
     * * Time : O(n^2)
     * * Space: O(n)
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        int maximumPalindromeSubSeqLen = maximumPalindromeSubSeqLen(s, sb.reverse().toString());
        return len - maximumPalindromeSubSeqLen;
    }

    public int maximumPalindromeSubSeqLen(String s, String s1){
        int len = s.length();
        int[] prev = new int[len+1];
        int[] cur =  new int[len+1];

        for(int i = 1; i <= len ; i++){
            for(int j = 1; j <= len; j++){
                if(s.charAt(i-1) == s1.charAt(j-1))
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
