package leetcode;

import java.util.ArrayList;
import java.util.List;
/*
https://leetcode.com/problems/simplified-fractions/
Given an integer n, return a list of all simplified fractions between 0 and 1 (exclusive)
such that the denominator is less-than-or-equal-to n. The fractions can be in any order.
 */
public class Problem1447 {
    public static void main(String[] args) {
        System.out.println(simplifiedFractions(1).toString());
        System.out.println(simplifiedFractions(2).toString());
        System.out.println(simplifiedFractions(3).toString());
        System.out.println(simplifiedFractions(4).toString());
        System.out.println(simplifiedFractions(6).toString());
        System.out.println(simplifiedFractions(10).toString());
        System.out.println(simplifiedFractions(15).toString());

    }
    public static List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<>();
        // 분수는 1보다 작아야함
        // 분모는 n 이하여야함.
        // 분모 > 분자 (1부터 분모 -1까지)
        // 분모가 분자로 나누어 떨어지면 안됨.
        // 분자와 분모가 min값 이하의 공약수가 존재하면 안됨.(소수) 2, 3, 5, 7...

        int 분모 = 0, 분자 = 0;
        // O(N^2)
        for(int i=2; i<=n ; i++) { // 분모 반복문
            분모 = i;
            for(int j=1 ; j<i ; j++) { // 분자 반복문
                분자 = j;
                if(gcd(분자, 분모) != 1) continue;
                answer.add(분자 + "/" + 분모);
            }
        }

        return answer;
    }

    // 최대 공약수
    public static int gcd(int 분자, int 분모) {
        if(분자 == 0) return 분모;
        return gcd(분모 % 분자, 분자);
    }
}
