package codility;

// https://app.codility.com/c/run/training9HV2MS-N7Z/
/*
that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
{ i : A ≤ i ≤ B, i mod K = 0 }
For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(6,11,2)); // 3
        System.out.println(solution(6,11,13)); // 0
        System.out.println(solution(6,11,11)); // 1
        System.out.println(solution(0,9,2)); // 5
        System.out.println(solution(0,11,20)); // 1
        System.out.println(solution(6,6,2)); // 1
        System.out.println(solution(6,6,8)); // 0
        System.out.println(solution(6,7,1)); // 2
        System.out.println(solution(6,11,1)); // 6
        System.out.println(solution(6,6,1)); // 1
        System.out.println(solution(0,1,11)); // 1
        System.out.println(solution(0,0,11)); // 1
        System.out.println(solution(1,1,11)); // 0

    }
    public static int solution2(int A, int B, int K) {
        // write your code in Java SE 8
        int count = 0;
        if(K > B) {
            if(A == 0) return 1;
            else return count;
        } else if(K == B) {
            if(A == 0) return 2;
            else return 1;
        }

        for(int i=A ; i<=B ; ) {
            if(i % K == 0) {
                count++;
                i += K;
            } else if(A < K) {
                i = K;
                //i += 1;
            } else {
                i += 1;
            }
        }
        return count;
    }

    public static int solution(int A, int B, int K) {
        if(A == 0) {
            // 0은 무조건 포함이므로 +1. 0~B까지 / K
            return (B / K) + 1;
        } else {
            return (B / K) - ((A-1) / K);
        }
    }
}
