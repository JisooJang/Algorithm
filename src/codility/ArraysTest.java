package codility;

import java.util.Arrays;

// https://app.codility.com/c/run/training3ZZPMN-YFE/
class ArraysTest {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(solution(new int[]{3, 8, 9, 7, 6}, 8)));
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 1}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4}, 4)));

    }
    public static int[] solution(int[] A, int K) {
        // write your code in Java SE 8
        if(A.length == 0) return null;
        K = K % A.length;
        if(K == 0) return A;

        int[] left = new int[A.length - K];
        int[] right = new int[K];

        System.arraycopy(A, 0, left, 0, A.length - K);
        System.arraycopy(A, A.length - K, right, 0, K);

        int[] result = new int[A.length];
        System.arraycopy(right, 0, result, 0, right.length);
        System.arraycopy(left, 0, result, right.length, left.length);
        return result;
    }
}

