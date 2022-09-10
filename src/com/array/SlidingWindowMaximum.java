package com.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 239. Sliding Window Maximum
 * https://leetcode.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int index = 0;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.data - a.data);
        for(int i = 0; i < n ; i++){
            if(i >= k){
                Pair peek = maxHeap.peek();
                if(peek.index == i-k){
                    maxHeap.poll();
                }
            }
            maxHeap.add(new Pair(nums[i], i));
            if(i >= k - 1){
                while(maxHeap.peek().index < i - k)
                    maxHeap.poll();
                result[index++] =  maxHeap.peek().data;
            }

        }
        return result;
    }

    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k+1];
        int index = 0;
        Deque<int[][]> queue = new ArrayDeque<>();
        int[][] dataArr;

        for(int i = 0; i < n ; i++){
            int data = nums[i];
            while(!queue.isEmpty() && queue.peekFirst()[0][1] <= i-k){
                queue.pollFirst();
            }
            while(!queue.isEmpty()  && queue.peekLast()[0][0] < data){
                queue.pollLast();
            }
            dataArr = new int[1][2];
            dataArr[0][0] = data;
            dataArr[0][1] = i;
            queue.offerLast(dataArr);
            if(!queue.isEmpty() && i >= k-1){
                result[index++] = queue.peekFirst()[0][0];
            }
        }
        return result;
    }
}

class Pair{

    public int data;
    public int index;

    public Pair(int data, int index){
        this.data = data;
        this.index = index;
    }
}
