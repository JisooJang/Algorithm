package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/528/week-1/3284/
 */
public class HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }

    public static boolean isHappy(int n) {
        Set<Integer> check = new HashSet<>(); // 각 자릿수의 합 결과물을 담을 check set
        int cipherNum = 0; // 각 자릿수의 숫자
        int cipher = 10;
        int result;

        while(check.add(n)) { // set의 add 메소드는 매개변수 값이 이미 set에 존재하면 false를 리턴한다. 존재하지 않으면 true를 리턴.
            result = 0;
            while(n > 0) { // 자릿수 별로 더하는 반복문
                cipherNum = n % cipher;
                result += cipherNum * cipherNum;
                n /= cipher;
            }
            n = result;
            if(result == 1) return true;
        }
        return false;
    }
}
