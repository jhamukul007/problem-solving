package com.string;

public class NextGreaterNumber {

    public int nextGreaterElement(int n) {
        StringBuilder builder = new StringBuilder(n + "");
        int len = builder.length();
        if (len == 1)
            return -1;
        if (len == 2) {
            if (Integer.parseInt(builder.charAt(len - 1) + "") > Integer.parseInt(builder.charAt(0) + "")) {
                swap(builder, 0, 1);
                return Integer.parseInt(builder.toString());
            }
        }
        for (int i = len - 1; i > 1; i--) {
            int prev = Integer.parseInt(builder.charAt(i - 1) + "");
            int cur = Integer.parseInt(builder.charAt(i) + "");

            if (prev < cur) {
                int nextGreater = 0;
                int minDiff = Integer.MAX_VALUE;
                for (int j = i; j < len; j++) {
                    int diff = Integer.parseInt(builder.charAt(j) + "") - prev;
                    if (diff < minDiff) {
                        minDiff = diff;
                        nextGreater = j;
                    }
                }
                swap(builder, i - 1, nextGreater);
                reverse(builder, i);
                break;
            }
        }
        return Integer.parseInt(builder.toString());
    }

    void swap(StringBuilder s, int from, int to) {
        char c = s.charAt(to);
        s.setCharAt(to, s.charAt(from));
        s.setCharAt(from, c);
    }

    void reverse(StringBuilder s, int from) {
        StringBuilder temp = new StringBuilder(s.substring(from));
        temp.reverse();
        s.replace(from, s.length(), temp.toString());
    }

    public static void main(String[] args) {
        NextGreaterNumber obj = new NextGreaterNumber();
        System.out.println(obj.nextGreaterElement(230241));
    }
}
