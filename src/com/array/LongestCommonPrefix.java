package com.array;

import com.utils.TriesNode;

public class LongestCommonPrefix {
    /**
     * Space : O(1)
     * Time : O(n*)
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {

        int len = strs.length;
        if (len == 1)
            return strs[0];
        String longestCommonPrefix = strs[0];
        String matching = "";
        String s = "";

        for (int i = 1; i < len; i++) {
            s = strs[i];
            int j = 0;
            int maxLen = longestCommonPrefix.length() < s.length() ? longestCommonPrefix.length() : s.length();
            matching = "";
            while (j < maxLen) {
                if (longestCommonPrefix.charAt(j) != s.charAt(j))
                    break;
                matching += s.charAt(j);
                j++;
            }
            longestCommonPrefix = matching;
        }
        return longestCommonPrefix;
    }

//    TriesNode tries = new TriesNode();
//    public String longestCommonPrefixTries(String[] strs) {
//
//        int len = strs.length;
//        if(len == 1)
//            return strs[0];
//        String first = strs[0];
//
//        for(int i = 0; i < first.length(); i++){
//
//        }
//    }
//
//    private void addIntoTries(char c){
//        TriesNode current = tries;
//        while(current != null){
//            TriesNode tries = new TriesNode();
//        }
//    }

    public static void main(String[] args) {

    }

}


