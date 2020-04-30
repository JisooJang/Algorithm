package leetcode;

import java.util.ArrayList;
import java.util.List;


/*
Example:
https://leetcode.com/problems/add-and-search-word-data-structure-design/submissions/
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
 */
class WordDictionary {
    List<String> words = null;
    /** Initialize your data structure here. */
    public WordDictionary() {
        words = new ArrayList<String>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        words.add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        boolean result = true, len = false;
        if(word.indexOf('.') != -1) {
            for(int i=0 ; i<this.words.size() ; i++) {
                for(int j=0 ; j<word.length() ; j++) {
                    String dictWord = this.words.get(i);
                    if(word.length() != dictWord.length()) {
                        break;
                    }

                    len = true;

                    if(word.charAt(j) == '.') {
                        continue;
                    }

                    if(dictWord.charAt(j) != word.charAt(j)) {
                        result = false;
                        break;
                    }
                }
                if(result && len) { return true; }
            }

            if(!len) { return false; }
            return result;

        } else {
            if(this.words.contains(word)) {
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
