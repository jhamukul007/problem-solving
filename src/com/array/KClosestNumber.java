package com.array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestNumber {

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int len = arr.length;

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (x > arr[len - 1]) {
            for (int i = len - 1; i >= len - k; i--) {
                result.add(arr[i]);
            }
        }

        int start = 0;
        int end = len - 1;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == x) {
                insertIntoHeap(maxHeap, 0, mid - 1, arr);
                insertIntoHeap(minHeap, mid + 1, len - 1, arr);
            } else if (x < arr[mid]) {
                if (mid - 1 >= 0 && x > arr[mid - 1]) {
                    insertIntoHeap(maxHeap, 0, mid - 1, arr);
                    insertIntoHeap(minHeap, mid, len - 1, arr);
                } else
                    end = mid;
            } else if (x > arr[mid]) {
                if (mid + 1 < len && arr[mid + 1] > x) {
                    insertIntoHeap(maxHeap, 0, mid, arr);
                    insertIntoHeap(maxHeap, mid + 1, len - 1, arr);
                } else
                    start = mid + 1;
            }
        }

        while (!maxHeap.isEmpty() || !minHeap.isEmpty()) {
            if (k == 0)
                break;
            int left = 0, right = 0;
            if (maxHeap.size() > 0)
                left = maxHeap.peek();
            if (minHeap.size() > 0)
                right = minHeap.peek();
            if (Math.abs(x - right) == Math.abs(x - left)) {
                result.add(maxHeap.poll());
                result.add(minHeap.poll());
            }
            if (Math.abs(x - right) < Math.abs(x - left))
                result.add(minHeap.poll());

            else
                result.add(maxHeap.poll());

            k--;
        }
        Collections.sort(result);
        return result;
    }

    void insertIntoHeap(PriorityQueue<Integer> heap, int from, int to, int[] arr) {
        for (int i = from; i <= to; i++) {
            heap.add(arr[i]);
        }
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        List<Integer> result = new ArrayList<>();

        int len = arr.length;

        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        if (x > arr[len - 1]) {
            for (int i = len - k; i < len; i++) {
                result.add(arr[i]);
            }
            return result;
        }

        int mid;
        int start = 0;
        int end = len - 1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == x) {
                start = mid - 1;
                end = mid;
                break;
            } else if (x > arr[mid]) {
                if (mid + 1 < len && x < arr[mid + 1]) {
                    start = mid;
                    end = mid + 1;
                    break;
                } else
                    start = mid + 1;
            } else {
                if (mid - 1 >= 0 && x > arr[mid - 1]) {
                    start = mid - 1;
                    end = mid;
                    break;
                } else
                    end = mid;
            }
        }
        while ((start >= 0 || end < len) && k > 0) {
            int leftDiff = start >= 0 ? Math.abs(arr[start] - x) : Integer.MAX_VALUE;
            int rightDiff = end < len ? Math.abs(arr[end] - x) : Integer.MAX_VALUE;
            if (leftDiff == rightDiff) {
                result.add(arr[start--]);
            } else if (leftDiff > rightDiff) {
                if (end < len)
                    result.add(arr[end++]);
            } else if (start >= 0)
                result.add(arr[start--]);
            k--;
        }

        Collections.sort(result);
        return result;
    }


    public static void main(String[] args) {
        KClosestNumber obj = new KClosestNumber();

//        [1,2,3,4,5]
//        4
//        3
        System.out.println(obj.findClosestElements(new int[]{3, 5, 8, 10}, 2, 15));
    }
}
