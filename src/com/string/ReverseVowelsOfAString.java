package com.string;

import java.util.List;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        char[] cArr = s.toCharArray();
        int st = 0, end = cArr.length-1;
        while(st <= end){
            if(isVowel(cArr[st]) && isVowel(cArr[end])){
                if(cArr[st] != cArr[end]){
                    char temp = cArr[st];
                    cArr[st] = cArr[end];
                    cArr[end] = temp;
                }
                st++;
                end--;
            }
            else {
                if (!isVowel(cArr[st]))
                    st++;
                else
                    end--;
            }
        }
        return new String(cArr);
    }

    boolean isVowel(char c){
        return List.of('a','A', 'e', 'E', 'i', "I", 'o', 'O', 'u', 'U').contains(c);
    }

    public static void main(String[] args) {
        ReverseVowelsOfAString obj = new ReverseVowelsOfAString();
        String s = "Live on evasions? No, I save no evil.";
        System.out.println(obj.reverseVowels(s));
    }
}
