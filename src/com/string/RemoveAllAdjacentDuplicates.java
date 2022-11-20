package com.string;

public class RemoveAllAdjacentDuplicates {
    /**
     * *
     * @param s
     * @return
     */
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while(i < sb.length()){
            if(i + 1 < sb.length()){
                if(sb.charAt(i) == sb.charAt(i+1)){
                    sb.deleteCharAt(i);
                    sb.deleteCharAt(i);
                    if(i >= 1)
                        i = i - 1;
                    else{
                        i = 0;
                    }
                }
                else{
                    i++;
                }
            }
            else{
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
