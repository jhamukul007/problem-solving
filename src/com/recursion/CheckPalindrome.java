package com.recursion;

public class CheckPalindrome {
    public static boolean isPalindrome(String s, int left, int right){
        if(right <= left)
            return true;
        if(s.charAt(left) != s.charAt(right))
            return false;
        return isPalindrome(s, left+1, right-1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("abcdba",0, "abcdba".length()-1));
        System.out.println(isPalindrome("abccba",0, "abccba".length()-1));
    }
}
