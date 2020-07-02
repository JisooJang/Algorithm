package common;

public class RecursionTest {
    public static void main(String[] args) {
        printInBinary(24);
        System.out.println(sum(8, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
        System.out.println(findMax(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 7));
        System.out.println(findMax2(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 0, 7));
        System.out.println(binarySearch(new String[]{"aaa", "bbb", "ccc", "ddd", "eee"}, "ffff", 0, 4));
        System.out.println(binarySearch(new String[]{"aaa", "bbb", "ccc", "ddd", "eee"}, "11", 0, 4));
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
}
