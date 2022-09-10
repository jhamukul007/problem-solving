package com.skillraisers.package2;

import com.skillraisers.package1.Watch;

public class Titan {
    public static void main(String[] args) {
        Watch watch = new Watch();
        //Compile Time Error
        // System.out.println(watch.getWatchName());
        //Compile Time Error
        //System.out.println(watch.watchName);
    }
}
