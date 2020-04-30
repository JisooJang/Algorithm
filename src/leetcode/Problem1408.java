package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/string-matching-in-an-array/
Given an array of string words. Return all strings in words which is substring of another word in any order.
String words[i] is substring of words[j], if can be obtained removing some characters to left and/or right side of words[j].

Example 1:

Input: words = ["mass","as","hero","superhero"]
Output: ["as","hero"]
Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
["hero","as"] is also a valid answer.
 */
public class Problem1408 {
    public List<String> stringMatching(String[] words) {
        List<String> results = new ArrayList<>();
        for(int i=0 ; i<words.length ; i++) {
            String tmp = words[i];
            for(int j=0 ; j<words.length ; j++) {
                if(i == j) { continue; }
                if(tmp.length() <= words[j].length()) { // 비교 문자열보다 글자수가 같거나 많을때만
                    if(words[j].contains(tmp)) {
                        results.add(tmp);
                        break;
                    }
                }
            }
        }

        return results;

    }
}
