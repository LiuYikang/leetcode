/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        int l1 = 0, l2 = 0;
        ListNode tmp = headA;
        while (tmp != null) {
            l1++;
            tmp = tmp.next;
        }
        tmp = headB;
        while (tmp != null) {
            l2++;
            tmp = tmp.next;
        }

        while (l1 < l2) {
            headB = headB.next;
            l2--;
        }
        while (l1 > l2) {
            headA = headA.next;
            l1--;
        }

        while (headA != headB && headA != null && headB != null) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}