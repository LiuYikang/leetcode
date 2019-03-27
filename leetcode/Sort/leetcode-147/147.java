/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode ret = new ListNode(0);

        ListNode cur = head;

        while (cur != null) {
            ListNode tmp = cur.next;
            insertList(cur, ret);
            cur = tmp;
        }

        return ret.next;
    }

    public void insertList(ListNode node, ListNode pre) {
        ListNode head = pre.next;
        while (head != null && node.val > head.val) {
            pre = head;
            head = head.next;
        }
        pre.next = node;
        node.next = head;
    }
}