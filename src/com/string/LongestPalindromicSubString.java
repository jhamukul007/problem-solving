package com.string;

import com.utils.Utils;

public class LongestPalindromicSubString {

    public String longestPalindrome(String s) {

        int len = s.length();
        if (len == 1)
            return s;

        int[][] temp = new int[len][len];
        for (int i = 0; i < len; i++) {
            temp[i][i] = 1;
        }

        int window = 1, start = 0, end = 0, maxLen = 1;
        while (window <= len) {
            for (int i = 0; i < len - window; i++) {
                if (s.charAt(i) == s.charAt(i + window)) {
                    if (window < 2) {
                        temp[i][i + window] = 1;
                        if (window >= maxLen) {
                            start = i;
                            end = i + window;
                        }
                    } else if (window > 2 && temp[i + 1][i + window - 1] == 1) {
                        temp[i][i + window] = 1;
                        if (window > maxLen) {
                            start = i;
                            end = i + window;
                        }
                    }
                }
            }
            window++;
        }
        Utils.print(temp);
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        LongestPalindromicSubString obj = new LongestPalindromicSubString();
        System.out.println(obj.longestPalindrome("aaa"));
    }
}

