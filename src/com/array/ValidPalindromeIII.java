package com.array;

/**
 * 1216. Valid Palindrome III
 * https://leetcode.com/problems/valid-palindrome-iii/
 * https://jamboard.google.com/d/1oca5ciXs6jTHyoj1yKTDnUpl5r0aRnah5Q2BnY6SPDw/viewer?f=0
 */
public class ValidPalindromeIII {

    public boolean isValidPalindrome(String s, int k) {
        int len = s.length();
        if(len == 1 || (len == 2 && k == 1))
            return true;
        int minDeletion = noOfDeletion(s, 0, len-1, 0, k);
        return minDeletion <= k;
    }

    public int noOfDeletion(String s, int start, int end, int deleted, int k){
        if(start >=  end){
           return deleted;
        }

        if(s.charAt(start) == s.charAt(end))
            return noOfDeletion(s, start+1, end-1, deleted, k);
        else{
           int leftDeletion =  noOfDeletion(s, start+1, end, deleted+1, k);
           int rightDeletion = noOfDeletion(s, start, end-1, deleted+1, k);
           return Math.min(leftDeletion, rightDeletion);
        }

    }

    public static void main(String[] args) {
        ValidPalindromeIII obj = new ValidPalindromeIII();
        String s = "abccab"; int k = 1;
        System.out.println(obj.isValidPalindrome(s, k));
    }

}
/*
 "bacabaaa"
  2

  aaaaa
 */
