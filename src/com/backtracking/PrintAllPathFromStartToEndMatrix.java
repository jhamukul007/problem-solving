package com.backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PrintAllPathFromStartToEndMatrix {

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a',1);
        map.put('k',2);

        Map<Character, Integer> map1 = new HashMap<>();
        map1.put('k',2);
        map1.put('a',1);
        System.out.println(map.equals(map1));

        Set<Character> characterSet = new HashSet<>();
        characterSet.add('a');
        characterSet.add('k');

        Set<Character> characterSet1 = new HashSet<>();
        characterSet.add('a');
        characterSet.add('k');

        //System.out.println(characterSet.equals(characterSet1));
    }
}
