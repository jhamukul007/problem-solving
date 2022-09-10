package com.ps.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/intersection-of-three-sorted-arrays/
 * 1213. Intersection of Three Sorted Arrays: Easy
 */
public class IntersectionOfThreeSortedArrays {
    /**
     * Time Complexity: O(n*log(n))
     * Space Complexity: O(result)
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (isFound(arr2, arr1[i]) && isFound(arr3, arr1[i]))
                result.add(arr1[i]);
        }
        return result;
    }

    boolean isFound(int[] arr, int num) {
        Set<Integer> intData = new HashSet<>();
        int start = 0, end = arr.length, mid, data;
        while (start < end) {
            mid = (start + end) / 2;
            data = arr[mid];
            if (data == num)
                return true;
            if (num > data)
                start = mid + 1;
            else
                end = mid;
        }
        return false;
    }

    /**
     * Using HashMap
     *
     * @param arr1
     * @param arr2
     * @param arr3
     * @return
     */
    public List<Integer> arraysIntersection1(int[] arr1, int[] arr2, int[] arr3) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < arr1.length; i++) {
            if (isFound(arr2, arr1[i]) && isFound(arr3, arr1[i]))
                result.add(arr1[i]);
        }
        return result;
    }


}
