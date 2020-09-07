package programmers;

import java.util.*;

// FIXME : 수정 필요. 런타임 에러
// https://programmers.co.kr/learn/courses/30/lessons/64065
public class Problem64065 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution2("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution2("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution2("{{123}}")));
        System.out.println(Arrays.toString(solution2("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
        System.out.println(Arrays.toString(solution2("{{50000},{1,50000}}")));
    }

    public static int[] solution(String s) {
        // 1. 원소의 갯수가 1개인 것부터 2.. 3.... n개인 것 까지 정렬한다.
        s = s.replaceAll("\\{", "");
        s = s.replaceAll("\\}\\}", "");
        String[] elements = s.split("\\},");

        if(elements.length > 1)
            Arrays.sort(elements, (s1, s2) -> s1.length() - s2.length()); // 문자열 길이 기준으로 오름차순 정렬

        // 2. 1개인 것부터 answer 배열에 넣고, 2개인 것에는 1개 원소를 빼고, 3개인 것에는 2개 원소를 빼고...
        int[] answer = new int[elements.length];

        // O(NlogN)
        for(int i=1 ; i<=elements.length ; i++) {
            String sub = elements[i-1].replaceAll(",", "");
            answer[i-1] = Integer.parseInt(sub);
            for(int j=i ; j<elements.length ; j++) {
                elements[j] = elements[j].replaceAll(sub, "");
            }
        }
        return answer;
    }

    // using Map
    public static int[] solution2(String s) {
        // String을 콤마 기준으로 잘라서 배열로 만든다.
        // 각 문자를 반복하면서 Map에 key는 숫자, value는 등장 횟수로 저장한다.
        // Map을 List로 변환하여 value 기준으로 내림차순 정렬한다.
        // 가장 count가 많이 등장한 숫자부터 answer 배열에 key를 넣는다.
        // answer 배열을 리턴한다.

        Map<Integer, Integer> checkCount = new HashMap<>();
        s = s.replaceAll("\\{", "").replaceAll("\\}", "");
        String[] elements = s.split(",");

        // O(N)
        for(int i=0 ; i<elements.length ; i++) {
            int num = Integer.parseInt(elements[i]);
            checkCount.put(num, checkCount.getOrDefault(num, 0) + 1);
        }
        int[] answer = new int[checkCount.size()];

        List<Map.Entry<Integer, Integer>> mapToList = new LinkedList<>(checkCount.entrySet());
        mapToList.sort(Map.Entry.comparingByValue((v1, v2) -> v2 - v1));

        int i = 0;

        // O(N)
        for(Map.Entry<Integer, Integer> entry : mapToList) {
            answer[i++] = entry.getKey();
        }
        return answer;
    }
}
