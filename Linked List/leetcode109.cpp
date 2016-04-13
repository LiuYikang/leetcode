/**
 * Solution 
 * Same as leetcode108
 * Use two point to find the middle node of list
 */


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        return BuildTree(head, NULL);
    }
    
    TreeNode* BuildTree(ListNode* head, ListNode* end)
    {
        if (head == end)
        {
            return NULL;
        }
        ListNode *fast = head;
        ListNode *slow = head;
        while(fast != end && fast->next != end)
        {
            slow = slow->next;
            fast = fast->next->next;
        }
        TreeNode *root = new TreeNode(slow->val);
        root->left = BuildTree(head, slow);
        root->right = BuildTree(slow->next, end);
        
        return root;
    }
};