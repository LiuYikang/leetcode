/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        PriorityQueue<ListNode> q = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (ListNode node : lists) {
            if (node != null) {
                q.add(node);
            }
        }

        while (!q.isEmpty()) {
            pre.next = q.poll();
            pre = pre.next;
            if (pre.next != null) {
                q.add(pre.next);
            }
        }
        return dummy.next;
    }
}