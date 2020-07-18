package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/17680
public class Problem17680 {
    static final int CACHE_HIT = 1;
    static final int CACHE_MISS = 5;
    public static void main(String[] args) {
        String[] cities = {
          "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"
        };

        System.out.println(solution2(3, cities));

        String[] cities2 = {
                "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"
        };

        System.out.println(solution2(5, cities2)); // 50

        String[] cities3 = {"Seoul","Seoul","Seoul","Seoul","Seoul","Seoul","Seoul"};
        System.out.println(solution2(1, cities3)); // 52
        System.out.println(solution2(3, cities3)); // 11

        String[] cities4 = {"Seoul","Jeju","Seoul","Jeju","Seoul","Jeju","Seoul","Jeju","Seoul","Jeju"};
        System.out.println(solution2(1, cities4)); // 50
        String[] cities5 = {"Seoul","seoul","Jeju","Jeju","Seoul","SeouL","Jeju","Jeju"};
        System.out.println(solution2(1, cities5)); // 24

        String[] cities6 = {"Seoul","seoul","Jeju","Jeju","Seoul","SeouL","Jeju","Jeju"};
        System.out.println(solution2(8, cities6)); // 16

    }
    // 순서있는 Map으로 리팩토링 -> 스택 사용할 경우 O(cacheSize * N)
    /*
    테스트 1 〉	통과 (0.90ms, 52.3MB)
    테스트 2 〉	통과 (0.91ms, 52.3MB)
    테스트 3 〉	통과 (0.88ms, 50.7MB)
    테스트 4 〉	통과 (0.90ms, 51.9MB)
    테스트 5 〉	통과 (0.93ms, 53.3MB)
    테스트 6 〉	통과 (0.83ms, 50.5MB)
    테스트 7 〉	통과 (0.77ms, 54.5MB)
    테스트 8 〉	통과 (0.92ms, 52.5MB)
    테스트 9 〉	통과 (0.95ms, 52.1MB)
    테스트 10 〉	통과 (1.05ms, 52.3MB)
    테스트 11 〉	통과 (65.60ms, 88.1MB)
    테스트 12 〉	통과 (1.14ms, 50.4MB)
    테스트 13 〉	통과 (1.15ms, 52.9MB)
    테스트 14 〉	통과 (2.89ms, 53MB)
    테스트 15 〉	통과 (2.10ms, 52.2MB)
    테스트 16 〉	통과 (2.48ms, 50.3MB)
    테스트 17 〉	통과 (0.90ms, 53MB)
    테스트 18 〉	통과 (4.05ms, 52.5MB)
    테스트 19 〉	통과 (4.82ms, 50.7MB)
    테스트 20 〉	통과 (5.19ms, 53MB)
     */
    public static int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * CACHE_MISS;
        int totalScore = 0;
        Queue<String> cache = new LinkedList<>();
        for(int i=0 ; i<cities.length ; i++) {
            String elements = cities[i].toLowerCase();
            if(cache.contains(elements)) { // O(N)
                totalScore += CACHE_HIT;
                // 최신 캐시 위치로 업로드.
                cache.remove(elements);
                cache.add(elements);
            }
            else {
                totalScore += CACHE_MISS;
                if(cache.size() >= cacheSize)
                    cache.poll();
                cache.add(elements);
            }
        }
        return totalScore;
    }

    /*
    테스트 1 〉	통과 (1.05ms, 50.6MB)
    테스트 2 〉	통과 (1.08ms, 52.6MB)
    테스트 3 〉	통과 (1.09ms, 49.9MB)
    테스트 4 〉	통과 (1.14ms, 50.5MB)
    테스트 5 〉	통과 (1.07ms, 52.7MB)
    테스트 6 〉	통과 (0.85ms, 52.3MB)
    테스트 7 〉	통과 (0.90ms, 50.3MB)
    테스트 8 〉	통과 (1.12ms, 52.7MB)
    테스트 9 〉	통과 (1.04ms, 52.1MB)
    테스트 10 〉	통과 (1.35ms, 50.3MB)
    테스트 11 〉	통과 (48.54ms, 90.6MB)
    테스트 12 〉	통과 (1.41ms, 50.6MB)
    테스트 13 〉	통과 (1.39ms, 50.6MB)
    테스트 14 〉	통과 (1.66ms, 52.3MB)
    테스트 15 〉	통과 (3.40ms, 50.4MB)
    테스트 16 〉	통과 (2.74ms, 54.9MB)
    테스트 17 〉	통과 (0.85ms, 50.9MB)
    테스트 18 〉	통과 (4.28ms, 52.6MB)
    테스트 19 〉	통과 (4.48ms, 53MB)
    테스트 20 〉	통과 (5.35ms, 52.8MB)
     */
    public static int solution2(int cacheSize, String[] cities) {
        if(cacheSize == 0) return cities.length * CACHE_MISS;
        int totalScore = 0;
        Map<String, Integer> cache = new LinkedHashMap<String, Integer>(cacheSize) { // 순서가 유지되는 Map
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) { // Map의 사이즈가 다 차면, 오래된 요소 삭제해주는 메소드 오버라이딩
                return size() > cacheSize;
            }
        };
        for(int i=0 ; i<cities.length ; i++) {
            String elements = cities[i].toLowerCase();
            if(cache.get(elements) != null) { // O(1)
                totalScore += CACHE_HIT;
                // 최신 캐시 위치로 업로드.
                cache.remove(elements);
                cache.put(elements, 1);
            }
            else {
                totalScore += CACHE_MISS;
                cache.put(elements, 1);
            }
        }
        return totalScore;
    }

}
