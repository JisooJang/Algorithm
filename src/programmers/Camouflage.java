package programmers;

import java.util.HashMap;
import java.util.Iterator;

/*
https://programmers.co.kr/learn/courses/30/lessons/42578
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */

class Camouflage {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String key = clothe[1];
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.put(key, map.get(key) + 1);
            }
        }
        for (Integer integer : map.values()) {
            answer *= integer + 1;
        }
        return answer-1;
    }
}
