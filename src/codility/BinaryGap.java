package codility;

import java.util.ArrayList;
import java.util.List;
// https://app.codility.com/c/run/trainingMFFWZX-3RX/
class BinaryGap {
    public static void main(String[] args) {
        System.out.println(solution2(1)); // 0
        System.out.println(solution2(26)); // 0
        System.out.println(solution2(7)); // 0
        System.out.println(solution2(9)); // 2
        System.out.println(solution2(529)); // 4
        System.out.println(solution2(20)); // 1
        System.out.println(solution2(15)); // 0
        System.out.println(solution2(32)); // 0
        System.out.println(solution2(84));// 1
        System.out.println(solution2(2147483646));
        //System.out.println(Integer.toBinaryString(2147483646));

    }
    public static int solution(int N) {
        // write your code in Java SE 8
        String binaryStr = toBinary(N);
        String[] zeroFamily = binaryStr.split("1");
        if(zeroFamily.length == 0) return 0;

        int zeroFamilyLen = zeroFamily.length;
        if(binaryStr.charAt(binaryStr.length() - 1) == '0') zeroFamilyLen--;
        if(zeroFamilyLen == 0) return 0;

        int maxLength = zeroFamily[0].length();
        for(int i=1 ; i<zeroFamilyLen ; i++) {
            int len = zeroFamily[i].length();
            if(len > maxLength) maxLength = len;
        }
        return maxLength;
    }

    public static int solution2(int N) {
        // write your code in Java SE 8
        //String result = String.valueOf(toBinary2(N));
        String result = Integer.toBinaryString(N);
        System.out.println(result);
        List<Integer> zeroCountList = new ArrayList<>();
        int count = 0;
        for(int i=0 ; i<result.length() ; i++) {
            char c = result.charAt(i);
            if(c == '0') {
                count++;
            } else if(c == '1') {
                if(count > 0) {
                    zeroCountList.add(count);
                    count = 0;
                }
            }
        }
        if(zeroCountList.size() == 0) return 0;
        int max = zeroCountList.get(0);
        for(int i=1 ; i<zeroCountList.size() ; i++) {
            int target = zeroCountList.get(i);
            if(max < target) max = target;
        }
        return max;
    }
    public static String toBinary(int N) {
        StringBuilder s = new StringBuilder();
        while(N >= 1) {
            s.append(N % 2);
            N /= 2;
        }
        System.out.println(s.reverse().toString());
        return s.reverse().toString();
    }

    public static long toBinary2(int N) {
        long result = 0;
        long cipher = 1;
        while(N > 1) {
            long tmp = N % 2;
            N /= 2;
            if(tmp == 1) {
                tmp = tmp * cipher;
                result += tmp;
            }
            cipher *= 10;
        }
        result += cipher * N;

        System.out.println(result);
        return result;
    }
}

