package baekjoon;

import java.util.Scanner;

public class Problem10871 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int x = s.nextInt();

        for(int i=0 ; i<num ; i++) {
            int tmp = s.nextInt();
            if(tmp < x) {
                System.out.print(tmp + " ");
            }
        }
    }
}
