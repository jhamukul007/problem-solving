package com.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 1396. Design Underground System
 * https://leetcode.com/problems/design-underground-system/
 */
public class UndergroundSystem {

    Map<Stations, Records> stations;
    Map<Integer, CheckInDeatils> checkInDetails;

    public UndergroundSystem() {
        stations = new HashMap<>();
        checkInDetails = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        CheckInDeatils checkin = new CheckInDeatils(t, stationName);
        checkInDetails.put(id, checkin);
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInDeatils checkinDetails = checkInDetails.get(id);
        Stations station = new Stations(checkinDetails.stationName, stationName);
        Records existedRecord = stations.getOrDefault(station, new Records());
        int traveledTime = t - checkinDetails.time;
        existedRecord.addTime(traveledTime);
        existedRecord.addPerson();
        stations.put(station, existedRecord);
    }

    public double getAverageTime(String startStation, String endStation) {
        Stations station = new Stations(startStation, endStation);
        Records records = stations.get(station);
        if (records == null)
            return 0D;
        double avg = (double) records.totalTimeTaken / (double) records.total;
        return avg;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

class Stations {
    String start;
    String end;

    public Stations(String start, String end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stations stations = (Stations) o;
        return (Objects.equals(this.start, stations.end) && Objects.equals(this.end, stations.start))
                || (Objects.equals(start, stations.start) && Objects.equals(end, stations.end));
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }
}

class Records {
    int totalTimeTaken;
    int total;

    public Records(int totalTimeTaken, int total) {
        this.totalTimeTaken = totalTimeTaken;
        this.total = total;
    }

    public Records() {
    }

    public void addTime(int time) {
        this.totalTimeTaken = this.totalTimeTaken + time;
    }

    public void addPerson() {
        this.total = this.total + 1;
    }
}

class CheckInDeatils {
    int time;
    String stationName;

    public CheckInDeatils(int time, String stationName) {
        this.time = time;
        this.stationName = stationName;
    }
}