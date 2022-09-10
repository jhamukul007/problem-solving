package com.recursion;

import com.utils.Utils;

public class ReverseAArray {

    public static void reverseArray(int[] arr, int index){
        if(index < 0)
            return;
        System.out.println(arr[index] + ",");
        reverseArray(arr, index-1);
    }

    public static int[] reverseArrayInSpace(int[] arr, int index, boolean isEven){
        if(isEven && index < arr.length/2)
            return arr;
        else if(!isEven &&  index == arr.length/2)
            return arr;
        int temp = arr[index];
        int startingIndex = arr.length - (index+1);
        arr[index] = arr[startingIndex];
        arr[startingIndex] = temp;
        return reverseArrayInSpace(arr, index-1, isEven);
    }


    public static int[] reverseArrayInSpace(int[] arr, int left, int right){
        if(right <= left)
            return arr;

        int temp = arr[right];
        arr[right] = arr[left];
        arr[left] = temp;
        return reverseArrayInSpace(arr,left+1, right-1);
    }


    public static void main(String[] args) {
        int[] arr ={1,2,3,4,5,6};
        int[] arr1 ={1,2,3,4,5,6,7};
       // Utils.print(reverseArrayInSpace(arr, arr.length-1, arr.length % 2 == 0));
        //Utils.print(reverseArrayInSpace(arr1, arr1.length-1, arr1.length % 2 == 0));
        Utils.print(reverseArrayInSpace(arr, 0, arr.length-1));
        Utils.print(reverseArrayInSpace(arr1, 0, arr1.length-1));
    }
}
