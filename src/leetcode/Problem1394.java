package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/find-lucky-integer-in-an-array/
Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.

Example 1:

Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 */
public class Problem1394 {
    public int findLucky(int[] arr) { // arr이 정렬이 안되어있는 버전
        Map<Integer, Integer> result = new HashMap<Integer, Integer>();

        for(int i=0 ; i<arr.length ; i++) {
            if(result.containsKey(arr[i])) {
                result.replace(arr[i], result.get(arr[i]) + 1);  // 키가 존재하면 count value를 기존값에서 1 증가시킨다.
            } else {
                result.put(arr[i], 1);  // 키가 존재하지 않으면 기본 count value를 기본값 1로 저장시킨다.
            }
        }

        int result_key = -1;
        for(int key : result.keySet()) {
            int value = result.get(key);
            if(key == value) {
                result_key = key;
            }
        }

        return result_key;
    }

    public int findLucky2(int[] arr) { // arr이 정렬 되어있는 버전
        int target = arr[0];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int count = 1;
        for(int i=0 ; i<arr.length-1 ; i++) {
            if(arr[i] == arr[i+1]) {
                count++;
                if(i == arr.length-2) {
                    map.put(target, count);
                    System.out.println(target + ":" + count);
                }
            } else {
                map.put(target, count);
                System.out.println(target + ":" + count);
                target = arr[i+1];
                count = 1;
            }
        }

        int result_key = -1;
        for(int key : map.keySet()) {
            int value = map.get(key);
            if(key == value) {
                result_key = key;
            }
        }

        return result_key;

    }
}
