package codility;

import java.util.HashSet;
import java.util.Set;

// https://app.codility.com/c/run/trainingWWQ9TP-MYW/
public class FrogLeaves {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,5,4})); // 5
        System.out.println(solution(5, new int[]{1,5})); // -1
        System.out.println(solution(5, new int[]{1,3,1,4,2,3,4})); // -1
        System.out.println(solution(1, new int[]{5,4})); // -1
        System.out.println(solution(1, new int[]{1})); // 0
        System.out.println(solution(2, new int[]{2,2,2,2,2,2})); // -1
    }
    public static int solution(int X, int[] A) {
        // 1부터 X까지 모두 A배열에 있어야함.
        Set<Integer> XRange = new HashSet<>();

        //O(N)
        for(int i=1 ; i<=X ; i++) {
            XRange.add(i);
        }
        // O(N)
        for(int i=0 ; i<A.length ; i++) {
            XRange.remove(A[i]);
            if(XRange.isEmpty()) return i;
        }
        return -1;
    }
}
