package com.array;

import com.utils.Utils;

import java.util.Stack;

public class NextSameParityElementInCircularArray {

    public static int[] nextSameParity(int[] arr) {

        int len = arr.length;

        if (len == 1) {
            arr[0] = -1;
            return arr;
        }
        Stack<Integer> evenRemaining = new Stack<>();
        Stack<Integer> oddRemaining = new Stack<>();
        if (isEven(arr[0]))
            evenRemaining.push(0);
        else
            oddRemaining.push(0);

        int[] result = new int[len];

        for (int i = 0; i < result.length; i++) {
            result[i] = -1;
        }

        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            boolean isEven = isEven(num);
            while (!evenRemaining.isEmpty() && isEven) {
                if (evenRemaining.peek() != i) {
                    result[evenRemaining.pop()] = num;
                }
            }

            while (!oddRemaining.isEmpty() && !isEven) {
                if (oddRemaining.peek() != i) {
                    result[oddRemaining.pop()] = num;
                }
            }
            if (isEven)
                evenRemaining.push(i);
            else
                oddRemaining.push(i);
        }

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            boolean isEven = isEven(num);
            while (!evenRemaining.isEmpty() && isEven) {
                if (evenRemaining.peek() != i) {
                    result[evenRemaining.pop()] = num;
                } else
                    evenRemaining.pop();
            }

            while (!oddRemaining.isEmpty() && !isEven) {
                if (oddRemaining.peek() != i) {
                    result[oddRemaining.pop()] = num;
                } else
                    oddRemaining.pop();
            }

        }

//        while(!evenRemaining.isEmpty() || !oddRemaining.isEmpty()){
//            if(!evenRemaining.isEmpty())
//                result[evenRemaining.pop()] = -1;
//            if(!oddRemaining.isEmpty())
//                result[oddRemaining.pop()] = -1;
//        }

        return result;
    }


    static boolean isEven(int data) {
        return (data & 1) != 1;
    }

    public static void main(String[] args) {
        //int[] arr = {2, 4, 3, 6, 5};
        int[] arr = {6, 4, 5, 2};
        Utils.print(nextSameParity(arr));
    }


}




