package leetcode;

import java.util.*;

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
        // O(n^)
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

    public static String destCity2(List<List<String>> path) {
        Map<String, Integer> countOfElements = new HashMap<>();

        // O(N)
        for (List<String> strings : path) {
            String element1 = strings.get(0);
            String element2 = strings.get(1);
            countOfElements.put(element1, countOfElements.getOrDefault(element1, 0) + 1);
            countOfElements.put(element2, countOfElements.getOrDefault(element2, 0) + 1);
        }

        // O(N)
        String[] candidates = new String[2];
        int i=0;
        for(Map.Entry<String, Integer> entry : countOfElements.entrySet()) {
            // start, dest가 아닌 원소들은 value들이 2로 저장되어있다. start, dest는 짝지어진 다른 원소가 없으므로 value가 1이다.
            if(entry.getValue() == 1) {
                candidates[i++] = entry.getKey();
            }
        }

        // start, dest가 저장되어있는 candidates 중 (인덱스가 1인 아이를 return) == dest
        for(List<String> strings : path) {
            int index1 = strings.indexOf(candidates[0]);
            int index2 = strings.indexOf(candidates[1]);
            if(index1 == 1) return candidates[0];
            if(index2 == 1) return candidates[1];
        }

        return null;
    }

    public static String destCity3(List<List<String>> path) {
        Map<String, Integer> indexOfCandidates = new HashMap<>();

        // O(N)
        for (List<String> strings : path) {
            String element1 = strings.get(0);
            String element2 = strings.get(1);
            if(!indexOfCandidates.containsKey(element1)) {
                indexOfCandidates.put(element1, 0); // start, dest 원소는 중복값이 없으므로 put이 한번만 실행. 여기서는 0 인덱스의 원소를 put 하므로 start값이 추가됨.
            } else {
                indexOfCandidates.remove(element1);
            }
            if(!indexOfCandidates.containsKey((element2))) {
                indexOfCandidates.put(element2, 1); // start, dest 원소는 중복값이 없으므로 put이 한번만 실행. 여기서는 1 인덱스의 원소를 put 하므로 dest값이 추가됨.
            } else {
                indexOfCandidates.remove(element2);
            }
        }

        // 2번 반복 => O(2) -> 상수시간
        for(Map.Entry<String, Integer> entry :  indexOfCandidates.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}