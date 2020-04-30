package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/lucky-numbers-in-a-matrix/
Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
A lucky number is an element of the matrix such that it is the minimum element in its row and maximum in its column.

Example 1:

Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
Output: [15]
Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 */
public class Problem1380 {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0 ; i<matrix.length ; i++) {
            int min = matrix[i][0];
            int min_index = 0;
            for(int j=1 ; j<matrix[i].length ; j++) {
                if(min > matrix[i][j]) {
                    min = matrix[i][j];
                    min_index = j;
                }
            }

            int max = matrix[0][min_index];
            for(int k=1 ; k<matrix.length ; k++) {
                if(max < matrix[k][min_index]) {
                    max = matrix[k][min_index];
                }
            }

            if(max == min) {
                result.add(max);
            }
        }

        return result;
    }
}
