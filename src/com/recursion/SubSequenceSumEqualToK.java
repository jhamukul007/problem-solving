package com.recursion;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceSumEqualToK {

    static int[] arr;

    public static void subSequenceSumEqualToK(int[] arr1, int k) {
        arr = arr1;
        subSequenceSumEqualToK(0, k, 0, new ArrayList<>());
    }

    public static void subSequenceSumEqualToK(int index, int k, int sum, List<Integer> subSequences) {
        if (index >= arr.length)
            return;
        subSequences.add(arr[index]);
        sum += arr[index];
        if (sum == k)
            Utils.printItr(subSequences);
        subSequenceSumEqualToK(index + 1, k, sum, subSequences);
        subSequences.remove(subSequences.indexOf(arr[index]));
        sum -= arr[index];
        subSequenceSumEqualToK(index + 1, k, sum, subSequences);
    }

    static int k;

    public static void subSequenceSumEqualToKAnyOne(int[] arr1, int k1) {
        arr = arr1;
        k = k1;
        subSequenceSumEqualToK(0, 0, new ArrayList<>());
    }

    public static boolean subSequenceSumEqualToK(int index, int sum, List<Integer> subSequences) {
        if (index >= arr.length)
            return false;
        subSequences.add(arr[index]);
        sum += arr[index];
        if (sum == k) {
            Utils.printItr(subSequences);
            return true;
        }
        boolean isFound = subSequenceSumEqualToK(index + 1, sum, subSequences);
        if (isFound)
            return true;
        subSequences.remove(subSequences.indexOf(arr[index]));
        sum -= arr[index];
        return subSequenceSumEqualToK(index + 1, sum, subSequences);
    }

    public static int countSequencesEqualToK(int[] arr1, int k1) {
        arr = arr1;
        k = k1;
        return countSequencesEqualToK(0, 0);
    }

    public static int countSequencesEqualToK(int index, int sum) {
        if (index == arr.length){
            if (sum == k)
                return 1;
            return 0;
        }
        sum += arr[index];
        int left = countSequencesEqualToK(index + 1, sum);
        sum -= arr[index];
        int right = countSequencesEqualToK(index + 1, sum);
        return left + right;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 0};
        subSequenceSumEqualToK(arr,2);
        System.out.println(countSequencesEqualToK(arr, 2));
        //subSequenceSumEqualToKAnyOne(arr, 2);
    }
}
