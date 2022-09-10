package com.string;

import com.utils.Utils;

public class MaximumFrequencyChar {

    static char maximum(String s) {
        int len = s.length();
        if (len == 1)
            return s.charAt(0);

        int[] counts = new int[26];
        for (int i = 0; i < len; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        Utils.print(counts);
        int maximum = 0;
        char maximumChar = 0;
        for (int i = 0; i < counts.length; i++) {
            int count = counts[i];
            if (count == 0)
                continue;
            if (counts[i] > maximum) {
                maximum = counts[i];
                maximumChar = (char) (i + 'a');
            }
        }
        return maximumChar;
    }

    public static void main(String[] args) {
        String s = "abcc";
        System.out.println(maximum(s));
    }
}
