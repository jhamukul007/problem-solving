package com.java.stack;

import java.util.Stack;

public class PopAndPeek {
    public static void main(String[] args) {
        /*
        Exception in thread "main" java.util.EmptyStackException
	    at java.base/java.util.Stack.peek(Stack.java:101)
	    at java.base/java.util.Stack.pop(Stack.java:83)
	    at com.java.stack.PopAndPeek.main(PopAndPeek.java:9)
         */
        Stack<Integer> stack = new Stack<>();
        System.out.println(stack.peek());
        System.out.println(stack.pop());
    }
}
