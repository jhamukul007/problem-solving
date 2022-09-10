package com.array;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 42. Trapping Rain Water
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int len = height.length;
        if(len == 1)
            return 0;

        int[] leftMax = new int[len];
        int[] rightMax = new int[len];
        int rightMaxValue = height[len-1];
        int leftMaxValue = height[0];
        int right = len-2;

        for(int i = 1; i < len; i++){
            leftMax[i] = Math.max(height[i],leftMaxValue);
            leftMaxValue = leftMax[i];
            rightMax[right] = Math.max(height[right],rightMaxValue);
            rightMaxValue = rightMax[right];
            right--;
        }

        int totalTrappedWaterStored = 0;
        for(int i = 1; i< len-1; i++){
            totalTrappedWaterStored += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return totalTrappedWaterStored;
    }

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(obj.trap(arr));
    }
}
