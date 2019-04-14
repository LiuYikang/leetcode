/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        int tmp = 0;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + tmp;
            tmp = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int sum = l1.val + tmp;
            tmp = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = pre.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + tmp;
            tmp = sum / 10;
            sum %= 10;
            ListNode node = new ListNode(sum);
            pre.next = node;
            pre = pre.next;
            l2 = l2.next;
        }

        if (tmp != 0) {
            ListNode node = new ListNode(tmp);
            pre.next = node;
        }

        return dummy.next;
    }
}