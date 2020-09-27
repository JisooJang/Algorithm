package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;

// https://www.acmicpc.net/problem/10828
public class Problem10828 {
    // FIXME : 제네릭으로 바꾸기.
    public static class CustomStack {
        private int[] arr;
        private int top;
        private int size;
        int MAXSIZE = 50;

        public CustomStack() {
            arr = new int[MAXSIZE];
            size = 0;
            top = -1;
        }

        public void push(int num) {
            if(size + 1 == MAXSIZE) {
                MAXSIZE += 50;
                int[] newArr = new int[MAXSIZE];
                System.arraycopy(this.arr, 0, newArr, 0, size);
                this.arr = newArr;
            }
            top++;
            size++;
            arr[top] = num;
        }

        public int pop() {
            if(size == 0) {
                return -1;
            }
            top--;
            size--;
            return arr[top + 1];
        }

        public int size() {
            return size;
        }

        public int isEmpty() {
            return size == 0 ? 1 : 0;
        }

        public int top() {
            if(size == 0) {
                return -1;
            }
            return arr[top];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        CustomStack st = new CustomStack();

        for(int i=0 ; i<n ; i++) {
            String command = br.readLine();
            if(command.contains("push")) {
                String[] commandSplit = command.split(" ");
                st.push(Integer.parseInt(commandSplit[1]));
            } else if(command.equals("pop")) {
                System.out.println(st.pop());
            } else if(command.equals("size")) {
                System.out.println(st.size());
            } else if(command.equals("empty")) {
                System.out.println(st.isEmpty());
            } else if(command.equals("top")) {
                System.out.println(st.top());
            }
        }
    }
}
