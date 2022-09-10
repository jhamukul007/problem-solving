package com.skillraisers.package1;

import java.util.ArrayList;
import java.util.List;

public class Watch {
    String watchName;

    String getWatchName() {
        return watchName;
    }

    static String getEncoding(String s) {
        int len = s.length();
        char[] byteArr = new char[4];
        for (int i = 3; i > -1; --i) {
            byteArr[3 - i] = (char) (len >> (i * 8) & 0xff);
        }
        for (char c : byteArr) {
            System.out.println(c);
        }
        return new String(byteArr);
    }

    public static void main(String[] args) {
        char c = '9';
        int n = (int) c;
        System.out.println(n);
        String s = "Hello";
        // System.out.println(s.substring());

    }
}
