package com.queue;

import com.utils.Utils;

import java.util.PriorityQueue;

public class MaximumProductOfTwoElement {
    /**
     * Time complexity
     *
     * @param nums
     * @return
     */
    public static int maxProduct(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int data : nums) {
            maxHeap.add(data);
        }
        return (maxHeap.poll() - 1) * (maxHeap.poll() - 1);
    }

    public static int maxProductUsingFindSecAndMax(int[] nums) {
        int secMax = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int data : nums) {
            if (data > max) {
                secMax = max;
                max = data;
            } else if (data <= max && data > secMax) {
                secMax = data;
            }
        }
        return (max - 1) * (secMax - 1);
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{3, 4, 5, 2};
        System.out.println(maxProduct(a1));
        System.out.println(maxProductUsingFindSecAndMax(a1));
    }
}
