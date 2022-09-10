package com.utils;

import com.utils.pairs.Pair;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.List;

public class Utils {

    public static <T> void print(Iterable<T> entries) {
        entries.forEach(System.out::print);
    }

    public static <T> void printItr(Iterable<T> entries) {
        System.out.print("[");
        entries.forEach(data -> {
            System.out.print(data + " ,");
        });
        System.out.print("]");
    }

    public static void print(int[] arr) {
        if (arr == null) {
            System.out.println("Array is null");
            return;
        }
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(" ]");
    }

    public static void print(int[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void print(char[][] matrix) {
        if (matrix == null) {
            System.out.println("Matrix is null");
            return;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printListNode(ListNode head) {
        if (head == null)
            return;

        while (head != null) {
            System.out.print(head.val + " ---> ");
            head = head.next;
        }
        System.out.print("null");
    }

    public static void print(ListNode head) {
        ListNode current = head;
        if (current == null)
            return;

        while (current != null) {
            System.out.print(current.val + " ---> ");
            current = current.next;
        }
        System.out.print("null");
    }


    public static boolean isNullOrEmpty(int[][] matrix) {
        return matrix == null || matrix.length < 1;
    }

    /**
     * Priority queue
     *
     * @param queue
     * @param <E>
     */
    public static <E> void print(AbstractQueue<E> queue) {
        System.out.print("[ ");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + ", ");
        }
        System.out.print(" ]");
    }

    public static <E> void printAnyThing(E[] data) {
        Arrays.stream(data).forEach(System.out::println);
    }

    public static void print(boolean[] data) {
        System.out.print("[ ");
        String s = "";
        for (boolean d : data) {
            s += d + ",";
        }
        System.out.print(s.substring(0, s.length() - 1));
        System.out.print(" ]");
    }

    public static void print(List<Integer>[] adjacentList) {
        for (int i = 0; i < adjacentList.length; i++) {
            System.out.println(i + " -> " + adjacentList[i]);
        }
    }

    public static <K, V> void printWeightedGraph(List<Pair<K, V>>[] adjacentList) {
        for (int i = 0; i < adjacentList.length; i++) {
            System.out.println(i + " -> " + adjacentList[i]);
        }
    }

    public static void print(TriesNode tries) {
        System.out.println(tries.toString());
    }

    public static void print(Object obj){
        System.out.println(obj);
    }

}
