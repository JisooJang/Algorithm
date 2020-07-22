package common;

import java.io.*;
import java.util.Arrays;

public class RecursionTest {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
//        printInBinary(24);
//        System.out.println(sum(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
//        System.out.println(findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 7));
//        System.out.println(findMax2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 7));
//        System.out.println(binarySearch(new String[]{"aaa", "bbb", "ccc", "ddd", "eee"}, "ffff", 0, 4));
//        System.out.println(binarySearch(new String[]{"aaa", "bbb", "ccc", "ddd", "eee"}, "11", 0, 4));
        //hanoi2(3, 1, 2, 3);
        //System.out.println(fibo(20));
        //System.out.println(factorial(12));
        //System.out.println(최대공약수(22, 8));
        //System.out.println(gcd_array(new int[]{3, 6, 12, 27}));
        //test();
        System.out.println(최대공약수2(22, 8)); // 2
        System.out.println(최대공약수2(18, 12)); // 6
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

    public static Integer findMax(int[] arr, int beginIndex, int endIndex) {
        if(beginIndex == endIndex) {
            return arr[beginIndex];
        }
        System.out.println(arr[beginIndex]);
        int result = Math.max(arr[beginIndex], findMax(arr, beginIndex + 1, endIndex));
        System.out.println("result : " + arr[beginIndex] + ":" + result);
        return result;
    }

    public static Integer findMax2(int[] arr, int beginIndex, int endIndex) {
        if(beginIndex == endIndex) {
            return arr[beginIndex];
        }
        int mid = (beginIndex + endIndex) / 2;
        System.out.println("mid : " + mid);

        int leftMax = findMax2(arr, beginIndex, mid);
        System.out.println("leftMax : " + leftMax);

        int rightMax = findMax2(arr, mid + 1, endIndex);
        System.out.println("rightMax : " + rightMax);

        return Math.max(leftMax, rightMax);
    }

    public static int binarySearch(String[] arr, String target, int beginIndex, int endIndex) {
        if(beginIndex >= endIndex) {
            return -1;
        }
        int mid = (beginIndex + endIndex) / 2;
        int result = target.compareTo(arr[mid]);
        if(result == 0) return mid;
        else if(result < 0) {
            return binarySearch(arr, target, beginIndex, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, endIndex);
        }
    }

    // 현재 위치에서 출구까지 가는 경로가 있다면
    // 1) 현재 위치가 출구일 때 (반복 종료 조건)
    // 2) 혹은 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있을 때
    public static int 미로찾기() {
        return 0;
    }

    public static int fibo(int n) {
        if(n <= 2)  return 1;
        return fibo(n-1) + fibo(n-2);
    }

    public static long factorial(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return n * factorial(n - 1);
    }

    // 원반갯수, 출발, 목적, 나머지
//    public static void hanoi(int num, int from, int to, int other) {
//        if(num == 0) return;
//        hanoi(num - 1, from, other, to);
//        System.out.println("num : " + num + " - " + from + "에서 " +  to + "로 옮긴다.");
//        hanoi(num - 1, other, to, from);
//    }

    // 원반 갯수, 첫번째 출발 기둥, 두번째 기둥(나머지 기둥), 세번째 목적지 기둥
    public static void hanoi2(int num, int first, int rest, int end) throws IOException {
        if(num == 0) {
            return;
        }
        hanoi2(num - 1, first, end, rest);
        bw.write(first + " " + end);
        hanoi2(num - 1, rest, first, end);
    }

    public static int 최대공약수(int x, int y) {
        if(y == 0) return x;
        return 최대공약수(y, x % y);
    }

    public static int gcd_array(int[] a) {

        int result = -1;
        for(int i=0 ; i<a.length - 1 ; i++) {
            result = 최대공약수(a[i], a[i+1]);
        }
        return result;
    }

    public static void test() {
        int abs = 2;
        int[] H = {5,3,5,1,2,4};
        int[] left = new int[abs + 1];
        int[] right = new int[H.length - left.length];
        System.arraycopy(H, 0, left, 0, left.length);
        System.arraycopy(H, abs+1, right, 0, right.length);
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int leftResult = Arrays.stream(left).max().getAsInt() * left.length;
        int rightResult = Arrays.stream(right).max().getAsInt() * right.length;
    }

    // 유클리드 호제법을 이용한 최대공약수 구하기
    public static int 최대공약수2(int x, int y) {
        int a;
        if(x > y) {
            a = x % y;
        } else {
            a = y % x;
        }
        if(a == 0) return y;
        else return 최대공약수(Math.min(x, y), a);
    }
}
