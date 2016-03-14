//226. Invert Binary Tree
/*
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

Tag: Tree

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
    TreeNode* invertTree(TreeNode* root) {
        if (root == NULL)
            return root;
        TreeNode* temp = root->left;
        root->left = root->right;
        root->right = temp;
        invertTree(root->left);
        invertTree(root->right);
        return root;

    }
};

void main()
{
    TreeNode n1(1),n2(2),n3(3),n4(4),n5(5);
    n1.left = &n2;
    n1.right = &n3;
    n2.left = &n4;
    n3.right = &n5;
    Solution sol;
    TreeNode*  n = sol.invertTree(&n1);
}
