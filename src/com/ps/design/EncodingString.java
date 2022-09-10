package com.ps.design;

import java.util.ArrayList;
import java.util.List;

public class EncodingString {

    static final char PREFIX = '@';

    public String encode(List<String> strs) {
        String encoded = "";

        for (String s : strs) {
            encoded += s.length() + "" + PREFIX + s;
        }
        return encoded;
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        StringBuilder builer = new StringBuilder();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (isNumber(c)) {
                builer.append(c);
            }
            if (c == PREFIX) {
                int stringLen = Integer.parseInt(builer.toString());
                if (stringLen == 0) {
                    result.add("");
                    continue;
                }
                builer = new StringBuilder();
                result.add(s.substring(i + 1, i + 1 + stringLen));
                i = i + stringLen;
            }
        }
        return result;
    }

    boolean isNumber(char c) {
        int v = (int) c;
        return v >= 48 && v <= 57;
    }

    public static void main(String[] args) {
        String s = "";
        String result = "12,";
        result += "".equals(s) ? null : s;
        result += ",";
        System.out.println(result);

    }
}
