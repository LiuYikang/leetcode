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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
      if(postorder.size() == 0 || inorder.size() == 0)
        {
            return NULL;
        }
        return Build(postorder, inorder, 0, postorder.size()-1, 0, inorder.size()-1);
    }
    
    TreeNode* Build(vector<int>& postorder, vector<int>& inorder, int ps, int pe, int is, int ie)
    {
        if(ps > pe || is > ie)
        {
            return NULL;
        }
        TreeNode *root = new TreeNode(postorder[pe]);
        int rootloc;
        for (int i = is; i <= ie; i++)
        {
            if(inorder[i] == postorder[pe])
            {
                rootloc = i;
            }
        }
        int len = rootloc - is;
        root->left = Build(postorder, inorder, ps, ps+len-1, is, rootloc-1);
        root->right = Build(postorder, inorder, ps+len, pe-1, rootloc+1, ie);
        return root;
    }
};