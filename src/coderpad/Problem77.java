package coderpad;

public class Problem77 {
    public static void main(String[] args) {
        /*
        https://github.com/xissy/coderpad-interviews/tree/master/p77
        중첩될 수 있는 인터벌들을 갖는 리스트가 있습니다. 중첩되는 인터벌들을 하나로 합친 새로운 리스트를 반환하세요.
        입력 리스트는 정렬되어 있지 않습니다.
        예를 들어, [(1, 3), (5, 8), (4, 10), (20, 25)] 가 주어지면, [(1, 3), (4, 10), (20, 25)] 를 반환해야 합니다.
         */

        int[][] a = {{1, 3}, {5, 8}, {4, 10}, {20, 25}};
        //int[][] a = {{1, 3}, {5, 12}, {4, 10}, {20, 25}};  // test case 2
        //int[][] a = {{1, 3}, {5, 20}, {4, 10}, {20, 25}};  // test case 3

        int[][] result = test(a);
        for(int[] b : result) {
            System.out.print("(" + b[0] + ", " + b[1] + ")");
        }
    }

    public static int[][] test(int[][] arr) {
        int length = arr.length;

        for (int i = 0; i < arr.length; i++) {
            int targetMin = arr[i][0];
            int targetMax = arr[i][1];
            int min = targetMin, max = targetMax;
            for (int j = 0; j < arr.length; j++) {
                if (i == j) {
                    // 인덱스가 같으면 같은 원소이므로 비교할 필요가 없다.
                    continue;
                }

                // 비교대상의 첫번째 원소가, 다른 원소들의 첫쩨값보다 크거나 같고, 둘째값보다 작거나 클 때  (= 범위에 포함될 때)
                if (targetMin >= arr[j][0] && targetMin <= arr[j][1]) { //exchange
                    min = arr[j][0];
                    if (targetMax >= arr[j][1]) {
                        max = targetMax;
                    } else {
                        max = arr[j][1];
                    }
                    //System.out.println(min + ", " + max);
                    arr[i][0] = min;
                    arr[i][1] = max;

                    // 교환한내용을 체크표시. (결과 배열에 저장하지 않을 값)
                    arr[j][0] = -1;
                    arr[j][1] = -1;

                    length--;
                }
            }
        }

        int[][] result = new int[length][2];
        int i = 0;
        for (int[] ints : arr) {
            if (ints[0] != -1) {
                result[i++] = new int[]{ints[0], ints[1]};
            }
        }

        return result;
    }
}
