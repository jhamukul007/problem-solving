package com.tries;

import com.utils.TriesNode;

public class WordSearch {
    TriesNode root;

    public WordSearch() {
        this.root = new TriesNode();
    }

    public void insert(String word) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char data = word.charAt(i);
            TriesNode child = current.child.get(data);
            if (child == null) {
                child = new TriesNode();
                current.child.put(data, child);
            }
            current = child;
        }
        current.isEnd = true;
    }

    public boolean search(String word, boolean prefixSearch) {
        TriesNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            TriesNode child = current.child.get(c);
            if (child == null)
                return false;
            current = child;
        }
        return prefixSearch ? true : current.isEnd;
    }

    public void delete(String word) {
        delete(this.root, word, 0);
    }

    public boolean delete(TriesNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEnd)
                return false;
            current.isEnd = false;
            return current.child.isEmpty();
        }
        char c = word.charAt(index);
        TriesNode child = current.child.get(c);
        if (child == null)
            return false;
        boolean toDelete = delete(child, word, index + 1);
        if (toDelete) {
            current.child.remove(c);
            return current.child.isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "MUKUL";
        String s1 = "MUKESH";
        String s3 = "MUKU";
        WordSearch obj = new WordSearch();

//        obj.insert(s);
//        obj.insert(s1);
//        obj.insert(s3);
//        obj.delete(s1);
//        System.out.println(obj.search("MUKES", true));
        Boolean[] bool = new Boolean[4];
        for (Boolean b : bool) {
            System.out.println(b);
        }
    }

    /**
     * MUKUL
     */


}
