package com.tree.questions;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    static Map<Integer, String> preCheck = new HashMap<>();

    //'90-='
    static {
        preCheck = Map.of(1000, "M", 500, "D", 100, "C", 50, "L", 10,
                "X", 5, "V", 1, "I");
    }

    public String intToRoman(int num) {
        String roman = preCheck.getOrDefault(num, null);
        if (roman != null)
            return roman;
        int digit = digit(num);
       /* while(num != null){

        }*/
        return null;
    }

    public int digit(int num) {
        return ("" + num).length();
    }
}
