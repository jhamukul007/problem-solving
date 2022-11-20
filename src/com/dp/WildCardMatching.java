package com.dp;

import com.utils.Utils;

/**
 * * https://leetcode.com/problems/wildcard-matching/
 * * 44. Wildcard Matching
 */
public class WildCardMatching {

    /**
     * Recursion
     * * Time :
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchRecursion(String s, String p) {
        return isMatchRecursion(s, s.length()-1, p, p.length()-1);
    }

    public boolean isMatchRecursion(String s, int i,  String p, int j) {
        if(i < 0 && j < 0)
            return true;

        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if(j < 0){
            return false;
        }
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            return isMatchRecursion(s, i-1, p, j-1);

        if(p.charAt(j) == '*')
            return isMatchRecursion(s, i, p, j-1) || isMatchRecursion(s, i-1, p, j);
        return false;
    }


    /**
     * Memorization
     * *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatchMemorization(String s, String p) {
        int[][] dp = new int[s.length()][p.length()];
        return isMatchMemorization(s, s.length()-1, p, p.length()-1, dp );
    }

    public boolean isMatchMemorization(String s, int i,  String p, int j, int[][] dp) {
        if(i < 0 && j < 0)
            return true;

        if(i < 0 && j >= 0){
            for(int k = 0; k <= j; k++){
                if(p.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        if(j < 0){
            return false;
        }
        if(dp[i][j] != 0)
            return dp[i][j] == 1 ? false : true;

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            boolean result = isMatchMemorization(s, i-1, p, j-1, dp);
            dp[i][j] = result ? 2 : 1;
            return result;
        }

        if(p.charAt(j) == '*'){
            boolean result = isMatchMemorization(s, i, p, j-1, dp) || isMatchMemorization(s, i-1, p, j, dp);
            dp[i][j] = result ? 2 : 1;
            return  result;
        }

        dp[i][j] = 1;
        return false;
    }

    public static void main(String[] args) {
        WildCardMatching obj = new WildCardMatching();

        String s = "ab", p = "a?b";
        String s1 = "ab", p1 = "?b";
        String s2 = "abcgvgf", p2 = "ab*gf";
        String s3 = "aa", p3 = "*";
        String s4 = "aa", p4 = "?";
        String s5 = "a", p5 = "?";
        String s6 = "adceb", p6 = "*a*b";

        Utils.printHeadLine("Recursion");
        System.out.println(obj.isMatchRecursion(s, p));
        System.out.println(obj.isMatchRecursion(s1, p1));
        System.out.println(obj.isMatchRecursion(s2, p2));
        System.out.println(obj.isMatchRecursion(s3, p3));
        System.out.println(obj.isMatchRecursion(s4, p4));
        System.out.println(obj.isMatchRecursion(s5, p5));
        System.out.println(obj.isMatchRecursion(s6, p6));


        Utils.printHeadLine("Memorization");
        System.out.println(obj.isMatchMemorization(s, p));
        System.out.println(obj.isMatchMemorization(s1, p1));
        System.out.println(obj.isMatchMemorization(s2, p2));
        System.out.println(obj.isMatchMemorization(s3, p3));
        System.out.println(obj.isMatchMemorization(s4, p4));
        System.out.println(obj.isMatchMemorization(s5, p5));
        System.out.println(obj.isMatchMemorization(s6, p6));

    }

}
