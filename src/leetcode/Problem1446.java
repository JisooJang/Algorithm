package leetcode;

/*
https://leetcode.com/problems/consecutive-characters/
Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
Return the power of the string.
 */
public class Problem1446 {
    public static void main(String[] args) {
        System.out.println(maxPower("leetcode")); // 2
        System.out.println(maxPower("leetcooode")); // 3
        System.out.println(maxPower("abbcccddddeeeeedcba")); // 5
        System.out.println(maxPower("triplepillooooow")); // 5
        System.out.println(maxPower("hooraaaaaaaaaaay")); // 11
        System.out.println(maxPower("tourist"));
        System.out.println(maxPower("ss"));
    }
    public static int maxPower(String s) {
        int count = 1;
        int countTmp = 1;
        boolean flag = false; // count와 countTmp 값 비교 및 교환 작업이 필요한 인덱스임을 체크하기 위한 값

        for(int i=0 ; i<s.length() - 1 ; i++) {
            if(s.charAt(i) == s.charAt(i+1)) {
                countTmp++;
                flag = true;
            } else {
                if(!flag) continue;
                if(count == 1) count = countTmp;
                else {
                    count = Math.max(count, countTmp);
                }
                countTmp = 1;
                flag = false;
            }
        }
        return Math.max(count, countTmp);
    }
}
