package programmers;

import java.util.Arrays;
/*
https://programmers.co.kr/learn/courses/30/lessons/42584
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.
* 문제 이해가 더 필요함. 개선 필요
 */
public class StockPrice {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3}))); // 4, 3, 1, 1, 0
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1, 1, 1})));
        System.out.println(Arrays.toString(solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 2, 3, 1}))); //  5, 4, 1, 2, 1, 0
        System.out.println(Arrays.toString(solution(new int[]{3, 1}))); // 1. 0

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0 ; i<prices.length ; i++) {
            int target = prices[i];
            int count = 0;
            for(int j=i+1 ; j<prices.length ; j++) {
                if(prices[j] >= target) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
