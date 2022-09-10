package com.array;

import com.utils.Utils;

import java.util.PriorityQueue;

/**
 * Given a list of intervals calendar and a number of available conference rooms. For each query, return true if the
 * meeting can be added to the calendar successfully without causing a conflict, otherwise false.
 * A conference room can only hold one meeting at a time.
 */
public class AddMeetingToCalender {
    /**
     * Time Complexity: O(Q) * nlog(n)
     * Space : O(Q) + O(n) = O(n)
     *
     * @param calendar
     * @param meetingRoom
     * @param meetingToAdd
     * @return
     */
    public boolean[] isAdded(int[][] calendar, int meetingRoom, int[][] meetingToAdd) {

        boolean[] result = new boolean[meetingToAdd.length];
        for (int i = 0; i < meetingToAdd.length; i++) {
            result[i] = isAddedUtil(calendar, meetingRoom, meetingToAdd[i][0], meetingToAdd[i][1]);
        }
        return result;
    }

    public boolean isAddedUtil(int[][] calendar, int meetingRoom, int startTime, int endTime) {
        PriorityQueue<Integer> meetingStartTime = new PriorityQueue<>();
        PriorityQueue<Integer> meetingEndTime = new PriorityQueue<>();
        //nlogn

        for (int i = 0; i < calendar.length; i++) {
            meetingStartTime.add(calendar[i][0]);
            meetingEndTime.add(calendar[i][1]);
        }
        meetingStartTime.add(startTime);
        meetingEndTime.add(endTime);

        int minMeetingRoomRequired = 0;
        while (meetingStartTime.size() > 0) {
            if (meetingStartTime.peek() >= meetingEndTime.peek()) {
                minMeetingRoomRequired--;
                meetingEndTime.poll();
            }
            meetingStartTime.poll();
            minMeetingRoomRequired++;
        }
        return minMeetingRoomRequired <= meetingRoom;
    }

    public boolean[] isAdded1(int[][] calendar, int meetingRoom, int[][] meetingToAdd) {
        PriorityQueue<Integer> meetingStartTime = new PriorityQueue<>();
        PriorityQueue<Integer> meetingEndTime = new PriorityQueue<>();

        for (int i = 0; i < calendar.length; i++) {
            meetingStartTime.add(calendar[i][0]);
            meetingEndTime.add(calendar[i][1]);
        }

        boolean[] result = new boolean[meetingToAdd.length];
        for (int i = 0; i < meetingToAdd.length; i++) {
            //result[i] = isAddedUtil1(calendar, meetingStartTime, meetingEndTime, meetingRoom, meetingToAdd[i][0], meetingToAdd[i][1]);
        }
        return result;
    }


    public boolean isAddedUtil1(PriorityQueue<Integer> meetingStartTimeOld, PriorityQueue<Integer> meetingEndTimeOld, int meetingRoom, int startTime, int endTime) {
        PriorityQueue<Integer> meetingStartTime = meetingStartTimeOld;
        PriorityQueue<Integer> meetingEndTime = meetingEndTimeOld;
        //nlogn

        meetingStartTime.add(startTime);
        meetingEndTime.add(endTime);

        int minMeetingRoomRequired = 0;
        while (meetingStartTime.size() > 0) {
            if (meetingStartTime.peek() >= meetingEndTime.peek()) {
                minMeetingRoomRequired--;
                meetingEndTime.poll();
            }
            meetingStartTime.poll();
            minMeetingRoomRequired++;
        }
        return minMeetingRoomRequired <= meetingRoom;
    }

    public static void main(String[] args) {

        AddMeetingToCalender obj = new AddMeetingToCalender();
        int[][] calendar = {{1, 2}, {4, 5}, {8, 10}};
        int rooms = 1;
        int[][] meetingToAdd = {{2, 3}, {3, 4}};

        int[][] calendar1 = {{1, 2}, {4, 5}, {8, 10}};
        int rooms1 = 1;
        int[][] meetingToAdd1 = {{4, 5}, {5, 6}};

        int[][] calendar2 = {{1, 3}, {4, 6}, {6, 8}, {9, 11}, {6, 9}, {1, 3}, {4, 10}};
        int rooms2 = 3;
        int[][] meetingToAdd2 = {{1, 9}, {2, 6}, {7, 9}, {3, 5}, {3, 9}, {2, 4}, {7, 10}, {5, 9}, {3, 10}, {9, 10}};
        Utils.print(obj.isAdded1(calendar2, rooms2, meetingToAdd2));
    }


}
