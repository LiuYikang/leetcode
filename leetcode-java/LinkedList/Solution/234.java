/**
 *
 *  234. Palindrome Linked List

Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
Follow up:
Could you do it in O(n) time and O(1) space?
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        int half = len / 2;
        boolean odd = len % 2 == 0 ? false : true;

        ListNode preHead = new ListNode(0);
        p = head;
        for (int i = 0; i < half; i++) {
            ListNode tmp = p.next;
            p.next = preHead.next;
            preHead.next = p;
            p = tmp;
        }

        if (odd) {
            p = p.next;
        }

        return compareList(p, preHead.next);
    }

    private boolean compareList(ListNode p, ListNode q) {
        while (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }

        if (p != null || q != null) {
            return false;
        }

        return true;
    }
}