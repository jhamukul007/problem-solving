package com.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRoom {
    /**
     * Time : nlog(n)
     * Space: O(1)
     *
     * @param intervals
     * @return
     */
    public static boolean canAttendAllMeeting(int[][] intervals) {
        List<Meeting> meetings = new ArrayList<>();
        Arrays.stream(intervals).forEach(input -> meetings.add(new Meeting(input[0], input[1])));
        Collections.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end)
                return o1.start - o2.start;
            return o1.end - o2.end;
        });
        for (int i = 0; i < meetings.size() - 1; i++) {
            if (meetings.get(i + 1).start <= meetings.get(i).end)
                return false;
        }
        return true;
    }

    /**
     * Time : nlogn
     * SPace: O(1)
     *
     * @param intervals
     * @return
     */
    public static boolean canAttendAllMeeting1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i + 1][0] < intervals[i][1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        canAttendAllMeeting1(intervals);
    }


}

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
