//113. Path Sum II
/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

Tag: Tree, Depth-first Search

Author: Xinyu Liu
*/

#include<iostream>
#include<vector>

using namespace std;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
    void findpath(TreeNode* root, int sum, vector<int>& path, vector<vector<int>>& paths){
        if (!root) return;
        path.push_back(root->val);
        if (!(root->left) && !(root->right) && root->val == sum )
            paths.push_back(path);
        findpath(root->left, sum - root->val, path, paths);
        findpath(root->right, sum - root->val, path, paths);
        path.pop_back();
    }
public:
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        if (!root) return vector<vector<int>>();
        vector<int> path;
        vector<vector<int>> paths;
        findpath(root, sum, path, paths);
        return paths;
    }
};

void main(){
    TreeNode n1(1), n2(2), n3(3);
    n1.left = &n2;
    n1.right = &n3;
    Solution sol;
    vector<vector<int>> paths = sol.pathSum(&n1, 3);

}
