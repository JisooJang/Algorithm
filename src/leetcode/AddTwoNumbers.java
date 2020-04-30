package leetcode;

/*
https://leetcode.com/problems/add-two-numbers/

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0); // 리턴할 루트 노드
        ListNode tmp = root; // 기준 노드
        boolean flag = false; // 합이 10이 넘는지의 여부
        int sum = 0;
        int sum2 = 0;

        while(l1 != null || l2 != null) {
            if(l1 != null && l2 != null) {
                sum = flag? (l1.val + l2.val + 1) : (l1.val + l2.val);
                if(sum >= 10) {
                    sum = sum % 10;
                    flag = true;
                } else {
                    flag = false;
                }
                sum2 = sum;

                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1 != null) {
                sum2 = flag? l1.val + 1 : l1.val;
                if(sum2 >= 10) {
                    sum2 = sum2 % 10;
                    flag = true;
                } else {
                    flag = false;
                }
                l1 = l1.next;
            } else {
                sum2 = flag? l2.val + 1 : l2.val;
                if(sum2 >= 10) {
                    sum2 = sum2 % 10;
                    flag = true;
                } else {
                    flag = false;
                }
                l2 = l2.next;
            }

            tmp.val = sum2;

            if(l1 != null || l2 != null) {
                tmp.next = new ListNode(0);  // 다음 노드값에 추가
                tmp = tmp.next;  // 기준노드를 다음 노드로 이동
            } else {
                if(flag) {
                    tmp.next = new ListNode(1);
                    break;
                }
            }
        }

        return root;

    }
}
