package programmers;

import java.util.HashMap;
import java.util.Map;

// https://programmers.co.kr/learn/courses/30/lessons/42576
public class Hash42576 {
    /*
    test cases
    participant         completion    return
    [leo, kiki, eden]	[eden, kiki]	leo
    [marina, josipa, nikola, vinko, filipa]	[josipa, filipa, marina, nikola]	vinko
    [mislav, stanko, mislav, ana]	[stanko, ana, mislav]	mislav
    [mislav, stanko, mislav, ana, mislav]	[stanko, ana, mislav, mislav, mislav, jisu]	jisu
     */
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"}));
    }
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> tmp = new HashMap<>();

        for (String s : participant) {
            tmp.put(s, tmp.getOrDefault(s, 0) + 1);
        }

        for (String s : completion) {
            tmp.put(s, tmp.get(s) + 1);
        }

        return tmp.entrySet()
                .stream()
                .filter((entry) -> entry.getValue() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
