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
    ListNode* reverseList(ListNode* head)
    {
        if(head == NULL)
        {
            return head;
        }
        ListNode ret(0);
        ListNode *tmp;
        while(head)
        {
            tmp = head->next;
            head->next = ret.next;
            ret.next = head;
            head = tmp;
        }
        return ret.next;
    }
    
    void reorderList(ListNode* head) {
        if(head == NULL)
        {
            return;
        }
        int length = 0;
        ListNode ret(0);
        ListNode *half;
        ListNode *tmp;
        ret.next = head;
        while(head)
        {
            length++;
            head = head->next;
        }
        length = length % 2 ? length/2 + 1 : length/2;
        half = ret.next;
        head = &ret;
        for(int i = 0; i < length; i++)
        {
            head = head->next;
            half = half->next;
        }
        half = reverseList(half);
        head->next = NULL;
        head = ret.next;
        
        while(head && half)
        {
            tmp = half->next;
            half->next = head->next;
            head->next = half;
            head = half->next;
            half = tmp;
        }
        return;
    }
    
    
};