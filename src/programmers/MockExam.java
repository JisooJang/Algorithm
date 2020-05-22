package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://programmers.co.kr/learn/courses/30/lessons/42840
수포자는 수학을 포기한 사람의 준말입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 */
public class MockExam {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1,2,3,4,5})));
        System.out.println(Arrays.toString(solution(new int[]{1,3,2,4,2})));
    }
    public static int[] solution(int[] answers) {
        List<Integer> answer = new ArrayList<>();
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int aCount = 0, bCount = 0, cCount = 0;
        for(int i=0 ; i<answers.length ; i++) {
            if(answers[i] == a[i % a.length]) { aCount++; }
            if(answers[i] == b[i % b.length]) { bCount++; }
            if(answers[i] == c[i % c.length]) { cCount++; }
        }

        int[] count = {aCount, bCount, cCount};
        int max = Math.max(Math.max(aCount, bCount), cCount);
        for(int i=0 ; i<count.length ; i++) {
            if(count[i] == max) answer.add(i + 1);
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
