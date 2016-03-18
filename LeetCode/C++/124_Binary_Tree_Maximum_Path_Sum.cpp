//124. Binary Tree Maximum Path Sum
/*
Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
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
    int maxPathSum(TreeNode *root) {
        int maxpath = INT_MIN;
        submax(root, maxpath);
        return maxpath;
    }
    int submax(TreeNode *root, int & maxpath){

        if (!root){
            return 0;
        }
        
        int l = max(0, submax(root->left , maxpath));
        int r = max(0, submax(root->right , maxpath));
        maxpath = max(maxpath, root->val + l + r);
        return root->val + max(l , r);
        
    }    
};


void main(){

    TreeNode n1(-2),n2(1),n3(3),n4(-4);
    n1.left = &n2;
    n1.right = &n3;
    n2.left = &n4;
    Solution sol;
    int maxpath = sol.maxPathSum(&n1);
}
