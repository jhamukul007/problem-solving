package com.array;

import com.utils.Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int len = s.length();
        if (len == 1)
            return 0;
        int[] counts = new int[26];
        Map<Integer, List<Character>> countMapList = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
        }
        Utils.print(counts);
        for (int i = 0; i < counts.length; i++) {
            //char c = counts[i];
        }
        return -1;
    }
}
