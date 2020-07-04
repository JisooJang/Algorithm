package codility;

import java.util.HashSet;
import java.util.Set;

// https://app.codility.com/c/run/trainingUFHYQM-R6K/
public class OneMissingElement {
    // 현재 위치 X, Y 이상으로 이동, D거리만큼 이동 -> Y 이상으로 도달가능한 최소한의 점프 횟수
    public int solution(int[] A) {
        // write your code in Java SE 8
        if(A == null || A.length == 0) {
            return 1;
        }

        Set<Integer> set = new HashSet<>();

        // O(N)
        for(int i=0 ; i<A.length ; i++) {
            set.add(A[i]);
        }

        // O(N)
        for(int i=1 ; i<=A.length + 1 ; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
