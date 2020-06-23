package leetcode;
/*
https://leetcode.com/problems/reformat-the-string/
 */
class Problem1417 {
    public static void main(String[] ars) {
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("leetcode"));
        System.out.println(reformat("1229857369"));
        System.out.println(reformat("covid2019"));
        System.out.println(reformat("a0b1c2"));
        System.out.println(reformat("j"));
        System.out.println(reformat("1"));
    }
    public static String reformat(String s) {
        if(s.length() == 0) return "";

        // 문자 리스트랑 숫자 리스트를 쪼갠다.
        StringBuilder digitStr = new StringBuilder();
        StringBuilder charStr = new StringBuilder();

        // O(N)
        for(int i=0 ; i<s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                digitStr.append(c);
            } else {
                charStr.append(c);
            }
        }

        // 2자이상의 문자중에서 숫자로만 이루어지거나 문자로만 이루어져있으면 안됨.
        if(digitStr.length() == 0 || charStr.length() == 0) {
            if(s.length() == 1) return s;
            return "";
        }

        // 숫자와 문자 length가 같거나 1개 차이 나야 함.
        int abs = Math.abs(digitStr.length() - charStr.length());
        if(abs != 0 && abs != 1) {
            return "";
        }

        boolean isDigitStrLonger = false;
        if(digitStr.length() > charStr.length()) {
            isDigitStrLonger = true;
        }

        StringBuilder result = new StringBuilder();

        // digit이 더 길때
        // O(N)
        if(isDigitStrLonger) {
            for(int i=0 ; i < charStr.length() ; i++) {
                result.append(digitStr.charAt(i));
                result.append(charStr.charAt(i));
            }
            result.append(digitStr.charAt(digitStr.length() - 1));
        } else {
            for(int i=0 ; i < digitStr.length() ; i++) {
                result.append(charStr.charAt(i));
                result.append(digitStr.charAt(i));
            }
            if(charStr.length() > digitStr.length()) {
                result.append(charStr.charAt(charStr.length() - 1));
            }
        }

        String resultStr = result.toString();
        // 인자 str와 result값이 같으면 첫번쨰문자와 세번쨰문자를 교환한다.
        // O(N)
        if(resultStr.equals(s)) {
            char tmp = result.charAt(0);
            char tmp2 = result.charAt(2);
            result.setCharAt(0, tmp2);
            result.setCharAt(2, tmp);
        }

        // 총 시간복잡도 : O(3N) -> O(N)
        return result.toString();
    }
}