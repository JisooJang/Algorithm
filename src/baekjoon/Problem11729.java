package baekjoon;
import java.io.*;

public class Problem11729 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        if(num == 1) {
            bw.write(1 + "\n");
        }else if(num % 2 == 0) {
            bw.write(num * num - 1 + "\n");
        } else {
            bw.write(num * num - 2 + "\n");
        }

        hanoi(num, 1, 2, 3);
        bw.flush();
        bw.close();
    }

    public static void hanoi(int num, int first, int rest, int end) throws IOException {
        if(num == 0) {
            return;
        }
        hanoi(num - 1, first, end, rest);
        bw.write(first + " " + end + "\n");
        hanoi(num - 1, rest, first, end);
    }
}
