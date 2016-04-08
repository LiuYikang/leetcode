/*
my solution is like this: using two pointers, one of them one step at a time. 
another pointer each take two steps. 
Suppose the first meet at step k,the length of the Cycle is r. so..2k-k=nr,k=nr 
Now, the distance between the start node of list and the start node of cycle is s. 
the distance between the start of list and the first meeting node is k(the pointer which wake one step at a time waked k steps).
the distance between the start node of cycle and the first meeting node is m, so...s=k-m, s=nr-m=(n-1)r+(r-m),here we takes n = 1..
so, using one pointer start from the start node of list, another pointer start from the first meeting node, 
all of them wake one step at a time, 
the first time they meeting each other is the start of the cycle.
*/

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
    ListNode *detectCycle(ListNode *head) {
        ListNode *oneP = head;
        ListNode *twoP = head;
        
        bool isCycle = false;
        
        while(oneP && twoP && twoP->next)
        {
            oneP = oneP->next;
            twoP = twoP->next->next;
            if(oneP == twoP)
            {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
        {
            return NULL;
        }
        oneP = head;
        while (oneP != twoP)
        {
            oneP = oneP->next;
            twoP = twoP->next;
        }
        return oneP;
    }
};