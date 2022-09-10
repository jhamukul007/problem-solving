package com.dp;

import com.utils.Utils;

public class HouseRobberSec {

    public int rob(int[] nums) {

        int len = nums.length;
        if (len == 1)
            return nums[0];

        int[] temp = new int[len];
        temp[0] = nums[0];
        temp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {

            if (i == len - 1 && len % 2 != 0) {
                if (i - 2 != 0)
                    temp[i] = Math.max(Math.max(temp[i - 1], temp[i - 2]), temp[i - 2] + nums[i] - nums[0]);
                else
                    temp[i] = Math.max(temp[i - 1], Math.max(nums[i - 2], nums[i]));
            } else
                temp[i] = Math.max(temp[i - 1], temp[i - 2] + nums[i]);
        }
        Utils.print(temp);
        return temp[len - 1];
    }

    public static void main(String[] args) {
        HouseRobberSec obj = new HouseRobberSec();
        System.out.println(obj.rob(new int[]{2, 1, 1, 2}));
    }
}
