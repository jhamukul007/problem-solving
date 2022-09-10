package com.array;

import java.util.Arrays;

public class MinimumNumberOfPlatformsRequired {

    public int minimumPlatform(int[] arrivalTime, int[] departureTime) {
        Arrays.sort(arrivalTime);
        Arrays.sort(departureTime);
        int minimumPlatform = 0, arrival = 0, departure = 0, len = arrivalTime.length;
        while (arrival < len) {
            if (arrivalTime[arrival] >= departureTime[departure]) {
                minimumPlatform--;
                departure++;
            }
            minimumPlatform++;
            arrival++;
        }
        return minimumPlatform;
    }

    public static void main(String[] args) {

    }
}
