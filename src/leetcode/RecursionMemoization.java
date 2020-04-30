package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/explore/featured/card/recursion-i/255/recursion-memoization/1662/
https://www.interviewcake.com/concept/java/memoization
 */
public class RecursionMemoization {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }

        if(memo.containsKey(n)) {
            return memo.get(n);
        }

        int result = climbStairs(n-1) + climbStairs(n-2);
        memo.put(n, result);

        return result;
    }
}
