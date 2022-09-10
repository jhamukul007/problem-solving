package com.array;

import com.utils.Utils;

import java.util.Stack;

public class NextGreatestElement {

    static int[] nextGreatest(int[] arr) {

        if (arr.length == 1) {
            arr[0] = -1;
            return arr;
        }
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
        for (int i = 1; i < arr.length; i++) {
            int data = arr[i];
            while (!indexStack.isEmpty() && data > arr[indexStack.peek()]) {
                int index = indexStack.pop();
                arr[index] = data;
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            arr[indexStack.pop()] = -1;
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 7};
        Utils.print(nextGreatest(arr));
    }

}



