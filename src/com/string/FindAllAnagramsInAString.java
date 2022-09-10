package com.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 438. Find All Anagrams in a String
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 */
public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        int k = p.length(), n = s.length();
        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < k; i++)
            charMap.put(p.charAt(i), charMap.getOrDefault(p.charAt(i), 0) +1);

        Map<Character, Integer> windowCharMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (i >= k) {
                int counts = windowCharMap.get(s.charAt(i - k));
                if (counts > 1)
                    windowCharMap.put(s.charAt(i - k), counts - 1);
                else
                    windowCharMap.remove(s.charAt(i - k));
            }
            windowCharMap.put(c, windowCharMap.getOrDefault(c, 0) + 1);
            if (i >= k - 1 && charMap.equals(windowCharMap)) {
                    result.add(i - k + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        FindAllAnagramsInAString obj = new FindAllAnagramsInAString();
        System.out.println(obj.findAnagrams(s, p));
    }
}
/*
  charMap
   'a'
   'b'
   'c'

   cbaebabacd
   i = 0, k = 3
   windowMap
   'c'
   'b'
   'a'

 */