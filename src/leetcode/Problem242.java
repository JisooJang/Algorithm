package leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// https://leetcode.com/problems/valid-anagram/submissions/
class Problem242 {
    public static void main(String[] args) {
        System.out.println(isAnagram("a", "b"));
    }

    // 22 ms
    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> sCheck = new ConcurrentHashMap<>();
        Map<Character, Integer> tCheck = new ConcurrentHashMap<>();

        for(int i=0 ; i<s.length() ; i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            sCheck.put(s1, sCheck.getOrDefault(s1, 0) + 1);
            tCheck.put(t1, tCheck.getOrDefault(t1, 0) + 1);
        }

        if(sCheck.size() != tCheck.size()) return false;
        for(Map.Entry<Character, Integer> entry : sCheck.entrySet()) {
            Character key = entry.getKey();
            int count = entry.getValue();

            if(!tCheck.containsKey(key)) return false;
            if(count != tCheck.get(key)) return false;
        }
        return true;
    }

    // 58 ms
    public static boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Integer> check = new ConcurrentHashMap<>();

        for(int i=0 ; i<s.length() ; i++) {
            char s1 = s.charAt(i);
            char t1 = t.charAt(i);

            check.put(s1, check.getOrDefault(s1, 0) + 1);
            check.put(t1, check.getOrDefault(t1, 0) - 1);
        }

        for(int count : check.values()) {
            if(count != 0) return false;
        }
        return true;
    }
}
