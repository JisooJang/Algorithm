package hackerrank;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class BreakingRecords {
    public static void main(String[] args) {
        //System.out.println(pageCount(6, 2)); // 1
        //System.out.println(pageCount(5,4)); // 0
        System.out.println(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
        System.out.println(migratoryBirds2(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        int count = 0;
        if(n == 1 || n == p) return count;
        //if(n % 2 == 0) count += 1;
        if(n - p < p - 1) {
            // 마지막에서부터 시작
            count = (n - p) / 2;
        } else {
            // 1에서부터 시작
            count = p / 2;
        }
        return count;
    }
    static int[] breakingRecords(int[] scores) {
        int[] high = new int[scores.length];
        int[] low = new int[scores.length];
        high[0] = scores[0];
        low[0] = scores[0];
        int highCount = 0, lowCount = 0;
        for(int i=1 ; i<scores.length ; i++) {
            if(scores[i] > high[i-1]) {
                high[i] = scores[i];
                highCount++;
            } else {
                high[i] = high[i-1];
            }

            if(scores[i] < low[i-1]) {
                low[i] = scores[i];
                lowCount++;
            } else {
                low[i] = low[i-1];
            }
        }
        return new int[]{highCount, lowCount};
    }

    static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> count = new ConcurrentHashMap<>();
        for(Integer num : arr) {
            count.put(num, count.getOrDefault(num , 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(count.entrySet());
        entryList.sort((a, b) -> {
            if(a.getValue() == b.getValue()) return a.getKey().compareTo(b.getKey());
            else return b.getValue().compareTo(a.getValue());
        });

        return entryList.get(0).getKey();
    }

    // It is guaranteed that each type is 1,2,3,4,5 => 조건이 있으면 아래와 같이 사용 가능. O(N)
    static int migratoryBirds2(List<Integer> arr) {
        int[] count = new int[5];
        for(int i=0; i<arr.size() ; i++) {
            count[arr.get(i)-1]++;
        }

        int maxIndex = 0;
        int maxValue = count[0];
        for(int i=1 ; i<5 ; i++) {
            if(maxValue < count[i]) {
                maxIndex = i;
                maxValue = count[i];
            }
        }
        return maxIndex + 1;
    }
}
