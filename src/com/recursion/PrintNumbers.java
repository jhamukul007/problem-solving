package com.recursion;

public class PrintNumbers {
    /**
     * print asc order
     * @param max
     */
    public static void printNumbers(int max){
        if(max < 1)
            return;
        printNumbers(max-1);
        System.out.print(max + ", ");
    }

    /**
     * print asc order
     * @param max
     * @param current
     */
    public static void printNumbers(int max, int current){
        if(current > max)
            return;
        System.out.print(current + ", ");
        printNumbers(max, current+1);

    }

    /**
     * print desc order
     * @param max
     */
    public static void printNumbersDesc(int max){
        if(max < 1)
            return;
        System.out.print(max + ", ");
        printNumbersDesc(max-1);
    }

    public static void printNumbersDesc(int start, int max){
        if(start > max)
            return;
        printNumbersDesc(start+1, max);
        System.out.print(start + ", ");
    }

    public static void main(String[] args) {
        printNumbers(10);
        System.out.println("\n");
        printNumbers(10, 1);
        System.out.println("\n");
        printNumbersDesc(1, 4);
        System.out.println("\n");
        printNumbersDesc(4);
    }
}
