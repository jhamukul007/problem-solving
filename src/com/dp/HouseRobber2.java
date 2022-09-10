package com.dp;

public class HouseRobber2 {

    public int getMaximumRobbedMoney(int[] arr) {
        if (arr.length == 1)
            return arr[0];
        int firstHousePicked = maximumSumOfNonAdjacentElementOptimized(arr, 0, arr.length - 2);
        int lastHousePicked = maximumSumOfNonAdjacentElementOptimized(arr, 1, arr.length - 1);
        return Math.max(firstHousePicked, lastHousePicked);
    }

    public int maximumSumOfNonAdjacentElementOptimized(int[] arr, int start, int end) {
        if (arr.length == 1)
            return arr[start];
        int lastMaxSum = arr[start];
        int secLastMaxSum = Math.max(arr[start], arr[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int curr = Math.max(lastMaxSum + arr[i], secLastMaxSum);
            lastMaxSum = secLastMaxSum;
            secLastMaxSum = curr;
        }
        return secLastMaxSum;
    }

    public static void main(String[] args) {
        HouseRobber2 obj = new HouseRobber2();
        int[] arr = {6,2,3,4,5,6};
        System.out.println("Maximum Robbed Money: "+ obj.getMaximumRobbedMoney(arr));
    }
}
