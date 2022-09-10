package com.numbers;

/**
 * * 263. Ugly Number
 * * https://leetcode.com/problems/ugly-number/
 */
public class UglyNumber {

    public boolean isUgly(int x) {
        long n = x;
        n = Math.abs(n);

        while (n > 1) {

            boolean divided = false;

            if (n % 2 == 0) {
                n /= 2;
                divided = true;
            }

            if (n % 3 == 0) {
                n /= 3;
                divided = true;
            }

            if (n % 5 == 0) {
                n /= 5;
                divided = true;
            }

            if (!divided)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        UglyNumber obj = new UglyNumber();
        int n = -2147483648;
        System.out.println(obj.isUgly(n));
        //int n = -4;
        //System.out.println(Math.abs(n) + " , " + -n);

    }
}
