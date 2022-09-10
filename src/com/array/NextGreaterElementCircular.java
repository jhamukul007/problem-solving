package com.array;

import com.utils.Utils;

import java.util.Stack;

public class NextGreaterElementCircular {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            nums[0] = -1;
            return nums;
        }

        int[] result = new int[len];
        Stack<Integer> indexSt = new Stack<>();
        indexSt.push(0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            while (!indexSt.isEmpty() && num > nums[indexSt.peek()]) {
                result[indexSt.pop()] = num;
            }
            indexSt.push(i);
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            while (!indexSt.isEmpty() && num > nums[indexSt.peek()]) {
                result[indexSt.pop()] = num;
            }
        }

        while (!indexSt.isEmpty()) {
            result[indexSt.pop()] = -1;
        }

        return result;
    }

    public static void main(String[] args) {
        NextGreaterElementCircular obj = new NextGreaterElementCircular();
        int[] arr = {1, 5, 3, 6, 8};
        Utils.print(obj.nextGreaterElements(arr));
    }
}
