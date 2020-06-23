package common;

import java.util.Arrays;

/*
퀵 정렬: 평균적인 상황에서 최고의 성능 : O(NlogN)
아래 코드의 경우 피벗을 배열의 중간 위치 값을 사용
unstable sort : 동일 값을 같는 원소의 순서가 변할 수 있음.
최악의 경우 O(N^2) : 피벗을 계속 해서 최솟값이나 최댓값으로 잡게 되는 경우
Java의 Arrays.sort()에서 퀵 정렬을 사용한다.
 */
public class QuickSort {
    public static void main(String[] args) {
        String a = "111";
        int b = Integer.parseInt(a);
        for(int i=0 ; i<a.length() ; i++) {

        }
        int[] arr = {20, 18, 50, 40, 9, 19, 5, 25};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if(arr == null || arr.length == 0) return;
        int pivot = arr[(left + right) / 2]; // 가운데 요소 선택
        int pLeft = left, pRight = right;

        // pLeft index와 pRight 인덱스가 같아지면 반복을 종료
        while(pLeft < pRight) {
            // left가 pivot보다 작을 때까지 증가시킴. -> 피봇보다 크거나 같을때 left가 증가를 멈춤.
            while(arr[pLeft] < pivot) pLeft++;
            // right가 pivot보다 클 때까지 감소시킴. -> 피봇보다 작거나 같을때 right가 감소를 멈춤.
            while(arr[pRight] > pivot) pRight--;
            // left, right 요소를 교환한다.
            if(pLeft <= pRight) {
                swap(arr, pLeft, pRight);
                pLeft++; pRight--;
            }
        }
        if(left < pLeft) sort(arr, left, pRight);
        if(pLeft < right) sort(arr, pLeft, right);
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
