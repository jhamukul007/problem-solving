package com.numbers;

import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {

    List<Integer> uglyNumbers = new ArrayList<>();

    public int nthUglyNumber(int n) {
        if(uglyNumbers.size() >= n - 1)
            return uglyNumbers.get(n-1);


        int lastUglyNumber = uglyNumbers.isEmpty() ? 1 : uglyNumbers.get(uglyNumbers.size() - 1);

        for( ; lastUglyNumber < Integer.MAX_VALUE ; lastUglyNumber++){

            if(uglyNumbers.size() >= n)
                return uglyNumbers.get(n-1);

            if(isUglyNumber(lastUglyNumber)){
                uglyNumbers.add(lastUglyNumber);
            }

        }

        return uglyNumbers.get(n-1);
    }

    boolean isUglyNumber(int n){
        while(n > 1){
            boolean isDivided = false;

            if(n % 5 == 0){
                n /= 5;
                isDivided = true;
            }

            if(n % 3 == 0){
                n /= 3;
                isDivided = true;
            }

            if(n % 2 == 0){
                n /= 2;
                isDivided = true;
            }

            if(!isDivided) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NthUglyNumber obj = new NthUglyNumber();
        System.out.println(obj.nthUglyNumber(10));
    }
}
