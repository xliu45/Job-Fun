//107. Binary Tree Level Order Traversal II
/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]

Tag: Tree, Bread-first Search
*/
#include <iostream>
#include <vector>
#include <queue>
using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        if(!root) return vector<vector<int>> ();
        vector<vector<int>> vec;
        queue<TreeNode*> q;
        q.push(root);
        while (!q.empty()){
            vector<int> vec_s;
            int sz = q.size();
            for (int i = 0; i < sz; i++){
                root = q.front();
                vec_s.push_back(root->val);
                q.pop();
                if(root->left) q.push(root->left);
                if(root->right) q.push(root->right);
            }
            vec.insert(vec.begin(),vec_s);
        }
        return vec;
    }
};

void main(){
    TreeNode n1(3), n2(9), n3(20), n4(15), n5(7);
    n1.left = &n2;
    n1.right = &n3;
    n3.left = &n4;
    n3.right = &n5;
    Solution sol;
    vector<vector<int>> vec = sol.levelOrderBottom(&n1);
}
