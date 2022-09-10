package com.string;

import java.util.Stack;

public class ValidParathasis {

    public boolean isValid(String s) {
        int len = s.length();
        if (len == 1)
            return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty())
                return false;

            char top = stack.pop();
            switch (c) {
                case ')':
                    if (top != '(')
                        return false;
                    break;
                case '}':
                    if (top != '{')
                        return false;
                    break;
                case ']':
                    if (top != '[')
                        return false;
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParathasis obj = new ValidParathasis();
        System.out.println(obj.isValid("(){}[]"));

    }
}
