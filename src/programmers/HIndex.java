package programmers;

import java.util.Arrays;

/*
https://programmers.co.kr/learn/courses/30/lessons/42747
발표한 논문 n편 중,
h번 이상 인용된 논문이 h편 이상이고
나머지 논문이 h번 미만 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
단 h라는 수는 꼭 citations 벡터안에 있는 원소가 아니여도되며,
h값이 여러개 존재한다면 최댓값을 리턴한다.
*/
public class HIndex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        int[] citations2 = {0, 1, 1, 1, 1, 3, 3, 4};
        int[] citations3 = {5, 5, 5, 0};
        int[] citations4 = {6, 6, 6, 6, 6};
        System.out.println(solution(citations4));
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i=citations.length ; i>= 0; i--) { // 최댓값을 구해야하므로, HIndex의 범위 중에서 큰값부터 시작하여 반복한다.
            int 이상횟수 = 0;
            int 미만횟수 = 0;
            for(int j=0 ; j<citations.length ; j++) {
                if(citations[j] >= i) {
                    이상횟수++;
                } else {
                    미만횟수++;
                }
            }
            if(이상횟수 >= i  && 미만횟수 < i) { return i; }
        }
        return answer;
    }
}
