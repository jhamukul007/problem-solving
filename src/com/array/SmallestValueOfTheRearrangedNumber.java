package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 2165. Smallest Value of the Rearranged Number
 * https://leetcode.com/problems/smallest-value-of-the-rearranged-number/
 * https://jamboard.google.com/d/1w9jGCsfkNF7ddtv5ExFbeVCQb3mKK7piafUs43FDQPo/viewer?f=1
 */
public class SmallestValueOfTheRearrangedNumber {
    /**
     * Time : O(nlogn)
     * Space : O(n)
     * Approach: Sorting in descending order
     * @param num
     * @return
     */
    public long smallestNumber(long num) {
        boolean isNegative = num < 0;
        String s = ""+num;
        if(isNegative)
            s = s.substring(1);
        List<Character> charArray = new ArrayList<>();
        for(int i = 0; i < s.length(); i++)
            charArray.add(s.charAt(i));

        Comparator<Character> comp = (o1, o2) -> {
          Integer d1 = Integer.parseInt(o1+"");
          Integer d2 = Integer.parseInt(o2+"");
          return d1.compareTo(d2);
        };

        Collections.sort(charArray, comp);
        if(!isNegative)
            checkAndVerifyTrailingZero(charArray);
        long result;
        s = "";
        if(isNegative){
            for(int i = charArray.size()-1 ; i >= 0; i--)
                s += charArray.get(i);
        }
        else{
            for(int i = 0 ; i < charArray.size(); i++)
                s += charArray.get(i);
        }
        result = Long.parseLong(s);
        return isNegative ? (result * -1L) : result;
    }

    void checkAndVerifyTrailingZero(List<Character> arr){
        if(arr.get(0) != '0')
            return;
        for(int i = 0; i < arr.size()-1; i++){
            if(arr.get(i) != arr.get(i+1)){
                char data = arr.get(i+1);
                arr.set(i+1, arr.get(0));
                arr.set(0, data);
                break;
            }
        }
    }

    public static void main(String[] args) {
        SmallestValueOfTheRearrangedNumber obj = new SmallestValueOfTheRearrangedNumber();
        //Long l = 310L;
        //long l = -7605L;
        long l = 4576000;
        System.out.println(obj.smallestNumber(l));
    }

}
