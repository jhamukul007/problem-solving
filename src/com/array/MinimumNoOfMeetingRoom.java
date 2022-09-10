package com.array;

import java.util.Arrays;

public class MinimumNoOfMeetingRoom {
    /**
     * Space: O(n)
     * Time : nlogn
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        int len = intervals.length;
        int[] startTime = new int[len];
        int[] endTime = new int[len];
        for (int i = 0; i < len; i++) {
            startTime[i] = intervals[i][0];
            endTime[i] = intervals[i][1];
        }
        Arrays.sort(startTime);
        Arrays.sort(endTime);
        int meetingRooms = 0, start = 0, end = 0;
        while (start < len) {
            if (startTime[start] >= endTime[end]) {
                meetingRooms--;
                end++;
            }
            meetingRooms++;
            start++;
        }
        return meetingRooms;
    }

    public static void main(String[] args) {
        MinimumNoOfMeetingRoom obj = new MinimumNoOfMeetingRoom();
        int[][] intervals = {{6, 11}, {7, 2}, {2, 5}};
        System.out.println(obj.minMeetingRooms(intervals));


    }
}
/*
[[9,16],[6,16],[1,9],[3,15]]
 start : 9 6 1 3 = 1 3 6 9
 end : 16 16 9 15 = 9 15 16 16

 */