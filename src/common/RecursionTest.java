package common;

public class RecursionTest {
    public static void main(String[] args) {
        printInBinary(24);
    }
    public static void printInBinary(int n) {
        if(n < 2) {
            System.out.print(n); // 1
        } else {
            printInBinary(n / 2); // 12 -> 6 -> 3
            System.out.print(n % 2); //  1 -> 0 -> 0 -> 0
        }
    }
}
