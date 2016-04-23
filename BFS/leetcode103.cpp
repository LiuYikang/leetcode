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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        deque<TreeNode*> q;
        vector<vector<int>> ret;
        if(root == NULL)
        {
            return ret;
        }
        q.push_back(root);
        int iszig=1;
        while(!q.empty())
        {
            TreeNode* tmp;
            vector<int> ans;
            iszig ^= 1;
            int size = q.size();
            while(size--)
            {
                if(iszig)
                {
                    tmp = q.front();
                    if(tmp != NULL)
                    ans.push_back(tmp->val);
                    if(tmp->right)q.push_back(tmp->right);
                    if(tmp->left)q.push_back(tmp->left);
                    q.pop_front();
                }
                if(!iszig)
                {
                    tmp = q.back();
                    if(tmp != NULL)
                    ans.push_back(tmp->val);
                    if(tmp->left)q.push_front(tmp->left);
                    if(tmp->right)q.push_front(tmp->right);
                    
                    q.pop_back();
                }
            }
            ret.push_back(ans);
        }
        return ret;
    }
};