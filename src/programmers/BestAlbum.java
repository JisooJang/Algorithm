package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42579
/*
test case
genres	plays	return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
 */
public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] result = solution(genres, plays);
        System.out.println(Arrays.toString(result));
    }
    public static int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        // 장르별 총 재생수
        Map<String, Integer> genreCount = new HashMap<>();
        for(int i=0 ; i<genres.length ; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // Map의 value 기준으로 정렬
        List<Map.Entry<String, Integer>> list = new LinkedList<>(genreCount.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                // value값 내림차순 정렬
                return (o1.getValue() - o2.getValue()) * -1;
            }
        });

        // list의 key를 반복하면서, 해당하는 키 당 최대값 2개의 곡을 가려내야 함.
        // plays값으로 sort 필요
        for(int i=0 ; i<list.size() ; i++) {
            // 장르중 제일 재생수가 많은 장르부터 검색
            String genre = list.get(i).getKey();
            // 특정 장르당 저장할 인덱스와 재생수
            List<Map.Entry<Integer, Integer>> count = new LinkedList<>();
            for(int j=0 ; j<genres.length ; j++) {
                if(genres[j].equals(genre)) {
                    Map.Entry<Integer, Integer> tmp = new AbstractMap.SimpleEntry<Integer, Integer>(j, plays[j]);
                    count.add(tmp);
                }
            }
            Collections.sort(count, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    // value값의 내림차순 정렬
                    return (o1.getValue() - o2.getValue()) * -1;
                }
            });
            answer.add(count.get(0).getKey());
            if(count.size() >= 2) answer.add(count.get(1).getKey());
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}
