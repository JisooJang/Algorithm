package programmers;

import java.util.HashMap;
import java.util.Map;

/*
https://programmers.co.kr/learn/courses/30/lessons/42578
스파이가 가진 의상들이 담긴 2차원 배열 clothes가 주어질 때
서로 다른 옷의 조합의 수를 return 하도록 solution 함수를 작성해주세요.
 */
public class Camouflage {
    public int solution(String[][] clothes) {
        int total_count = clothes.length;

        Map<String, Integer> category = new HashMap<String, Integer>();

        for(int i=0 ; i<clothes.length ; i++) {
            if(category.containsKey(clothes[i][1])) {
                category.put(clothes[i][1], category.get(clothes[i][1]) + 1);
            } else {
                category.put(clothes[i][1], 1);
            }
            //category.put(clothes[i][1], category.getOrDefault(clothes[i][1], 0) + 1);
        }

        if(category.keySet().size() == 1) {
            return total_count;
        }

        int sum = 1;
        for(int count : category.values()) {
            sum *= count;
        }

        return total_count + sum;
    }
}