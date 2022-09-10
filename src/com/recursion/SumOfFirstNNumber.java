package com.recursion;

public class SumOfFirstNNumber {

    public static int sumOfNumber(int n, int current, int sum) {
        if (current > n)
            return sum;
        sum += current;
        return sumOfNumber(n, current + 1, sum);
    }

    public static int sumOfNumber(int n, int sum) {
        if (n < 1)
            return sum;
        sum += n;
        return sumOfNumber(n - 1, sum);
    }

    public static int sumOfNumber(int n) {
        if (n < 1)
            return 0;
        return n + sumOfNumber(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumOfNumber(4, 1, 0));
        System.out.println(sumOfNumber(4, 0));
        System.out.println(sumOfNumber(4));
    }
}
