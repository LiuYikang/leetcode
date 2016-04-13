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
    ListNode* partition(ListNode* head, int x) {
        if (head == NULL)
        {
            return head;
        }
        ListNode dummy1(0), dummy2(0);
        ListNode* p1 = &dummy1;
        ListNode* p2 = &dummy2;

        ListNode* p = head;
        while(p) {
            if(p->val < x) 
            {
                p1->next = p;
                p1 = p1->next;
            } 
            else 
            {
                p2->next = p;
                p2 = p2->next;
            }
            p = p->next;
        }

        p2->next = NULL;
        p1->next = dummy2.next;
        return dummy1.next;
    }
};