package com.queue;

import com.utils.Utils;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthMaxNumberInStringArray {
    /**
     * High memory capacity duw to {@link BigInteger}
     *
     * @param nums
     * @param k
     * @return
     */
    public static String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<BigInteger> maxHeap = new PriorityQueue<>(k);
        for (int i = 0; i < k; i++) {
            maxHeap.add(new BigInteger(nums[i]));
        }

        for (int i = k; i < nums.length; i++) {
            BigInteger bigInteger = new BigInteger(nums[i]);

            int cmp = bigInteger.compareTo(maxHeap.peek());
            if (cmp >= 0) {
                maxHeap.poll();
                maxHeap.add(bigInteger);
            }
        }
        return maxHeap.peek().toString();
    }

    public String kthLargestNumberUsingCmp(String[] nums, int k) {
        PriorityQueue<String> maxHeap = new PriorityQueue<>(k, cmp);
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {

            int c = cmp.compare(nums[i], maxHeap.peek());
            if (c >= 0) {
                maxHeap.poll();
                maxHeap.add(nums[i]);
            }
        }
        return maxHeap.peek();
    }

    Comparator<String> cmp = (o1, o2) -> {
        if (o1.length() == o2.length()) {
            int i = 0;
            while (i < o1.length()) {
                Integer i1 = Integer.parseInt("" + o1.charAt(i));
                Integer i2 = Integer.parseInt("" + o2.charAt(i));
                if (i1 == i2)
                    i++;
                else
                    return i1.compareTo(i2);
            }
        }
        return o1.compareTo(o2);
    };

    public static void main(String[] args) {
        KthMaxNumberInStringArray obj = new KthMaxNumberInStringArray();
        // System.out.println(obj.kthLargestNumberUsingCmp(new String[]{"3","6","7","10"}, 4));
//        String[] arr = new String[]{"3","6","7","10"};
//        Arrays.sort(arr);
//        Utils.print(arr);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        System.out.println(queue.peek());
        System.out.println(queue.size());
    }
}
