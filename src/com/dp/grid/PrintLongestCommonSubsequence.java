package com.dp.grid;

import com.utils.Utils;

public class PrintLongestCommonSubsequence {

    public static String longestCommonSubsequence(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        int rows = dp.length;
        int cols = dp[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }

        Utils.print(dp);

        StringBuilder sb = new StringBuilder();
        int i = rows - 1;
        int j = cols - 1;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i = i - 1;
                j = j - 1;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1])
                    i = i - 1;
                else
                    j = j - 1;
            }
        }

        return sb.reverse().toString();
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


        Utils.printHeadLine("Dynamic Programming");
        System.out.println(longestCommonSubsequence(s1, t1));
        System.out.println(longestCommonSubsequence(s2, t2));
        System.out.println(longestCommonSubsequence(s3, t3));
        System.out.println(longestCommonSubsequence(s4, t4));

    }
}
