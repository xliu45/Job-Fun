/**
 * 98. Validate Binary Search Tree

 * Given a binary tree, determine if it is a valid binary search tree (BST).
 
 * Tag: Deep First Search
 
 * Author : Dawei Li
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
    bool isValidBST(TreeNode* root) {
        
        long long Cur = LLONG_MIN;
        
        return getValidBSTMax( root, Cur );
        
    }
    
private:

    bool getValidBSTMax( TreeNode* root, long long& Cur )
    {
        if( root )
        {
            bool statusL = getValidBSTMax( root->left, Cur );
            
            if( statusL == false || (root->val <= Cur) )
            {
                return false;
            }
            else
            {
                Cur = root->val;
            }
            
            return getValidBSTMax( root->right, Cur );
            
        }
        return true;
    }
};
