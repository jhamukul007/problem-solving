package com.recursion;

import com.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */
public class AllPermutations {
    List<List<Integer>> result;

    public List<List<Integer>> allPermutations(int[] arr) {
        result = new ArrayList<>();
        Map<Integer, Boolean> isTakenMap = new HashMap<>();
        List<Integer> permutations = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            permutations.clear();
            permutations.add(arr[i]);
            isTakenMap.clear();
            isTakenMap.put(i, true);
            permutations(arr, 0, permutations, isTakenMap);
        }
        return result;
    }

    void permutations(int[] arr, int index, List<Integer> permutations, Map<Integer, Boolean> isTakenMap) {
        if (permutations.size() == arr.length) {
            result.add(new ArrayList<>(permutations));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (isTakenMap.getOrDefault(i, false))
                continue;
            permutations.add(arr[i]);
            isTakenMap.put(i, true);
            permutations(arr, i + 1, permutations, isTakenMap);
            permutations.remove(permutations.indexOf(arr[i]));
            isTakenMap.put(i, false);
        }
    }

    /**
     * All permutations of a string
     *
     * @param
     */
    public List<String> permutations(String str) {
        List<String> allPermutations = new ArrayList<>();
        String permutations = "";
        boolean[] isTakenMap = new boolean[str.length()];
        permute(str, new ArrayList<>(), allPermutations, isTakenMap);
        return allPermutations;
    }

    public void permute(String str, List<Character> permutations, List<String> allPermutations, boolean[] isTakenMap) {
        if (str.length() == permutations.size()) {
            allPermutations.add(convertToString(permutations));
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            if (isTakenMap[i])
                continue;
            permutations.add(str.charAt(i));
            isTakenMap[i] = true;
            permute(str, permutations, allPermutations, isTakenMap);
            permutations.remove(permutations.size() - 1);
            isTakenMap[i] = false;
        }
    }

    String convertToString(List<Character> data) {
        String s = data.toString();
        s = s.replaceAll("\\[", "");
        s = s.replaceAll("\\]", "");
        s = s.replaceAll("\\,", "");
        return s;
    }

    /**
     * Optimized and swaped
     *
     * @param
     */
    List<List<Integer>> allPermutations;

    public List<List<Integer>> permute(int[] nums) {
        allPermutations = new ArrayList<>();
        permute(nums, 0);
        return allPermutations;
    }

    void permute(int[] nums, int index) {
        if (index >= nums.length) {
            List<Integer> permutations = new ArrayList<>();
            for (int num : nums) {
                permutations.add(num);
            }
            allPermutations.add(permutations);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1);
            swap(nums, index, i);
        }
    }

    void swap(int[] nums, int from, int to) {
        int data = nums[from];
        nums[from] = nums[to];
        nums[to] = data;
    }

    public static void main(String[] args) {
        AllPermutations obj = new AllPermutations();
        /*int[] arr = {1,2,3};
        Utils.printItr(obj.allPermutations(arr));*/

//        String s = "mukul";
//        List<String> result = obj.permutations(s);
//        System.out.println(result.size());
//        Utils.printItr(result);

        int[] arr = {1,2,3};
        Utils.printItr(obj.permute(arr));


    }

    //5*4*3*2 = 120
}
