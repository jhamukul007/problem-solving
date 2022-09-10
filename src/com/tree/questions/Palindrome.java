package com.tree.questions;

import java.util.Objects;

public class Palindrome {

    public static boolean isPalindrome(int x) {
        StringBuilder builder = new StringBuilder(x + "");
        String s1 = builder.reverse().toString();
        return Objects.deepEquals(s1, builder.reverse().toString());
    }

    public static void main(String[] args) {
        //System.out.println(isPalindrome(-121));
        char c = 'a';
        int index = c - 'a';
        System.out.println(index);
        System.out.println(1 >> 3);


    }
}
