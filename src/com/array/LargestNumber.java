package com.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    /**
     * Time : nlog(n)
     * Space : O(n)
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        List<String> tempArr = new ArrayList<>();
        for(int i = 0; i< nums.length; i++)
            tempArr.add(nums[i]+"");

        Comparator<String> cmp = (o1, o2) -> (o2+o1).compareTo(o1+o2);
        Collections.sort(tempArr, cmp);
        String biggestNumber = "";
        if("0".equals(tempArr.get(0)))
            return "0";
        for(String num: tempArr)
            biggestNumber += num;

        return biggestNumber;
    }

    public static void main(String[] args) {
        //int[] arr = {10,2};
       // int[] arr = {3,30,34,5,9};
        int[] arr = {34323,3432};
        //int[] arr = {3,30,34,5,9};
        LargestNumber obj = new LargestNumber();
        System.out.println(obj.largestNumber(arr));
    }
}

/*
[34323,3432]
 34323 3432
 3432 34323
 */
