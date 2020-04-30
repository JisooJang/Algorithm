package programmers;

import java.util.List;
import java.util.ArrayList;

/*
https://programmers.co.kr/learn/courses/30/lessons/42586
먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
 */
public class ImproveFunction {
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
}