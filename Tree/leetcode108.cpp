/**
 * Solution:
 * Recursion
 * The array is sorted, so the element in the middle of the array must be the root of the BST.
 * We can find the root of left child tree and the root of right child tree by using the recursion.
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
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        return BuildTree(nums, 0, nums.size());
    }
    
    TreeNode* BuildTree(vector<int>& nums, int low, int high)
    {
        if (low >= high)
        {
            return NULL;
        }
        int mid = (low+high) / 2;
        TreeNode *root = new TreeNode(nums[mid]);
        root->left = BuildTree(nums, low, mid);
        root->right = BuildTree(nums, mid+1, high);
        return root;
    }
};