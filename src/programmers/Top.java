package programmers;

import java.util.*;

/*
https://programmers.co.kr/learn/courses/30/lessons/42588
맨 왼쪽부터 순서대로 탑의 높이를 담은 배열 heights가 매개변수로 주어질 때
각 탑이 쏜 신호를 어느 탑에서 받았는지 기록한 배열을 return 하도록
solution 함수를 작성해주세요.
 */
public class Top {
    public static void main(String[] args) {
        int[] heights = {6,9,5,7,4};
        int[] heights2 = {1, 2, 3, 4, 5};
        int[] heights3 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solution(heights)));
        System.out.println(Arrays.toString(solution2(heights)));
        System.out.println(Arrays.toString(solution2(heights2)));
        System.out.println(Arrays.toString(solution2(heights3)));
    }
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

    // using Stack
    public static int[] solution2(int[] heights) {
        int repeatCnt = 0;
        Stack<Map.Entry<Integer, Integer>> st = new Stack<>();
        int[] result = new int[heights.length];

        for(int i=heights.length-1 ; i>= 0 ; i--) {
            repeatCnt++;
            int height = heights[i];

            // 스택을 돌면서, 기준 height보다 더 작은 원소의 수신 탑은 height의 인덱스로 기록한다.
           while(!st.isEmpty()) {
               repeatCnt++;
                Map.Entry<Integer, Integer> entry = st.peek();
                if(height > entry.getValue()) {
                    result[entry.getKey()] = i+1;
                    st.pop(); // 검사가 끝난 원소는 스택에서 제거한다.
                } else break;
            }

           // 기준 height 원소는 새로 추가한다.
            st.push(new AbstractMap.SimpleEntry<Integer, Integer>(i, height));
        }

        System.out.println("n : " + heights.length + ", 반복횟수 :" + repeatCnt);
        return result;
    }
}
