package codility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// https://app.codility.com/c/run/trainingQ3JYS9-G9K/
class OddNumberArray {
    public static void main(String[] args) {
        System.out.println(solution2(new int[]{9,3,9,3,9,7,9}));
        System.out.println(solution2(new int[]{3, 3, 3}));
        System.out.println(solution2(new int[]{3}));

    }
    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 1) return A[0];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0 ; i<A.length ; i++) {
            if(q.contains(A[i])) {
                q.remove(A[i]);
            } else {
                q.add(A[i]);
            }
        }

        if(!q.isEmpty()) return q.peek();
        else return -1;
    }

    public static int solution2(int[] A) {
        if(A.length == 1) return A[0];
        // 숫자, 횟수
        Map<Integer, Integer> map = new HashMap<>();
        // O(N)
        for(int i=0 ; i<A.length ; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

        // O(N)
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 != 0) return entry.getKey();
        }

        return -1;
    }
}
