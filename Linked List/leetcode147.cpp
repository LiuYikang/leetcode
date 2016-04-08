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
    ListNode* insertionSortList(ListNode* head) {
        if (head == NULL || head->next == NULL)
        {
            return head;
        }
        ListNode *node = head;
        ListNode start(0);
        ListNode *preLoc;
        ListNode *tmp;
        while (node)
        {
            preLoc = &start;
            while(preLoc->next != NULL && preLoc->next->val <= node->val)
            {
                preLoc = preLoc->next;
            }
            tmp = preLoc->next;
            preLoc->next = node;
            node = node->next;
            preLoc->next->next = tmp;
        }
        return start.next;
    }
};