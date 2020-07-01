package programmers;

import java.util.ArrayList;
import java.util.List;

// https://programmers.co.kr/learn/courses/30/lessons/42839
public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }
    public static int solution(String numbers) {
        int count = 0;
        List<Integer> availableNumbers = new ArrayList<>();

        // step 1: numbers를 돌면서 만들수 있는 숫자들을 모두 넣는다.
        for(int i=0 ; i<numbers.length() ; i++) {
            int num = 0;
            availableNumbers.add(num);
        }

        // step 2: step 1에서 저장한 모든 수들을 돌면서 소수인지 찾는다.
        // O(N * sqrt(N))
        for(int i=0 ;i<availableNumbers.size(); i++) {
            if(isPrime(availableNumbers.get(i))) count++;
        }
        return count;
    }

    // 인자로 넘어온 string으로 가능한 모든 조합의 수를 리턴
    public static List<Integer> findAvailableNumber(String numbers, int 자릿수) {
        return null;
    }

    // 소수인지 체크하는 메서드.
    public static boolean isPrime(int num) {
        if(num >= 0 && num <= 2) return false;

        // 2부터 num의 제곱근까지만 반복하면서 나누어떨어지는 값이 있는지 찾는다. O(sqrt(N))
        for(int i=2 ; i<=Math.sqrt(num) ; i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}
