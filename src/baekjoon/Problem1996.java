package baekjoon;

import java.util.*;

// https://www.acmicpc.net/problem/1966
public class Problem1996 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for(int i=0 ; i<num ; i++) {
            int n = s.nextInt();
            int m = s.nextInt();
            int[] arr = new int[n];
            for(int j=0 ; j<n ; j++) {
                arr[j] = s.nextInt();
            }
            System.out.println(solution(arr, m));
        }
    }

    public static int solution(int[] arr, int m) {
        Queue<Map.Entry<Integer, Integer>> q = new LinkedList<>();
        List<Integer> sortedList = new LinkedList<>();
        int count = 0;
        // O(N)
        for(int i=0 ; i<arr.length ; i++) {
            q.add(new AbstractMap.SimpleEntry<>(i, arr[i]));
            sortedList.add(arr[i]);
        }

        // 배열을 내림차순 정렬한다. O(NlogN)
        sortedList.sort(Comparator.reverseOrder());

        while(!q.isEmpty()) {
            Map.Entry<Integer, Integer> top = q.poll();
            if(top.getValue().equals(sortedList.get(0))) {
                // top이 최댓값이면?
                count++; // 인쇄처리
                if(top.getKey() == m) return count; // top 인덱스가 찾고자하는 m번 인덱스면 count를 리턴한다.
                sortedList.remove(0); // 정렬된 리스트에서 최댓값(0)번 인덱스를 지운다.
            } else {
                // top이 최댓값이 아니면 맨뒤로 보낸다.
                q.add(top);
            }
        }
        return -1;
    }
}

