package com.array;

public class JumpGame1 {
    /**
     * Time = O(n^2)
     * Space = O(n)
     *
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return true;
        if (nums[0] == 0)
            return false;

        int[] temp = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int till = nums[i];
            int reached = temp[i];
            if (i > 0 && reached == 0)
                return false;
            for (int j = i + 1; j <= i + till; j++) {
                if (j == len - 1)
                    return true;
                temp[j] += 1;
            }

        }
        return temp[len - 1] > 0 ? true : false;
    }

    /**
     * Time : O(n)
     * Space : O(1)
     *
     * @param nums
     * @return
     */
    // Greedy Approach
    public boolean canJump1(int[] nums) {
        int len = nums.length, reachable = 0;

        for (int i = 0; i < len; i++) {
            if (reachable < i)
                return false;
            reachable = Math.max(reachable, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(canJump(arr));
    }
}
