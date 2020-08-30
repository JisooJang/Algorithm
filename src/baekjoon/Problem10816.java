package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Problem10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        int[] cards = new int[num];

        Map<Integer, Integer> 상근카드 = new HashMap<>();
        String[] line = br.readLine().split(" ");
        for(int i=0 ; i<num ; i++) {
            //cards[i] = s.nextInt();
            cards[i] = Integer.parseInt(line[i]);
            상근카드.put(cards[i], 상근카드.getOrDefault(cards[i], 0) + 1);
        }

        int num2 = s.nextInt();
        int[] target = new int[num2];
        String[] line2 = br.readLine().split(" ");
        for(int i=0 ; i<num2 ; i++) {
            //target[i] = s.nextInt();
            target[i] = Integer.parseInt(line2[i]);
            System.out.print(상근카드.getOrDefault(target[i], 0) + " ");
        }
    }
}
