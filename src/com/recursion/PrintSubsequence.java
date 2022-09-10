package com.recursion;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class PrintSubsequence {

    public static void printSubsequence(int[] arr, int index, List<Integer> subsequences) {
        if (index >= arr.length) {
            Utils.printItr(subsequences);
            return;
        }
        subsequences.add(arr[index]);
        printSubsequence(arr, index + 1, subsequences);
        subsequences.remove(subsequences.indexOf(arr[index]));
        printSubsequence(arr, index + 1, subsequences);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2};
        printSubsequence(arr, 0, new ArrayList<>());
    }
}
