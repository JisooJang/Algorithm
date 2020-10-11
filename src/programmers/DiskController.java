package programmers;

import java.util.*;

// https://programmers.co.kr/learn/courses/30/lessons/42627
public class DiskController {
    public static void main(String[] args) {
        System.out.println(solution(new int[][]{
                {0,3}, {1,9}, {2,6}
        }));
        System.out.println(solution(new int[][] {
                {0, 10}, {2,10}, {9,10}, {15,2}
        }));
    }
    public static int solution(int[][] jobs) {
        int answer = 0;
        int end = 0; // 수행되고난 직후의 시간
        int jobsIdx = 0; // jobs 배열의 인덱스
        int count = 0; // 수행된 요청 갯수

        // 요청시점 기준으로 오름차순으로 정렬
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));

        // 처리시간 기준으로 오름차순으로 정렬되는 우선순위 큐(Heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        while(count < jobs.length) {
            while(jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                pq.add(jobs[jobsIdx++]);
            }

            if(pq.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = pq.poll();
                answer += temp[1] + end + temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int)Math.floor(answer / jobs.length);
    }
}
