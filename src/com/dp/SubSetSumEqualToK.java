package com.dp;

import com.utils.MatrixUtil;
import com.utils.Utils;

/**
 * *
 */
public class SubSetSumEqualToK {

    /**
     * * Time Complexity: O(2^n)
     * * Space: O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean subSequenceSumEqualToK(int[] arr, int k) {
        return subSequenceSumEqualToK(arr, arr.length - 1, k);
    }

    public boolean subSequenceSumEqualToK(int[] arr, int index, int target) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        boolean isFoundNotPick = subSequenceSumEqualToK(arr, index - 1, target);

        boolean isFoundPick = false;
        if (target >= arr[index])
            isFoundPick = subSequenceSumEqualToK(arr, index - 1, target - arr[index]);

        return isFoundNotPick || isFoundPick;
    }

    /**
     * * Memorization
     * * Time complexity: O(n*k)
     * * Space: O(n*k) + O(n) -> Stack Space
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean subSequenceSumEqualToKMemorization(int[] arr, int k) {
        // 1 for true, 2 false, 0 not visited
        int[][] isFound = new int[arr.length + 1][k + 1];
        return subSequenceSumEqualToKMemorization(arr, arr.length - 1, k, isFound);
    }

    public boolean subSequenceSumEqualToKMemorization(int[] arr, int index, int target, int[][] isFound) {
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;
        if (isFound[index][target] != 0)
            return isFound[index][target] == 1 ? true : false;

        boolean isFoundNotPick = subSequenceSumEqualToKMemorization(arr, index - 1, target, isFound);

        boolean isFoundPick = false;
        if (target >= arr[index])
            isFoundPick = subSequenceSumEqualToKMemorization(arr, index - 1, target - arr[index], isFound);
        boolean result = isFoundNotPick || isFoundPick;
        isFound[index][target] = result ? 1 : 2;
        return result;
    }

    /**
     * * Time: O(n*k)
     * * Space: O(n*k)
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean subSequenceSumEqualToKDP(int[] arr, int k) {
        int n = arr.length;
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (arr[0] <= k)
            dp[0][arr[0]] = true;
        //MatrixUtil.print(dp);
        for (int index = 1; index < n; index++) {
            for (int target = 1; target < k + 1; target++) {
                // Not take
                boolean notTake = dp[index - 1][target];

                // Take
                boolean take = false;
                if (arr[index] <= target)
                    take = dp[index - 1][target - arr[index]];

                dp[index][target] = notTake || take;
            }
        }
        return dp[n - 1][k];

    }

    /**
     * * Time: O(n*k)
     * * Space: O(n* k)
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean subSequenceSumEqualToKDPOptimized(int[] arr, int k) {
        int n = arr.length;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        if (arr[0] <= k)
            dp[arr[0]] = true;
        //Utils.print(dp);
        boolean[] currentDP = null;
        for (int index = 1; index < n; index++) {
            currentDP = new boolean[k + 1];
            currentDP[0] = true;
            int tempIndex = 1;
            for (int target = 1; target < k + 1; target++) {
                // Not take
                boolean notTake = dp[target];

                // Take
                boolean take = false;
                if (arr[index] <= target)
                    take = dp[target - arr[index]];

                currentDP[tempIndex++] = notTake || take;
            }
            dp = currentDP;
        }
        return dp[dp.length - 1];

    }

    /**
     * * Time: O(n*k)
     * * Space: O(k)
     *
     * @param arr
     * @param k
     * @return
     */
    public boolean subSequenceSumEqualToKDPOptimized2(int[] arr, int k) {
        int n = arr.length;
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        for (int index = 0; index < n; index++) {
            for (int target = k ; target >= arr[index]; target--) {
                dp[target] = dp[target] | dp[target - arr[index]];
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        SubSetSumEqualToK obj = new SubSetSumEqualToK();
        int[] arr = {1, 3, 5, 6};
        int k = 2;
        int k0 = 12;

        int[] arr1 = {1, 2, 3, 4};
        int k1 = 4;

        int[] arr3 = {2, 5, 1, 6, 7};
        int k2 = 4;

        int[] arr4 = {8, 59, 58, 79, 44, 7, 65, 69, 60, 51};
        int k3 = 172;

        int[] arr5 = {6, 1, 2, 1};
        int k4 = 4;


        System.out.println(obj.subSequenceSumEqualToK(arr, k));
        System.out.println(obj.subSequenceSumEqualToK(arr, k0));
        System.out.println(obj.subSequenceSumEqualToK(arr1, k1));
        System.out.println(obj.subSequenceSumEqualToK(arr3, k2));
        System.out.println(obj.subSequenceSumEqualToK(arr4, k3));
        System.out.println(obj.subSequenceSumEqualToK(arr5, k4));


        Utils.printHeadLine("Memorization");
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr, k));
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr, k0));
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr1, k1));
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr3, k2));
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr4, k3));
        System.out.println(obj.subSequenceSumEqualToKMemorization(arr5, k4));


        Utils.printHeadLine("Dynamic Programming");
        System.out.println(obj.subSequenceSumEqualToKDP(arr, k));
        System.out.println(obj.subSequenceSumEqualToKDP(arr, k0));
        System.out.println(obj.subSequenceSumEqualToKDP(arr1, k1));
        System.out.println(obj.subSequenceSumEqualToKDP(arr3, k2));
        System.out.println(obj.subSequenceSumEqualToKDP(arr4, k3));
        System.out.println(obj.subSequenceSumEqualToKDP(arr5, k4));


        Utils.printHeadLine("Dynamic Programming Optimized");
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr, k));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr, k0));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr1, k1));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr3, k2));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr4, k3));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized(arr5, k4));

        Utils.printHeadLine("Dynamic Programming Optimized 2");
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr, k));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr, k0));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr1, k1));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr3, k2));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr4, k3));
        System.out.println(obj.subSequenceSumEqualToKDPOptimized2(arr5, k4));



    }

}
