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
    int kthSmallest(TreeNode* root, int k) {
        stack<TreeNode*> s;
        TreeNode *node = root;
        while(node)
        {
            s.push(node);
            node = node->left;
        }
        int i = 0;
        int ans;
        while(!s.empty() && i < k)
        {
            node = s.top();
            ans = node->val;
            s.pop();
            i++;
            if(node->right)
            {
                node = node->right;
                while(node)
                {
                    s.push(node);
                    node = node->left;
                }
            }
        }
        return ans;
    }
};