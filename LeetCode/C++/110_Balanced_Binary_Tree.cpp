//110. Balanced Binary Tree
/*
Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Tag: Tree, Depth-first Search

Author: Xinyu Liu
*/

#include <iostream>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode* root){
        if (!root)
            return true;
        if(!isBalanced (root->left) || !isBalanced (root->right)) return false;
        if (abs(maxdepth(root->left) - maxdepth(root->right)) > 1)
            return false;
        return true;
    }
    int maxdepth(TreeNode* root){
        if (!root)
            return 0;
        int dmax, lmax, rmax;
        lmax = maxdepth(root->left);
        rmax = maxdepth(root->right);
        dmax = 1 + max(lmax, rmax);
        return dmax;
    }
};

void main()
{
    TreeNode n1(1), n2(2), n3(3);
    n1.left = &n2;
    n2.right = &n3;
    Solution sol;
    bool b = sol.isBalanced(&n1);
}
