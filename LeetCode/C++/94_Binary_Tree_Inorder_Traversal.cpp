//94. Binary Tree Inorder Traversal
/*
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Tag: Tree, Hash Table, Stack

Author: Xinyu Liu
*/
#include <iostream>
#include <vector>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

//class Solution {
//public:
//    vector<int> inorderTraversal(TreeNode* root) {
//        vector<int> vec;
//        subinorder(root, vec);
//        return vec;
//    }
//    void subinorder(TreeNode* root, vector<int> &vec){
//        if(!root){
//            return;
//        }
//        subinorder(root->left, vec);
//        vec.push_back(root->val);
//        subinorder(root->right, vec);
//    }
//};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        if(!root)
            return vector<int>();
        stack<TreeNode*> s;
        vector<int> vec;
        while(!s.empty() || root){
            if(root){
                s.push(root);
                root = root->left;
            }
            else{
                root = s.top();
                vec.push_back(root->val);
                s.pop();
                root = root->right;
            }
        }
        return vec;
    }
};

void main(){
    TreeNode n1(1),n2(2),n3(3);
    n1.right = &n2;
    n2.left = &n3;
    Solution sol;
    vector<int> vec = sol.inorderTraversal(&n1);
}
