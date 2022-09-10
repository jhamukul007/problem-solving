package com.sk;

public class Employee {
    private Employee() {
        System.out.println("private Access Modifier with constructor");
    }

    void print() {
        System.out.println("executing print from through private constructor");
    }
}


class Manager {

    static void calculate() {
        int sum = 0;
        for (int i = 1; i <= 3; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        for (int i = 10; i > 7; i--) {
            calculate();
        }

        System.out.println("---------------");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.println(i + ", " + j);
            }
        }

    }
}
