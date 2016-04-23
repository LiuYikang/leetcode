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
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> ret;
        if(root == NULL)
        {
            return ret;
        }
        stack<TreeNode*> s;
        TreeNode *node = root;
        while(node)
        {
            s.push(node);
            node = node->left;
        }
        while(!s.empty())
        {
            node = s.top();
            s.pop();
            ret.push_back(node->val);
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
        return ret;
    }
};