/**
 * Solution One
 * recursion
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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0 || inorder.size() == 0)
        {
            return NULL;
        }
        return Build(preorder, inorder, 0, preorder.size()-1, 0, inorder.size()-1);
    }
    
    TreeNode* Build(vector<int>& preorder, vector<int>& inorder, int ps, int pe, int is, int ie)
    {
        if(ps > pe || is > ie)
        {
            return NULL;
        }
        TreeNode *root = new TreeNode(preorder[ps]);
        int rootloc;
        for (int i = is; i <= ie; i++)
        {
            if(inorder[i] == preorder[ps])
            {
                rootloc = i;
            }
        }
        int len = rootloc - is;
        root->left = Build(preorder, inorder, ps+1, ps+len, is, rootloc-1);
        root->right = Build(preorder, inorder, ps+len+1, pe, rootloc+1, ie);
        return root;
    }
};