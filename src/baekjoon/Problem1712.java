package baekjoon;

import java.util.Scanner;

public class Problem1712 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        /*
        test case: a b c
        1000 70 70
        1000 170 70
        1000 70 170
        2100000000 2100000000 2100000000
         */

        System.out.println(breakEvenPoint(a, b, c));
    }

    public static int breakEvenPoint(int a, int b, int c) {
        if((c - b) < 0) {
            return -1;
        } else if((c - b) == 0) {
            return 1;
        }
        int result = (a / (c - b)) + 1;
        return result;
    }
}
