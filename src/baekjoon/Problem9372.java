package baekjoon;

import java.util.*;

// https://www.acmicpc.net/problem/9372
public class Problem9372 {
    static boolean[] isVisited; // 방문 나라 체크
    static List[] graph;
    static int count;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        for(int i=0 ; i<num ; i++) {
            int countries = s.nextInt();
            int flights = s.nextInt();
            isVisited = new boolean[countries + 1];
            // 경로 체크
            graph = new ArrayList[countries + 1]; // 총 나라 갯수 배열


            for(int j=0 ; j<flights ; j++) {
                int f1 = s.nextInt();
                int f2 = s.nextInt();

                if(graph[f1] == null) {
                    graph[f1] = new ArrayList<>(); // [1] -> 2, 3
                }

                if(graph[f2] == null) {
                    graph[f2] = new ArrayList<>(); // [2] -> 1 // 반대방향 추가
                }

                graph[f1].add(f2);
                graph[f2].add(f1); // 양방향 추가
            }

            for(int k=1 ; k<countries+1 ; k++) {
                bfs(k);
            }

            System.out.println(count-1);
        }
    }

    public static void bfs(int start) {
        count = 0;
        Arrays.fill(isVisited, false);
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(start);
        isVisited[start] = true;

        while(!queue.isEmpty()) {
            int front = queue.poll();
            count++;
            List<Integer> childs = graph[front];
            for(int i=0 ; i<childs.size() ; i++) {
                int child = childs.get(i);
                if(!isVisited[child]) {
                    queue.offer(child);
                    isVisited[child] = true;
                }
            }
        }
    }

}
