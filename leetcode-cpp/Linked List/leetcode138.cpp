/**
 * Definition for singly-linked list with a random pointer.
 * struct RandomListNode {
 *     int label;
 *     RandomListNode *next, *random;
 *     RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
 * };
 */

/**************************************************/
 /*Solution One
 Use a hashmap to record the random point relationship
 */
/**************************************************/
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head == NULL)
        {
            return head;
        }
        map<RandomListNode*, RandomListNode*> m;
        RandomListNode *ret = new RandomListNode(0);
        RandomListNode *n = ret;
        while(head)
        {
            RandomListNode *tmp = new RandomListNode(head->label);
            n->next = tmp;
            n = tmp;
            tmp->random = head->random;
            
            m[head] = n;
            
            head = head->next;
        }
        n->next = NULL;
        
        head = ret->next;
        while(head)
        {
            if(head->random)
            {
                head->random = m[head->random];
            }
            head = head->next;
        }
        return ret->next;
    }
};


/**********************************************/
/*Solution Two
Copy node and link behand the original node,like
A->A'->B->B'->C->C'.....
Then the copy node random point can change to the next of the original node random point node.
At last, break the list.
*/
/**********************************************/
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if(head == NULL)
        {
            return head;
        }
        RandomListNode *h = head;
        RandomListNode *ret = new RandomListNode(0);
        while(h)
        {
            RandomListNode *tmp = new RandomListNode(h->label);
            tmp->random = h->random;
            tmp->next = h->next;
            h->next = tmp;
            h = tmp->next;
        }
        h = head->next;
        while(h)
        {
            if(h->random != NULL)
            {
                h->random = h->random->next;
            }
            if(!h->next)
            {
                break;
            }
            h = h->next->next;
        }
        h = head;
        RandomListNode *p = ret;
        RandomListNode *n;
        while(h)
        {
            n = h->next;
            p->next = n;
            p = p->next;
            h->next = n->next;
            h = h->next;
        }
        return ret->next;
    }
};