//112. Path Sum
/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
    bool hasPathSum(TreeNode* root, int sum) {
        if (!root)
            return false;
        if (!(root->left) && !(root->right))
            return sum - root->val == 0;
        return hasPathSum(root->left, sum - root->val) || hasPathSum(root->right, sum - root->val);
    }
};

void main(){
    TreeNode n1(1), n2(2), n3(3);
    n1.left = &n2;
    n1.right = &n3;
    Solution sol;
    bool b = sol.hasPathSum(&n1, 6);
}
