package leetcode;

import com.sun.org.apache.xml.internal.utils.StringToStringTable;

import java.util.Arrays;

/*
https://leetcode.com/problems/maximum-score-after-splitting-a-string/
 */
public class Problem1422 {
    public static void main(String[] args) {
        System.out.println(maxScore2("011101")); // 5
        System.out.println(maxScore2("00111")); // 5
        System.out.println(maxScore2("1111")); // 3
        System.out.println(maxScore2("11110")); // 3
        System.out.println(maxScore2("0000000")); // 6
        System.out.println(maxScore2("00")); // 1
        System.out.println(maxScore2("1")); // 0
        System.out.println(maxScore2("0")); // 0

    }
    public static int maxScore(String s) {
        int size = s.trim().length();
        if(size == 0) return 0;
        int[] scoreList = new int[size];
        // O(N^2) ?
        for(int i=0 ; i<size-1 ; i++) {
            String left = s.substring(0, i+1).replace("1", ""); // replace method는 내부적으로 반복문 사용(replaceAll method 호출)
            String right = s.substring(i+1, size).replace("0", "");
            scoreList[i] += left.length() + right.length();
        }

        // O(N). stream이랑 for문이랑 퍼포먼스 차이 비교하기! => 차이없음
        return Arrays.stream(scoreList).max().getAsInt();
    }

    public static int maxScore2(String s) {
        int size = s.trim().length();
        if(size == 0) return 0;
        int zeroCount = 0, oneCount = 0, max = 0;
        // O(N)
        for(int i=0 ; i<size ; i++) {
            if(s.charAt(i) == '1') oneCount++;
        }

        // O(N)
        for(int i=0 ; i<size-1 ; i++) {
            if(s.charAt(i) == '0') zeroCount++;
            else oneCount--;
            max = Math.max(max, oneCount + zeroCount);
        }

        // O(2N) -> O(N)
        return max;
    }
}
