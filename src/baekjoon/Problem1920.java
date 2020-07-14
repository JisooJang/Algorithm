package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/problem/1920
public class Problem1920 {
    public static void main(String[] args) throws IOException {
//        InputStreamReader isr = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(isr);
//        int n = Integer.parseInt(br.readLine());
//        int[] arrInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        int m = Integer.parseInt(br.readLine());
//        int[] numInput = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        solution2(n, arrInput, m, numInput);
        // test cases
        // solution3(5, new int[]{4,1,5,2,3}, 5, new int[]{1,3,7,9,5});
        //solution2(5, new int[]{4,1,5,2,3}, 7, new int[]{1,3,7,9,5,6,8});
        // solution2(5, new int[]{1,1,1,1,1}, 7, new int[]{1,3,7,9,5,6,8});
        // solution2(5, new int[]{-4,-1,-5,2,3}, 7, new int[]{-1,3,7,9,-5,6,8});
        // solution2(7, new int[]{4,1,5,2,3,8,6}, 5, new int[]{1,3,7,9,5});
        // solution2(1, new int[]{1}, 2, new int[]{1,1});
    }

    // 틀림 오답.
    public static void solution(int n, int[] nArray, int m, int[] mArray) {
        Map<Integer, Integer> check = new HashMap<>();
        // if n<m, n==m, n>m case 고려
        for(int i=0 ; i<n ; i++) {
            check.put(nArray[i], check.getOrDefault(nArray[i], 0) + 1);
            if(i < m) {
                check.put(mArray[i], check.getOrDefault(mArray[i], 0) + 1);
            }
        }

        for(int i=0 ; i<m ; i++) {
            int result = check.getOrDefault(mArray[i], 0);
            if(result > 1) {
                System.out.print("1");
            } else {
                System.out.print("0");
            }

            if(i<m-1) System.out.println();
        }
    }

    // 정답 (Map 이용) 메모리 80812KB 시간	1276ms
    public static void solution2(int n, int[] nArray, int m, int[] mArray) {
        Map<Integer, Integer> check = new HashMap<>();
        // if n<m, n==m, n>m case 고려
        for(int i=0 ; i<n ; i++) {
            check.put(nArray[i], check.getOrDefault(nArray[i], 0) + 1);
        }

        for(int i=0 ; i<m ; i++) {
            if(check.containsKey(mArray[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    // 정답 (Set 이용) -> 메모리 111636KB 시간	1936ms
    public static void solution3(int n, int[] nArray, int m, int[] mArray) {
        Set<Integer> check = new HashSet<>();
        for(int i=0 ; i<n ; i++) {
            check.add(nArray[i]);
        }

        for(int i=0 ; i<m ; i++) {
            if(check.contains(mArray[i])) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }
}

