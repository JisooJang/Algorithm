package programmers;

import java.util.Stack;

/*
https://programmers.co.kr/learn/courses/30/lessons/42585
- 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있습니다.
- 쇠막대기를 다른 쇠막대기 위에 놓는 경우 완전히 포함되도록 놓되, 끝점은 겹치지 않도록 놓습니다.
- 각 쇠막대기를 자르는 레이저는 적어도 하나 존재합니다.
- 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않습니다.
 */
public class IronBar {
    public static void main(String[] args) {
        System.out.println(solution("()(((()())(())()))(())")); // 17
        System.out.println(solution("()()()")); // 0
        System.out.println(solution("(())")); // 2
        System.out.println(solution("((()))")); // 4
    }
    public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> s = new Stack<>();
        for(int i=0 ; i<arrangement.length() ; i++) {
            char ch = arrangement.charAt(i);

            // i가 마지막 끝 요소가 아니고, 바로 다음 요소가 ')'이면 레이저 처리
            if(i < arrangement.length() - 1) {
                char ch2 = arrangement.charAt(i+1);
                if(ch == '(' && ch2 == ')') {
                    answer += s.size();
                    i++;
                    continue;
                }
            }

            if(ch == '(') {
                s.push(ch);
            }
            else if(ch == ')') {
                s.pop();
                answer++;
            }
        }
        return answer;
    }
}
