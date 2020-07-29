package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/43162
public class Problem43162 {
    public static void main(String[] args) {
        int[][] computers = {
                {1,1,0}, {1,1,0}, {0,0,1}
        };
        System.out.println(solution(3, computers)); // 2

        int[][] computers2 = {
                {1,1,0}, {1,1,1}, {0,1,1}
        };
        System.out.println(solution(3, computers2)); // 1

        int[][] computers3 = {
                {1,1,1}, {1,1,1}, {1,1,1}
        };
        System.out.println(solution(3, computers3)); // 1
    }

    public static void dfs(int i, int[][] computers, boolean[] visited) {
        if(visited[i]) {
            return;
        }

        visited[i] = true;
        for(int j=0 ; j<computers.length ; j++) {
            if(computers[i][j] == 1) {
                dfs(j, computers, visited);
            }
        }
    }
    public static int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            if(!visited[i]) {
                dfs(i, computers, visited);
                result++;
            }
        }
        return result;
    }
}
