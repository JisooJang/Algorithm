package programmers;

import java.util.Arrays;
import java.util.Comparator;

// https://programmers.co.kr/learn/courses/30/lessons/42746
/*
0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
이중 가장 큰 수는 6210입니다.
 */
class MaxNumber {
    public static void main(String[] args) {
        // test cases
        int[] numbers = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};
        int[] numbers3 =  {32, 323, 320, 343, 3, 5, 9};
        int[] numbers4 = {35, 344};
        int[] numbers5 = {2,20, 200};
        int[] numbers6 = {3, 30, 34};
        int[] numbers7 = {0, 0, 0, 0};
        int[] numbers8 = {0, 0, 7, 0, 0};

        System.out.println(solution(numbers8));
    }

    public static String solution(int[] numbers) {
        String answer;
        String[] numbersToString = new String[numbers.length];
        int i = 0;
        boolean zeroCheck = true;
        for(int num : numbers) {
            if(num > 0) zeroCheck = false;
            numbersToString[i++] = String.valueOf(num);
        }

        if(zeroCheck) return "0";

        Arrays.sort(numbersToString, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int result;
                if(o1.charAt(0) == o2.charAt(0)) {
                    int aa = Integer.parseInt(o1 + o2);
                    int bb = Integer.parseInt(o2 + o1);
                    result = bb - aa;
                } else {
                    result = o1.compareTo(o2) * -1;
                }

                return result;
            }
        });
        return String.join("", numbersToString);
    }
}
