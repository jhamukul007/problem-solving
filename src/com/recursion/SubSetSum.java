package com.recursion;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubSetSum {

    public  static List<Integer> subsetSum(int[] arr){
        List<Integer> list = new ArrayList<>();
        subsetSum(arr, 0, 0, list);
        Collections.sort(list);
        return list;
    }

    public static void subsetSum(int[] arr,int index, int sum, List<Integer> result){
        if(index >= arr.length){
            result.add(sum);
            return;
        }
        sum += arr[index];
        subsetSum(arr, index+1, sum, result);
        sum -= arr[index];
        subsetSum(arr, index+1, sum, result);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        Utils.printItr(subsetSum(arr));
    }
}
