package com.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/description/
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> replacementMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cur = s.charAt(i);
            char replacement = t.charAt(i);

            if(replacementMap.containsKey(cur)){
                if(replacement != replacementMap.get(cur))
                    return false;
            }
            else{
                if(replacementMap.containsValue(replacement))
                    return false;
                else
                    replacementMap.put(cur, replacement);
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {
        int[] sValues = new int[256];
        int[] tValues = new int[256];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (sValues[s.charAt(i)] != tValues[t.charAt(i)])
                return false;
            sValues[s.charAt(i)] = i + 1;
            tValues[t.charAt(i)] = i + 1;
        }
        return true;
    }


    public static void main(String[] args) {
        IsomorphicStrings obj = new IsomorphicStrings();
        String s = "egg", t = "add";
        String s1 = "foo", t1 = "bar";
        String s2 = "paper", t2 = "title";
        String s3 = "badc", t3 = "kikp";
        System.out.println(obj.isIsomorphic1(s, t));
        System.out.println(obj.isIsomorphic1(s1, t1));
        System.out.println(obj.isIsomorphic1(s2, t2));
        System.out.println(obj.isIsomorphic1(s3, t3));
    }
}
