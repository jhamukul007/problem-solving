package com.dp;

import com.utils.Utils;

/**
 * * https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003
 * * Ninja’s Training
 */
public class NinjasTraining {

    int maximumPoint;

    /**
     * * Recursion
     *
     * @param points
     * @return
     */
    public int maximumMeritPoint(int[][] points) {
        maximumPoint = Integer.MIN_VALUE;
        maximumMeritPoint(points, 0, -1, 0);
        return maximumPoint;
    }

    public int maximumMeritPoint(int[][] points, int day, int lastWorkout, int totalPoint) {
        if (day >= points.length) {
            maximumPoint = Math.max(maximumPoint, totalPoint);
            return totalPoint;
        }

        for (int workout = 0; workout < points[0].length; workout++) {
            if (workout == lastWorkout)
                continue;
            maximumMeritPoint(points, day + 1, workout, totalPoint + points[day][workout]);
        }
        return totalPoint;
    }

    /**
     * * Recursion
     *
     * @param points
     * @return
     */
    public int maximumMeritPointRecursionBottomUp(int[][] points) {
        return maximumMeritPointRecursionBottomUp(points, points.length - 1, 0);

    }

    public int maximumMeritPointRecursionBottomUp(int[][] points, int day, int lastWorkout) {
        if (day == 0) {
            int maximumPoint = 0;
            for (int task = 0; task < points[0].length; task++) {
                if (task == lastWorkout)
                    continue;
                maximumPoint = Math.max(maximumPoint, points[day][task]);
            }
            return maximumPoint;
        }
        int maximumPoint = 0;
        for (int task = 0; task < points[0].length; task++) {
            if (task == lastWorkout)
                continue;
            int meritPoints = points[day][task] + maximumMeritPointRecursionBottomUp(points, day - 1, task);
            maximumPoint = Math.max(maximumPoint, meritPoints);
        }
        return maximumPoint;
    }

    /**
     * * Memorization
     *
     * @param n
     * @param points
     * @return
     */
    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[points.length][4];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        Utils.print(dp);
        //return 0;
        return maximumMeritPointRecursionBottomUp(points, dp, points.length - 1, 3);
    }

    public static int maximumMeritPointRecursionBottomUp(int[][] points, int[][] dp, int day, int lastWorkout) {
        if (day == 0) {
            int maximumPoint = 0;
            for (int task = 0; task < 3; task++) {
                if (task == lastWorkout)
                    continue;
                maximumPoint = Math.max(maximumPoint, points[day][task]);
            }
            return maximumPoint;
        }
        if (dp[day][lastWorkout] != -1)
            return dp[day][lastWorkout];

        int maximumPoint = 0;
        for (int task = 0; task < 3; task++) {
            if (task == lastWorkout)
                continue;
            int meritPoints = points[day][task] + maximumMeritPointRecursionBottomUp(points, dp, day - 1, task);
            maximumPoint = Math.max(maximumPoint, meritPoints);
        }
        return dp[day][lastWorkout] = maximumPoint;
    }


    public int maximumMeritPointDP(int[][] points) {
        int[][] dp = new int[points.length][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] =  Math.max(points[0][1], Math.max(points[0][1], points[0][2]));

        for (int days = 1; days < points.length; days++) {
            for(int last = 0; last < 4; last ++){
                dp[days][last] = 0;
                for(int task = 0; task < 3; task++){
                    if(last == task)
                        continue;
                    int currentPoint = points[days][task] + dp[days-1][last];
                    dp[days][last] = Math.max(dp[days][last], currentPoint);
                }
            }
        }

        Utils.print(dp);
        return dp[points.length-1][3];
    }

    public static void main(String[] args) {
        NinjasTraining obj = new NinjasTraining();
        //int[][] points = {{1, 2, 5}, {3, 1, 1}, {3, 3, 3}};
        int[][] points = {{10, 40, 70}, {20, 50, 80,}, {30, 60, 90}};
        // int[][] points = {{18, 11, 19}, {4, 13, 7}, {1, 8, 13}};
        //int[][] points = {{10, 50, 1}, {5, 100, 11}};
        //System.out.println(obj.maximumMeritPointMemorization(points));
       // System.out.println(ninjaTraining(points.length, points));
        System.out.println(obj.maximumMeritPointDP(points));
    }
}
