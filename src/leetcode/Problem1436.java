package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/destination-city/
 */
public class Problem1436 {
    public static void main(String[] args) {
        String[][] tmp = {{"B","C"},{"D","B"},{"C","A"}};
        List<List<String>> paths = new ArrayList<>();
        for(String[] e : tmp) {
            paths.add(Arrays.asList(e));
        }

        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        boolean chk;
        // 풀이 : 각 리스트의 마지막 원소를 기준으로, 다른 리스트들의 첫번째 원소가 마지막 원소와 같은 값이 존재하면 마지막 destincation 값이 아님.
        // 즉 다른 리스트들의 첫번쨰 원소가 기준 리스트의 마지막 원소랑 겹치는 값이 없으면 destination
        for(int i=0 ; i<paths.size() ; i++) {
            chk = false;
            String lastElement = paths.get(i).get(1);
            for(int j=0 ; j<paths.size() ; j++) {
                if(i == j) continue;
                String firstElement = paths.get(j).get(0);
                if(lastElement.equals(firstElement)) {
                    chk = true;
                    break;
                }
            }
            if(!chk) return lastElement;
        }
        return null;
    }
}