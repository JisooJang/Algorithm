package leetcode;

import java.util.*;

// https://leetcode.com/problems/number-of-good-pairs/submissions/
public class Problem1512 {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs2(new int[]{1,2,3,1,1,3}));
    }
    // O(N^2)
    public int numIdenticalPairs1(int[] nums) {
        int count = 0;
        for(int i=0 ; i< nums.length ; i++) {
            for(int j=0 ; j<nums.length ; j++) {
                if(i == j) continue;
                if(nums[i] == nums[j] && i < j) count++;
            }
        }
        return count;
    }

    /*
    1. (0,1) (1,2) (2,3) (3,1) (4,1) (5,3)  -> key : index, value : value
       => sort by value
       (0,1)(3,1)(4,1)  / (1,2) / (2,3)(5,3)
     */
    public static int numIdenticalPairs2(int[] nums) {
        int result = 0;
        // 1. index - value 구조로 map에 넣는다.
        Map<Integer, Integer> indexValueMap = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            indexValueMap.put(i, nums[i]);
        }

        // 2. map.entry를 리스트에 담아 value 기준으로 오름차순  (map 자체는 sorting 지원이없어서 list로 변환)
        List<Map.Entry<Integer, Integer>> indexValueList = new ArrayList<>(indexValueMap.entrySet());
        indexValueList.sort(Map.Entry.comparingByValue());

        // 3. List를 돌면서 value값이 같으면 count 증가
        int divCount = 1;

        for(int i=0 ; i<indexValueList.size() - 1 ; i++) {
            Map.Entry<Integer, Integer> entry1 = indexValueList.get(i);
            Map.Entry<Integer, Integer> entry2 = indexValueList.get(i+1);

            if(entry1.getValue().equals(entry2.getValue())) {
                divCount++;
            } else { // 다음 value 그룹으로 넘어왔을 때 result 계산
                if(divCount > 1) {
                    result += findCount(divCount);
                    divCount = 1;
                }
            }
        }
        if(divCount > 1) { // 배열 value값이 모두 같을 때 result 계산
            result += findCount(divCount);
        }
        return result;
    }

    /*
    2짝의 경우의 수 찾기
    (2,5) -> 경우의 수? (2개면 1개)
    2,5
    (0,3,4) -> 경우의 수? (3개면 3개) 2개일 때 값에서 +2
    0,3 / 0,4 / 3,4
    (1,2,3,4) -> 경우의 수? (4개면 6개) 3개일 때 값에서 + 3
    1,2 / 1,3 / 1,4 / 2,3 / 2,4 / 3,4

    (1,2,3,4,5) -> 경우의 수? (5개면 10개) 4개일 때 값에서 + 4
    1,2 / 1,3 / 1,4 / 1,5
    2,3 / 2,4 / 2,5
    3,4 / 3,5
    4,5
    4 + 3 + 2 + 1 = 10
    (n-1) + (n-2) + ... 1
     */
    public static int findCount(int num) {
        if(num <= 1) {
            return 0;
        } else if(num == 2) {
            return 1;
        } else {
            return findCount(num - 1) + num - 1;
        }
    }
}
