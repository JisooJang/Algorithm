package codility;

import java.util.*;

// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/start/
public class GenomicRangeQuery {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution3("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }

    // O(N*M) => 60점
    public static int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        Map<Character, Integer> dna = new HashMap<>();
        dna.put('A', 1);
        dna.put('C', 2);
        dna.put('G', 3);
        dna.put('T', 4);

        if (P.length == 0) {
            return null;
        }

        int[] score = new int[S.length()];
        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            String substr = S.substring(P[i], Q[i] + 1);
            result[i] = dna.get(substr.charAt(0));
            for (int j = 1; j < substr.length(); j++) {
                result[i] = Math.min(result[i], dna.get(substr.charAt(j)));
            }
        }

        return result;
    }

    // O(N*M) => 75점
    public static int[] solution2(String S, int[] P, int[] Q) {
        if (P.length == 0) {
            return null;
        }

        Map<Character, Integer> dna = new HashMap<>();
        dna.put('A', 1);
        dna.put('C', 2);
        dna.put('G', 3);
        dna.put('T', 4);

        // candidate map에 index, score 쌍으로 값을 넣음.
        Map<Integer, Integer> candidate = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            candidate.put(i, dna.get(S.charAt(i)));
        }

        // candidate 값을 value 기반으로 정렬
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(candidate.entrySet());
        list.sort(Map.Entry.comparingByValue());

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int min = P[i];
            int max = Q[i];
            for (Map.Entry<Integer, Integer> entry : list) {
                int key = entry.getKey();
                if (min <= key && max >= key) {
                    result[i] = entry.getValue();
                    break;
                }
            }
        }
        return result;
    }
    // O(N*M) => 60점
    public static int[] solution3(String S, int[] P, int[] Q) {
        if (P.length == 0) {
            return null;
        }

        int[] result = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            String subStr = S.substring(P[i], Q[i] + 1);
            if (subStr.contains("A")) {
                result[i] = 1;
            } else if (subStr.contains("C")) {
                result[i] = 2;
            } else if (subStr.contains("G")) {
                result[i] = 3;
            } else {
                result[i] = 4;
            }
        }

        return result;
    }
}
