package com.string;

import java.util.*;

/**
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence/
 */
public class SubsequnceCheck {
    public boolean isSubsequence(String s, String t) {
        List<String> result = new ArrayList<>();
        subsequence(t, 0, new ArrayList<>(), result);
        return result.contains(s);
    }

    void subsequence(String t, int index, List<Character> currentSub, List<String> subsequnces){
        if(index == t.length()){
            String s = "";
            for(char c : currentSub)
                s += c;
            subsequnces.add(s);
            return;
        }
        // pick
        currentSub.add(t.charAt(index));
        subsequence(t, index+1, currentSub, subsequnces);
        currentSub.remove(currentSub.size()-1);
        // not pick
        subsequence(t, index+1, currentSub, subsequnces);
    }

    public boolean isSubsequence1(String s, String t) {
        if(s == null || t == null) return true;
        Map<Character, List<Integer>> indexesMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            List<Integer> indexes = indexesMap.getOrDefault(t.charAt(i), new LinkedList<>());
            indexes.add(i);
            indexesMap.put(t.charAt(i), indexes);

        }
        int lastPickIndex = -1;
        boolean isFound;
        for(int i = 0; i < s.length(); i++){
            List<Integer> indexes = indexesMap.get(s.charAt(i));
            isFound = false;
            if(indexes == null) return false;
            for(int d : indexes){
                if(d > lastPickIndex){
                    lastPickIndex = d;
                    isFound = true;
                    break;
                }

            }
            if(!isFound) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SubsequnceCheck obj = new SubsequnceCheck();
        String s = "abc", t = "ahbgdc";
        String s1 = "ab", t1 = "baab";
        System.out.println(obj.isSubsequence1(s1,t1));
    }
}
