/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode p = head;
        ListNode tmp;
        while (p != null) {
            tmp = p.next;
            p.next = dummy.next;
            dummy.next = p;
            p = tmp;
        }
        return dummy.next;
    }
}