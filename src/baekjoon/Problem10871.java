package baekjoon;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem10871 {
//    public static void main(String[] args) {
//        Scanner s = new Scanner(System.in);
//        int num = s.nextInt();
//        int x = s.nextInt();
//
//        for(int i=0 ; i<num ; i++) {
//            int tmp = s.nextInt();
//            if(tmp < x) {
//                System.out.print(tmp + " ");
//            }
//        }
//    }

    // refactoring : using StringTokenizer, BufferedReader, BufferedWriter
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));//선언

        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s);

        int num = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        String nums = bf.readLine();
        String[] nums2 = nums.split(" ");
        for(String tmp : nums2) {
            int tmp2 = Integer.parseInt(tmp);
            if(tmp2 < x) {
                bw.write(tmp2 + " ");
            }
        }

        bw.flush();
        bw.close();
    }
}
