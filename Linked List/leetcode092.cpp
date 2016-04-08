/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        if (head == NULL)
        {
            return head;
        }
        ListNode preHead(0);
        preHead.next = head;
        ListNode *revPreHead = &preHead;
        ListNode *revHead;
        
        n = n - m + 1;
        
        while(m > 1)
        {
            if(revPreHead == NULL)
            {
                return head;
            }
            revPreHead = revPreHead->next;
            m--;
        }
        revHead = revPreHead->next;
        
        ListNode *tmp;
        ListNode *revTail = revHead;
        while(n > 0)
        {
            if(revHead == NULL)
            {
                return head;
            }
            tmp = revHead->next;
            revHead->next = revPreHead->next;
            revPreHead->next = revHead;
            revHead = tmp;
            n--;
        }
        revTail->next = revHead;
        
        return preHead.next;
    }
};