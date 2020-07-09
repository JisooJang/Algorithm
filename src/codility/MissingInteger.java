package codility;

// https://app.codility.com/c/run/trainingWZ529C-C4Z/
public class MissingInteger {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1000, 1000})); // 1
        System.out.println(solution(new int[]{1,3,6,4,1,2})); // 5
        System.out.println(solution(new int[]{1,3,6,4,1,2,4})); // 5
        System.out.println(solution(new int[]{1,2,3})); // 4
        System.out.println(solution(new int[]{1,-2,3,-5,4})); // 2
        System.out.println(solution(new int[]{1,2,3})); // 4
        System.out.println(solution(new int[]{-1,-3})); // 1
        System.out.println(solution(new int[]{1,2,3})); // 4
        System.out.println(solution(new int[]{0,0})); // 1
        System.out.println(solution(new int[]{1})); // 2
        System.out.println(solution(new int[]{0})); // 1
        System.out.println(solution(new int[]{-3})); // 1
        System.out.println(solution(new int[]{5})); // 1
        System.out.println(solution(new int[]{4})); // 1
        System.out.println(solution(new int[]{3})); // 1
        System.out.println(solution(new int[]{1})); // 2
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = A[0];

        if(A.length == 1) {
            if(max == 1) return 2;
            else return 1;
        }
        // O(N)
        for(int i=1 ; i<A.length ; i++) {
            max = Math.max(max, A[i]);
        }

        // 최댓값이 음수면 배열 A는 모두 음수만 담고 있음.
        if(max <= 0) {
            return 1;
        }

        // A 배열의 최댓값까지의 길이를 가진 배열. 각 range[인덱스-1]에 해당 인덱스값이 A배열에 존재하는지 기록.
        // ex) range[1] = 3이면, 1값이 A 배열에 3개 존재.
        // 이단계에서 배열 A에는 음수 + 양수 모두 존재할 수 있음.
        int[] range = new int[max];
        for(int i=0 ; i<A.length ; i++) {
            int index = A[i];
            if(index <= 0) continue;
            range[index-1]++;
        }

        for(int i=0 ; i<range.length ; i++) {
            if(range[i] == 0) {
                return i+1;
            }
        }
        return max + 1;
    }
}
