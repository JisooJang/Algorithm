package leetcode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
https://leetcode.com/problems/create-target-array-in-the-given-order/
Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]
Explanation:
nums       index     target
0            0        [0]
1            1        [0,1]
2            2        [0,1,2]
3            2        [0,1,3,2]
4            1        [0,4,1,3,2]
 */
public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new LinkedList<Integer>();

        for(int i=0 ; i<nums.length ; i++) {
            list.add(index[i], nums[i]);
        }

        int[] target = new int[nums.length];
        Iterator<Integer> iter = list.iterator();

        int i = 0;
        while(iter.hasNext()) {
            int elements = iter.next();
            target[i] = elements;
            i++;
        }
        return target;
    }
}
