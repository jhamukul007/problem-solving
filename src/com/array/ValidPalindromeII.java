package com.array;

/**
 * 680. Valid Palindrome II
 * https://leetcode.com/problems/valid-palindrome-ii/
 * https://jamboard.google.com/d/13nSUu-iaLAMoC_Onpz2xP96IEPgKKUehDblJVJZXyh0/viewer?f=2
 */
public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int len = s.length();
        if (len <= 2)
            return true;
        int start = 0, end = len - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                boolean isValid = isValidPalindrome(s, start + 1, end);
                if (isValid)
                    return true;
                isValid = isValidPalindrome(s, start, end - 1);
                if (isValid)
                    return true;
                return false;
            }
            start++;
            end--;
        }
       return true;
    }

    boolean isValidPalindrome(String s, int left, int right){
        if(left >= right)
            return true;
        if(s.charAt(left) != s.charAt(right))
            return false;
        return isValidPalindrome(s, left+1, right-1);
    }

    public static void main(String[] args) {
        ValidPalindromeII obj = new ValidPalindromeII();
        String s = "abaac";

        System.out.println(obj.validPalindrome(s));
    }

}

// abbac

// acbba

