package codility;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// https://app.codility.com/c/run/trainingRXFKA6-V42/
public class Tape {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2,4,3}));
        System.out.println(solution(new int[]{3,1}));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length == 2) {
            return Math.abs(A[0] - A[1]);
        }
        int sum = 0;
        // O(N)
        for(int num : A) {
            sum += num;
        }

        // O(N)
        int leftSum = 0;
        Set<Integer> diffs = new HashSet<>();
        for (int i=0 ; i<A.length-1 ; i++) {
            leftSum += A[i];
            System.out.println(Math.abs(leftSum - (sum - leftSum)));
            diffs.add(Math.abs(leftSum - (sum - leftSum)));
        }

        // O(N)
        Iterator<Integer> iter = diffs.iterator();
        int result = iter.next();
        while(iter.hasNext()) {
            int num = iter.next();
            if(result > num) result = num;
        }
        return result;
    }
}
