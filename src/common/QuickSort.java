package common;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {20, 18, 50, 40, 9, 19, 5, 25};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int left, int right) {
        if(arr == null || arr.length == 0) return;
        int pivot = arr[(left + right) / 2]; // 가운데 요소 선택
        int pLeft = left, pRight = right;

        while(pLeft <= pRight) {
            // left가 pivot보다 작을 때까지 증가시킴. -> 피봇보다 클때 left가 증가를 멈춤.
            while(arr[pLeft] < pivot) pLeft++;
            // right가 pivot보다 클 때까지 증가시킴. -> 피봇보다 작을때 right 증가를 멈춤.
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
