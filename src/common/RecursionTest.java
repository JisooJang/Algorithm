package common;

public class RecursionTest {
    public static void main(String[] args) {
        printInBinary(24);
        System.out.println(sum(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
    public static void printInBinary(int n) {
        if(n < 2) {
            System.out.print(n); // 1
        } else {
            printInBinary(n / 2); // 12 -> 6 -> 3
            System.out.print(n % 2); //  1 -> 0 -> 0 -> 0
        }
        System.out.println();
    }

    public static int sum(int n, int[] data) {
        if(n == 0) {
            return 0;
        } else {
            return data[n-1] + sum(n-1, data);
        }
    }
}
