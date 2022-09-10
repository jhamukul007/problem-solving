package com.segment.tree;

import com.utils.Utils;

public class CreateMinSegmentTree {

    /**
     * Minimum Segment Tree
     *
     * @param arr
     * @param seg
     * @param start
     * @param end
     * @param pos
     */
    int[] seg;
    int len;
    int[] arr;

    public CreateMinSegmentTree(int[] arr) {
        len = arr.length;
        this.arr = arr;
        seg = new int[2 * getNextPowerOfTwo(arr.length) - 1];
        for (int i = 0; i < seg.length; i++)
            seg[i] = Integer.MAX_VALUE;
        createMinSegmentTree(arr, seg, 0, arr.length - 1, 0);
    }

    /*
        Converting segment from array
        Algo: First divide into two parts,
        Create segment tree from left and right.

     */
    public void createMinSegmentTree(int[] arr, int[] seg, int start, int end, int pos) {
        if (start == end) {
            seg[pos] = arr[start];
            return;
        }
        int mid = (start + end) / 2;
        createMinSegmentTree(arr, seg, start, mid, 2 * pos + 1);
        createMinSegmentTree(arr, seg, mid + 1, end, 2 * pos + 2);
        seg[pos] = Math.min(seg[2 * pos + 1], seg[2 * pos + 2]);
    }

    public int findMin(int[] seg, int start, int end, int qStart, int qEnd, int pos) {
        if (end < qStart || start > qEnd)
            return Integer.MAX_VALUE;
        if (start >= qStart && end <= qEnd)
            return seg[pos];
        int mid = (start + end) / 2;
        return Math.min(findMin(seg, start, mid, qStart, qEnd, 2 * pos + 1),
                findMin(seg, mid + 1, end, qStart, qEnd, 2 * pos + 2));
    }

    public int minBetweenRange(int qStart, int qEnd) {
        return findMin(seg, 0, len - 1, qStart, qEnd, 0);
    }

    public int getNextPowerOfTwo(int input) {
        if (input == 0)
            return 1;
        if ((input & (input - 1)) == 0)
            return input;
        while ((input & (input - 1)) > 0) {
            input = input & (input - 1);
        }
        return input << 1;
    }

    public void update(int index, int newValue){
        int diff = newValue - arr[index]; //19
        arr[index] = newValue;
        update(seg, 0, arr.length-1, index, 0, diff);
    }

    public void update(int[] seg, int start, int end, int index, int pos, int diff){
        if(index < start || index > end)
            return;
        if(start == end){
            seg[index] += diff;
            return;
        }

        int mid = (start+end)/2;
        update(seg, start, mid, index, 2*pos+1, diff);
        update(seg, mid+1, end, index, 2*pos+2, diff);
        seg[pos] = Math.min(seg[2*pos+1], seg[2*pos+2]);
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 9, 10, 5, 6, 7, 8};
        CreateMinSegmentTree obj = new CreateMinSegmentTree(arr);
        //Utils.print(obj.seg);
        //System.out.println(obj.minBetweenRange(2, 4));
        System.out.println(obj.minBetweenRange(0, 2));
        obj.update(1, 20);
        Utils.print(obj.arr);
        System.out.println(obj.minBetweenRange(1, 3));
    }

}
