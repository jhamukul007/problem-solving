package com.dp;

/**
 * * https://leetcode.com/problems/shortest-common-supersequence/
 * * 1092. Shortest Common Supersequence
 */
public class ShortestCommonSupersequence {
    /**
     * * Space: O(m*n) + O(len(superSeq))
     * * Time : O(m*n) + O(m*n) == O(m*n)
     * @param str1
     * @param str2
     * @return
     */
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = lcs(str1, str2);
        StringBuilder sb = new StringBuilder();
        int i = dp.length-1, j = dp[0].length-1;

        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i = i-1;
                j = j-1;
            }
            else{
                if(dp[i][j-1] == dp[i][j]){
                    sb.append(str2.charAt(j-1));
                    j = j-1;

                }
                else{
                    sb.append(str1.charAt(i-1));
                    i = i-1;
                }
            }
        }
        while(i > 0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j > 0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }

    int[][] lcs(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for(int i = 1; i < dp.length;i++){
            for(int j = 1; j < dp[0].length; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp;
    }
}
