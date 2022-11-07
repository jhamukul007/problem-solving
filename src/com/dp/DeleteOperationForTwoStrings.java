package com.dp;

public class DeleteOperationForTwoStrings {
    /**
     * * Time : O(m * n )
     * * Space: O(min(m or n)
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);
        return word1.length() + word2.length() - 2*lcs;
    }

    public int lcs(String s1, String s2){
        int len = s2.length();
        if(s1.length() < s2.length()){
            len = s1.length();
            String temp = s2;
            s2 = s1;
            s1 = temp;
        }

        int[] prev = new int[len+1];
        int[] cur = new int[len+1];

        for(int i = 0; i < s1.length(); i++){
            for(int j = 1; j <= len; j++){
                if(s1.charAt(i) == s2.charAt(j-1))
                    cur[j] = 1 + prev[j-1];
                else
                    cur[j] = Math.max(cur[j-1], prev[j]);
            }

            int[] temp = prev;
            prev = cur;
            cur = temp;
        }

        return prev[len];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings obj = new DeleteOperationForTwoStrings();
        String w1 = "sea";
        String w2 = "eat";

        System.out.println(obj.minDistance(w1, w2));

        String w3 = "leetcode";
        String w4 = "etco";

        System.out.println(obj.minDistance(w3, w4));

        String w5 = "horse", w6 = "ros";
        System.out.println(obj.minDistance(w5, w6));

        String w7 = "intention", w8 = "execution";
        System.out.println(obj.minDistance(w7, w8));
    }
}
