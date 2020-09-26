package baekjoon;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

// https://www.acmicpc.net/problem/4949
public class Problem4949 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String sentence = sc.nextLine();
            System.out.println(isBalanced(sentence) ? "YES" : "NO");
        }

    }
    public static boolean isBalanced(String sentence) {
        Stack<Character> st = new Stack<>();
        for(int i=0 ; i<sentence.length() ; i++) {
            char c = sentence.charAt(i);
            if(c == '(' || c == '[') {
                st.push(c);
            } else if(c == ')') {
                if(st.isEmpty()) return false;
                char c2 = st.pop();
                if(c2 != '(') return false;

            } else if(c == ']') {
                if(st.isEmpty()) return false;
                char c2 = st.pop();
                if(c2 != '[') return false;
            }
        }
        return st.isEmpty();
    }
}

