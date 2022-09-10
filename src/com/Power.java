package com;

public class Power {

    /**
     * Time complexity bit high O(n/2) that is O(n)
     *
     * @param x
     * @param n
     * @return
     */

    public static double myPow(double x, int n) {
        boolean isNegative = n < 0;
        n = isNegative ? -(n) : n;
        boolean isEven = (n % 2 == 0);
        double pow = 1;
        for (int i = 1; i <= n / 2; i++) {
            pow *= x;
        }
        return isEven ? pow * pow : pow * pow * x;
    }

    public static double myPow1(double x, int n) {
        return 0d;
    }

    public static void main(String[] args) {
        /*double x = 2.10000;
        int n = 3;
        System.out.println(myPow(x, n));*/

        for (int i = 1; i <= 3; i++) {
            if (i == 2)
                continue;
            System.out.println(i);
        }

        String s = "leetcodec";
        System.out.println(s.indexOf('c'));
    }
}
