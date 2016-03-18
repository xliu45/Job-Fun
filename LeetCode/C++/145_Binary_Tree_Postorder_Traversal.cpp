//145. Binary Tree Postorder Traversal
/*
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Tag: Tree, Stack

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


//Recursive solution
//class Solution {
//public:
//    vector<int> postorderTraversal(TreeNode* root) {
//        vector<int> poster;
//        postsub(root,poster);
//        return poster;
//    }
//    void postsub(TreeNode* root,vector<int> &poster){
//
//        if (!root) return;
//        postsub(root->left,poster);
//        postsub(root->right,poster);
//        poster.push_back(root->val);
//
//    }
//};

//Iterative solution
class Solution{
public:
    vector<int> postorderTraversal(TreeNode* root) {
        if (!root)
            return vector<int> ();
        stack<TreeNode*> s;
        vector<int> vec;
        while(!s.empty() || root){
            if (root){
                vec.insert(vec.begin(), root->val);
                s.push(root);
                root = root->right;
            }
            else{
                root = s.top()->left;
                s.pop();
            }
        }
        return vec;
    }
};
void main(){
    TreeNode n1(1),n2(2);
    n1.left = &n2;
    Solution sol;
    vector<int> poster = sol.postorderTraversal(&n1);
}
