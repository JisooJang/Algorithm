package programmers;

import java.util.Arrays;
/*
https://programmers.co.kr/learn/courses/30/lessons/42577
전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 */
public class PhoneList {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook);
        boolean result = true;
        for (int i=0; i<phoneBook.length-1; i++) {
            if (phoneBook[i+1].contains(phoneBook[i])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
