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
    vector<int> preorderTraversal(TreeNode* root) {
        vector<int> preorder;
        if(root == NULL) return preorder;
        stack<TreeNode*> s;
        TreeNode *p = root;
        while(p)
        {
            preorder.push_back(p->val);
            s.push(p);
            p = p->left;
        }
        while(!s.empty())
        {
            TreeNode *tmp = s.top();
            s.pop();
            if(tmp->right)
            {
                TreeNode *t = tmp->right;
                preorder.push_back(t->val);
                s.push(t);
                while(t->left)
                {
                    t = t->left;
                    preorder.push_back(t->val);
                    s.push(t);
                }
            }
        }
        return preorder;
    }
};