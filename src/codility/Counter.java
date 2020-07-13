package codility;

import java.util.*;

// https://app.codility.com/c/run/trainingKG463Y-AKG/
public class Counter {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution2(5, new int[]{3, 4, 4, 6, 1, 4, 4}))); //
        System.out.println(Arrays.toString(solution2(5, new int[]{1, 5}))); //
        System.out.println(Arrays.toString(solution2(5, new int[]{1, 3, 1, 4, 2, 3, 4}))); //
        System.out.println(Arrays.toString(solution2(5, new int[]{1, 3, 1, 4, 2, 3, 4, 6}))); //
        System.out.println(Arrays.toString(solution2(1, new int[]{1,1,1,1}))); //
        System.out.println(Arrays.toString(solution2(1, new int[]{1}))); //
        System.out.println(Arrays.toString(solution2(10, new int[]{1}))); //
        System.out.println(Arrays.toString(solution2(5, new int[]{6}))); //
        System.out.println(Arrays.toString(solution2(5, new int[]{1, 6}))); //
//        System.out.println(Arrays.toString(solution(1, new int[]{5, 4}))); // -1
//        System.out.println(Arrays.toString(solution(1, new int[]{1}))); // 0
//        System.out.println(Arrays.toString(solution(2, new int[]{2, 2, 2, 2, 2, 2}))); // -1
    }
    public static int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];

        // O(N)
        for(int i=0; i<A.length ; i++) {
            if(A[i] == N + 1) { // i-1까지의 값중 최댓값으로 전부 셋팅.
                int max = result[0];
                // O(N)
                for(int j=1 ; j<result.length ; j++) {
                    if(max < result[j]) max = result[j];
                }
                // O(N)
                Arrays.fill(result, max);

            } else {
                result[A[i] - 1]++;
            }
        }
        return result;
    }

    public static int[] solution2(int N, int[] A) {
        // write your code in Java SE 8
        int[] result = new int[N];
        int maxCount = 0;

        // O(N)
        for(int i=0; i<A.length ; i++) {
            if(A[i] == N + 1) { // i-1까지의 값중 최댓값으로 전부 셋팅.
                Arrays.fill(result, maxCount);
            } else {
                result[A[i] - 1]++;
                maxCount = Math.max(maxCount, result[A[i] - 1]);
            }
        }
        return result;
    }
}
