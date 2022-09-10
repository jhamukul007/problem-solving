package com.recursion;

public class FindLengthOfString {

    public static int length(String s) {
        if ("".equals(s))
            return 0;
        return 1 + length(s.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(length("Mukul Jha"));
    }
}
