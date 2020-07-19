package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/43165
public class Problem43165 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }
    /*
    테스트 1 〉	통과 (6.52ms, 52.2MB)
    테스트 2 〉	통과 (6.43ms, 52.2MB)
    테스트 3 〉	통과 (1.08ms, 50.2MB)
    테스트 4 〉	통과 (1.40ms, 52.4MB)
    테스트 5 〉	통과 (3.02ms, 52.4MB)
    테스트 6 〉	통과 (1.18ms, 50.9MB)
    테스트 7 〉	통과 (1.02ms, 50.6MB)
    테스트 8 〉	통과 (1.42ms, 50.4MB)
     */
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        answer += dfs(numbers[0], 1, numbers, target);
        answer += dfs(-numbers[0], 1, numbers, target);
        return answer;
    }

    // arguments : beginNode, beginNode 다음 인덱스, 인자1, 인자2
    public static int dfs(int sum, int index, int[] numbers, int target) {
        int answer = 0;

        // index가 5일때 한해서 sum과 target값이 같아야함.
        if(index >= numbers.length) {
            if(sum == target) return 1;
            else return 0;
        }

        int sumPlus = sum + numbers[index];
        int sumMinus = sum - numbers[index];

        answer += dfs(sumPlus, index + 1, numbers, target);
        answer += dfs(sumMinus, index + 1, numbers, target);

        return answer;
    }
}
