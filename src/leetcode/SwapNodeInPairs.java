package leetcode;

public class SwapNodeInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
 }

    public ListNode swapPairs(ListNode head) {
        ListNode head_tmp = head;
        while(head != null && head.next != null) {
            int tmp = head.val;
            head.val = head.next.val;
            head.next.val = tmp;

            head = head.next.next;
        }

        return head_tmp;
    }
}
