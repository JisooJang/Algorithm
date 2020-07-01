package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class Problem1431 {
    public static void main(String[] args) {
        System.out.println(kidsWithCandies(new int[]{2,3,5,1,3}, 3));
        System.out.println(kidsWithCandies(new int[]{4,2,1,1,2}, 1));
        System.out.println(kidsWithCandies(new int[]{12,1,12}, 10));
    }
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if(candies.length == 0) return null;
        List<Boolean> result = new ArrayList<>(candies.length);
        // max값은 무조건 true.
        int max = candies[0];
        // O(N)
        for(int candy : candies) {
            if(candy > max) max = candy;
        }
        // O(N)
        for (int candy : candies) {
            if (candy == max) {
                result.add(true);
            } else {
                int sum = candy + extraCandies;
                result.add(sum >= max);
            }
        }

        // 최종 : O(2N) -> O(N)
        return result;
    }
}
