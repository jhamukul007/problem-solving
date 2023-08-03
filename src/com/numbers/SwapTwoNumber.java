package com.numbers;

public class SwapTwoNumber {
    
    public static void swap(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " , b = " + b);
    }

    public static void bitwiseSwap(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a = " + a + " , b = " + b);
    }

    public static void main(String[] args) {
       int a = 2, b = 10;
       bitwiseSwap(a, b);
    }
    /*
        a = 2 = 0 0 1 0
        b = 10 = 1 0 1 0
        a = a ^ b = 1000
        b = 1 0 0 0 ^ 1 0 1 0 = 0 0 1 0 = 2
        a = 1 0 0 0 ^ 0 0 1 0 = 1 0 1 0 = 10
     */

    /*
        a = 10, b = 12
        a = 10 + 12 = 22
        b = a - b = 22 - 12 = 10
        a = a - b = 22 - 10 = 12
     */

}

