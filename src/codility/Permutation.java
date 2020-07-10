package codility;

// https://app.codility.com/c/run/trainingN5XT25-YQ3/
public class Permutation {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,1,3,2})); // 1
        System.out.println(solution(new int[]{4,1,3})); // 0
        System.out.println(solution(new int[]{1})); // 1
        System.out.println(solution(new int[]{1,1})); // 0
        System.out.println(solution(new int[]{2,1})); // 1
        System.out.println(solution(new int[]{2})); // 0
        System.out.println(solution(new int[]{4})); // 0
        System.out.println(solution(new int[]{1,3,5,7,9})); // 0
        System.out.println(solution(new int[]{5,4,3,2,1})); // 1
    }
    public static int solution(int[] A) {
        // write your code in Java SE 8

        // 배열 사이즈가 1이면 무조건 A[0]은 1이여야 함.
        if(A.length == 1) {
            if(A[0] == 1) return 1;
            else return 0;
        }

        //permutationCheck[index]의 값을 counting하며 증가시킴. index는 A배열의 원소값
        // 즉 permutationCheck 배열은 1에서 N까지 A 배열의 원소들이 각각 값을 갖고 있는지 체크
        int[] permutationCheck = new int[A.length];
        for(int i=0 ; i<A.length ; i++) {
            int index = A[i];
            if(index > A.length) return 0;
            permutationCheck[index - 1]++;
        }

        for(int i=0 ; i<permutationCheck.length ; i++) {
            // permutation 배열 값중 0이 있으면 특정 순열값이 존재하지 않은 것이므로 순열이 아님.
            if(permutationCheck[i] == 0) return 0;
        }
        return 1;
    }
}
