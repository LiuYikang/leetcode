/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy, loc = head;
        while (loc != null) {
            if (loc.val == val) {
                pre.next = loc.next;
                loc = loc.next;
            } else {
                pre = pre.next;
                loc = loc.next;
            }
        }
        return dummy.next;
    }
}