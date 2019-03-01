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
    ListNode* oddEvenList(ListNode* head) {
        if (head == NULL)
        {
            return head;
        }
        ListNode ret(0);
        ret.next = head;
        ListNode *node = head->next;
        ListNode *preNode = head;
        ListNode *tmp;
        int i = 2;
        while (node)
        {
            if(i % 2 == 0)
            {
                node = node->next;
                preNode = preNode->next;
            }
            else
            {
                tmp = node;
                preNode->next = node->next;
                node = node->next;
                
                tmp->next = head->next;
                head->next = tmp;
                head = tmp;
            }
            i++;
        }
        return ret.next;
    }
};