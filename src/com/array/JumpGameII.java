package com.array;

/**
 * https://leetcode.com/problems/jump-game-ii/
 * 45. Jump Game II
 */
public class JumpGameII {

    /**
     * Space : O(n)
     * Time: O(n^2)
     * Approach : DP
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return 0;
        int[] temp = new int[len];
        for(int i = 0; i < len; i++){
            temp[i] = Integer.MAX_VALUE;
        }
        temp[0] = 0;
        for(int i = 0; i < len-1 ; i++){
            int till = nums[i];
            int minJump = temp[i];
            for(int j = i + 1; j <= i + till && j < len; j++){
                temp[j] = Math.min(temp[j], minJump + 1 );
            }
        }
        return temp[len-1];
    }


    /**
     * Space : O(1)
     * Time: O(n)
     * Approach : Greedy
     * @param nums
     * @return
     */
    public int jumpGreedy(int[] nums) {
        int minJump = 0;
        int currentJumpedIndex = 0;
        int maximumPosition = 0;
        for(int i = 0; i < nums.length-1 ; i++){
            int toJump = nums[i] + i;
            maximumPosition = Math.max(maximumPosition, toJump);
            if(i == currentJumpedIndex){
                currentJumpedIndex = maximumPosition;
                minJump++;
            }
        }
        return minJump;
    }

    public static void main(String[] args) {
        JumpGameII obj = new JumpGameII();
        int[] arr = {2, 3, 1, 1, 4};
        System.out.println(obj.jumpGreedy(arr));
    }

    /*
      maxJump = 4
      minJump = 0
      arr = 2 3 1 1 4;
    */
    int jump = 1;
    int currentJumpedIndex = 4;
    int maximumPosition = 4;




}
