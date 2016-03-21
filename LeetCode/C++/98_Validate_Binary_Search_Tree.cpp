//98. Validate Binary Search Tree
/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Tag: Tree, Depth-first Search

Author: Xinyu Liu
*/

#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        if (!root)
            return true;
        TreeNode* pre(NULL);
        return getval(root, pre);
    }
    bool getval(TreeNode* root, TreeNode* &pre){
        if (!root)
            return true;
        if(!getval(root->left, pre)) return false;
        if(pre != NULL && root->val <= pre->val)
            return false;
        pre = root;
        if(!getval(root->right, pre)) return false;
        return true;
    }
};

void main(){
    TreeNode n1(-2147483648),n2(5),n3(15),n4(6),n5(20);
    n1.left = & n2;
    n1.right = & n3;
    n3.left = & n4;
    n3.right = & n5;
    Solution sol;
    bool b = sol.isValidBST(&n1);

}
