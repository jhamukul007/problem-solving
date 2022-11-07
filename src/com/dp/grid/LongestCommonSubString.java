package com.dp.grid;

public class LongestCommonSubString {

    public int longestCommonSubStringRecursive(String s1, String s2) {
        return longestCommonSubStringRecursive(s1, s1.length()-1,s2, s2.length()-1, 0 );
    }

    public int longestCommonSubStringRecursive(String s1, int i1, String s2, int i2, int count) {
        if (i1 < 0 || i2 < 0)
            return count;
        if (s1.charAt(i1) == s2.charAt(i2))
            count = longestCommonSubStringRecursive(s1, i1 - 1, s2, i2 - 1, count + 1);
        return Math.max(Math.max(count, longestCommonSubStringRecursive(s1, i1, s2, i1-1, 0 )),
                longestCommonSubStringRecursive(s1, i1-1, s2, i1, 0 ));
    }

    /**
     * * DP
     * * Space: O(m * n )
     * * Time: O(m * n )
     * @param str1
     * @param str2
     * @return
     */
    public static int lcs(String str1, String str2) {
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        int maxLCS = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                maxLCS = Math.max(maxLCS, dp[i][j]);
            }
        }
        return maxLCS;
    }

    /**
     * * Dp Optimized
     * * Time : O(m * n )
     * * Time: O(
     * @param str1
     * @param str2
     * @return
     */
    public static int lcsOptimized(String str1, String str2) {
        String s = "";
        String s1 = "";
        int n ;
        if(str1.length() > str2.length()){
            n = str2.length() + 1;
            s = str2;
            s1 = str1;
        }
        else {
            n = str1.length() + 1;
            s = str1;
            s1 = str2;
        }

        int[] lastDP = new int[n];
        int[] currentDP;

        int maxLCS = 0;
        for(int i = 0; i < s1.length(); i++){
            currentDP = new int[n];
            for(int j = 1; j < lastDP.length; j++){
                if(s1.charAt(i) == s.charAt(j-1)){
                    currentDP[j] = 1 + lastDP[j-1];
                    maxLCS = Math.max(maxLCS, currentDP[j]);
                }
            }
            // int[] temp = lastDP;
            lastDP = currentDP;
            //currentDP = temp;
        }
        return maxLCS;
    }

}