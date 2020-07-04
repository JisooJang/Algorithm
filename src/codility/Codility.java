package codility;

import java.util.*;

// https://app.codility.com/c/run/cert35KXBM-FMNA47ZE4Y5WVFPT/
class Codility {
    public static void main(String[] args) {
        /*
        [3,1,4]
[5,3,2,4]
[5,3,5,2,1]
[7,7,3,7,7]
[1,1,7,6,6,6]
[1,3,5,7]
[5,4,1,1,4,5,8,6]
[5,4,1,2,5]
[7,6,6,6,6,7]
[1]
         */
        System.out.println(solution(new int[]{3, 1, 4})); // 10
        System.out.println(solution(new int[]{5, 3, 2, 4})); // 17
        System.out.println(solution(new int[]{5, 3, 5, 2, 1})); // 19
        System.out.println(solution(new int[]{7, 7, 3, 7, 7})); // 35
        System.out.println(solution(new int[]{1,1,7,6,6,6})); // 30
        System.out.println(solution(new int[]{1,3,5,7})); // 22
        System.out.println(solution(new int[]{5,4,1,1,4,5,8,6})); // 46
        System.out.println(solution(new int[]{5,4,1,2,5})); // 25
        System.out.println(solution(new int[]{7,6,6,6,6,7})); // 42
        System.out.println(solution(new int[]{1})); // 1


    }
    public static int solution(int[] H) {
        // write your code in Java SE 8
        int size = H.length;
        int[] abs = new int[size - 1]; // H들 사이의 차이값
        if(size == 1) return H[0];

        // 빌딩 간 차이 절대값 저장
        for(int i=0 ; i<size-1 ; i++) {
            abs[i] = Math.abs(H[i] - H[i+1]);
        }

        // 건물의 최댓값과 빌딩 간 차이 절대값들의 최댓값을 구함
//        int Hmax = H[0];
//        for(int i=1 ; i<size ; i++) {
//            if(H[i] > Hmax) Hmax = H[i];
//        }
        int absMax = abs[0];
        for(int i=1 ; i<size-1 ; i++) {
            if(abs[i] > absMax) absMax = abs[i];
        }

        List<Integer> maxAbsIndex = new ArrayList<>();
        for(int i=0 ; i<size-1 ; i++) {
            if(abs[i] == absMax) maxAbsIndex.add(i);
        }

        int[] left = null;
        int[] right = null;

        // abs 값중 최대값을 기준으로 잘라서 배열을 두그룹으로 나눔.
        // 최댓값이 여러개일 경우 H[i] 또는 H[i+1]값이 더 큰 값 (같으면 아무거나)
        Map<Integer, Integer> check = new HashMap<>();
        for(int i=0 ; i<maxAbsIndex.size(); i++) {
            int absIndex = maxAbsIndex.get(i);
//            if(H[absIndex] == Hmax || H[absIndex+1] == Hmax) {
//                left = new int[absIndex + 1];
//                right = new int[H.length - left.length];
//                System.arraycopy(H, 0, left, 0, left.length);
//                System.arraycopy(H, absIndex + 1, right, 0, right.length);
//            }
            check.put(absIndex, Math.max(H[absIndex], H[absIndex + 1]));
        }

        // 각 그룹에서 최댓값을 찾은뒤 * n한후 더함.
        assert left != null;
        int leftResult = Arrays.stream(left).max().getAsInt() * left.length;
        int rightResult = Arrays.stream(right).max().getAsInt() * right.length;

        //return Math.min(oneBannerResult, leftResult + rightResult);
        return leftResult + rightResult;
    }
}

