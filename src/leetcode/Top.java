package leetcode;

/*
https://programmers.co.kr/learn/courses/30/lessons/42588
맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때
각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록
solution 함수를 작성해주세요.

 */
public class Top {
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        answer[0] = 0;
        boolean check = false;
        for(int i=1 ; i<heights.length ; i++) {
            check = false;
            for(int j=i-1 ; j>=0 ; j--) {
                if(heights[i] < heights[j]) {
                    answer[i] = j + 1;
                    check = true;
                    break;
                }
            }
            if(!check) {
                answer[i] = 0;
            }
        }
        return answer;
    }
}
