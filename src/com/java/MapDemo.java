package com.java;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void testValue() {
        Map<String, String> map = new HashMap<>();
        map.put("Hello", "Hi");
        map.put("Go", "Come");
        map.put("Start", "End");
        System.out.println(map.containsValue("End"));
        System.out.println(map.containsValue("Jha"));
        System.out.println(map.containsValue("Hi"));
    }

    public static void main(String[] args) {
        testValue();
    }
}
