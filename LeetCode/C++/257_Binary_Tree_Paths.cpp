//257. Binary Tree Paths
/*
Given a binary tree, return all root-to-leaf paths.
For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]
*/

#include <iostream>
#include <vector>
#include <string>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<string> binaryTreePaths(TreeNode* root) {
        if (!root)
            return vector<string>();
        vector<string> vec;
        subpath(root, vec, to_string(root->val));
        return vec;

    }

    void subpath(TreeNode* root,vector<string>& vec, string s){
        if (!root->left && !root->right){
            vec.push_back(s);
            return;
        }
        if (root->left)
            subpath(root->left, vec, s + "->" + to_string(root->left->val));
        if (root->right)
            subpath(root->right, vec, s + "->" + to_string(root->right->val));
    }
};
