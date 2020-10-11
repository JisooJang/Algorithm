package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://programmers.co.kr/learn/courses/30/lessons/42626
public class MoreSpicy {
    public static void main(String[] args) {
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 +
        // (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;
        Arrays.sort(scoville);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        for(int i=0 ; i<scoville.length ; i++) {
            pq.add(scoville[i]);
        }

        while(!pq.isEmpty()) {
            int item1 = pq.poll();
            if(item1 >= K) {
                return answer;
            } else {
                if(pq.peek() == null) {
                    return -1;
                }
                int item2 = pq.poll();
                int newItem = item1 + (item2 * 2);
                answer++;
                pq.add(newItem);
            }

        }
        return answer;
    }
}

