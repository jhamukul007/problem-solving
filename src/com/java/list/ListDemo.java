package com.java.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListDemo {
    static void removeDataFromIteratingList() {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        /*
        Exception in thread "main" java.util.ConcurrentModificationException
	    at java.base/java.util.ArrayList.forEach(ArrayList.java:1513)
	    at com.java.list.ListDemo.removeDataFromIteratingList(ListDemo.java:20)
	    at com.java.list.ListDemo.main(ListDemo.java:27)
         */

        list.forEach(data -> {
            if (data == 3)
                list.remove(3);
            System.out.println(data);
        });
    }

    static void synchronizedList(){
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        List<Integer> threadSafeList = Collections.synchronizedList(list);
        threadSafeList.forEach(d -> {
            if(d == 3)
                threadSafeList.remove(d);
        });
        System.out.println(list);
    }

    static void removeDataFromIteratingList1(){
        List<Integer> list = new CopyOnWriteArrayList<>();
        //CopyOnWriteArrayList<Integer> list1 = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.forEach(d -> {
            if(d == 3)
                list.remove(d);
        });
        System.out.println(list);
    }



    public static void main(String[] args) {
        //removeDataFromIteratingList();
       // removeDataFromIteratingList1();
        synchronizedList();
    }
}
