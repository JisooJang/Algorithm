package programmers;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/42586
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
public class ImproveFunction {
    public static void main(String [] args) {
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); // 2, 1
        System.out.println(Arrays.toString(solution(new int[]{93, 30, 55, 90}, new int[]{1, 30, 5, 1}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{10, 20, 30, 40}, new int[]{40, 30, 20, 10}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{10, 20, 30, 40}, new int[]{40, 30, 20, 10}))); // 2, 1, 1
        System.out.println(Arrays.toString(solution(new int[]{99, 97, 95, 96, 93, 92, 96}, new int[]{1, 1, 1, 1, 1, 1, 1}))); // 1, 1, 2, 1, 2
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int[] rest = new int[progresses.length]; // 각 progress 별 걸리는 날짜 기록
        for(int i=0 ; i<progresses.length ; i++) {
            rest[i] = (100 - progresses[i]) / speeds[i]; // 각 progress가 총 몇일 소요되는지 기록
            if((100 - progresses[i]) % speeds[i] > 0) { // 나머지가 있으면 1을 더한다.
                rest[i]++;
            }

        }

        //int answer_index = 0;
        List<Integer> ans = new ArrayList<Integer>();
        int count;
        for(int i=0 ; i<rest.length ; i++) {
            if(rest[i] == -1) {
                continue;
            }
            count = 1;
            for(int j=i+1 ; j<rest.length ; j++) {
                if(rest[i] >= rest[j]) {
                    count++;
                    rest[j] = -1;
                } else {
                    break;
                }
            }
            ans.add(count);
        }

        answer = new int[ans.size()];
        for(int i=0 ; i<ans.size() ; i++) {
            answer[i] = ans.get(i);
        }

        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        int length = progresses.length;
        int[] dayArray = new int[length];

        // O(N)
        // dayArray 배열에 각 progresses 별 남은 작업량을 저장한다.
        for(int i=0 ; i<length ; i++) {
            int rest = (100 - progresses[i]);
            dayArray[i] = rest / speeds[i];
            if(rest % speeds[i] > 0) dayArray[i]++;
        }

        // O(N)
        List<Integer> result = new ArrayList<>();
        int max = dayArray[0];
        int count = 1;

        // 초기 max값을 설정하고, 다음 원소가 max값보다 크면 기존 count값을 추가한다. 단 for문이 끝나면 마지막 count값을 추가한다.
        for(int i=1 ; i<length ; i++) {
            if(dayArray[i] > max) {
                result.add(count);
                count = 1;
                max = dayArray[i];
            } else {
                count++;
            }
        }

        result.add(count); // 마지막 인덱스에서는 마지막 count 값을 어떠한 경우라도 add 해야함.

        // stream 이용하면 기존 1.70ms - 7ms로 느려짐.
        // O(N)
        // 최종 O(3N) -> O(N)
        return result.stream().mapToInt(i->i).toArray();
    }
}