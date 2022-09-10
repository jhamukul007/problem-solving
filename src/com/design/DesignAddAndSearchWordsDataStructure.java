package com.design;

import com.utils.TriesNode;
import com.utils.Utils;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * 211. Design Add and Search Words Data Structure
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/
 */
public class DesignAddAndSearchWordsDataStructure {
    WordDictionary obj = new WordDictionary();

    public void addWord(String word) {
        obj.addWord(word);
    }

    public boolean search(String word) {
        return obj.search(word);
    }

    public class WordDictionary {
        TriesNode triesNode;

        public WordDictionary() {
            triesNode = new TriesNode();
        }

        public void addWord(String word) {
            TriesNode current = triesNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TriesNode childNode = current.child.get(c);
                if (childNode == null) {
                    childNode = new TriesNode();
                    current.child.put(c, childNode);
                }
                current = childNode;
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            if(word.endsWith("."))
                return searchPrefix(word);
            TriesNode current = triesNode;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                TriesNode childNode = current.child.get(c);
                if (childNode == null)
                    return false;
                current = childNode;
            }
            return current.isEnd;
        }

        public boolean searchPrefix(String word) {
            TriesNode current = triesNode;
            for (int i = 0; i < word.length(); i++) {
                TriesNode childNode = null;
                if(!".".equals(word)) {
                    char c = word.charAt(i);
                    childNode = current.child.get(c);
                    if (childNode == null)
                        return false;
                    current = childNode;
                }
                // Set<Character> childCharSet =  current.child.keySet();

            }
            return true;
        }
    }

    public static void main(String[] args) {
        DesignAddAndSearchWordsDataStructure obj = new DesignAddAndSearchWordsDataStructure();
        obj.addWord("Muk");
        obj.addWord("Muku");
        obj.addWord("Mukul");
        System.out.println(obj.obj.triesNode);
        System.out.println(obj.search("Muk.."));
    }
}




// Muk
// Muku
// Mukul