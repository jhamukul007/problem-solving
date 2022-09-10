package com.ps.math;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 * 202. Happy Number
 */
public class HappyNumber {

    /**
     * Time complexity O(log(n))
     * Space: O(n)
     *
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        Set<Integer> cycleDetect = new HashSet<>();
        while (n != 1 && !cycleDetect.contains(n)) {
            cycleDetect.add(n);
            n = totalSqureSum(n);
        }
        return n == 1;
    }

    int totalSqureSum(int n) {
        int total = 0;

        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            total += digit * digit;
        }
        return total;
    }

    public boolean isHappyWithSlowAndFastPointer(int n) {
        int slow = n;
        int fast = totalSqureSum(n);

        while (fast != 1 && slow != fast) {
            slow = totalSqureSum(slow);
            fast = totalSqureSum(totalSqureSum(fast));
        }
        return fast == 1;
    }

}
