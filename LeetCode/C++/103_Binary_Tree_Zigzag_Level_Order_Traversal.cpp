//103. Binary Tree Zigzag Level Order Traversal
/*Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

Tag: Tree, Breadth-first Search, Stack

Author: Xinyu Liu
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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        if (root == NULL)
            return vector<vector<int>>();
        queue<TreeNode*> q;
        q.push(root);
        vector<vector<int>> vec;
        bool left2right = true;
        while(!q.empty()){
            int sz = q.size();
            vector<int> vec_s(sz);
            for (int i = 0; i < sz; i++){
                TreeNode* node = q.front();
                q.pop();
                int loc = (left2right) ? i : sz - i - 1;
                vec_s[loc] = node->val;
                if(node->left != NULL)
                    q.push(node->left);
                if(node->right != NULL)
                    q.push(node->right);
            }
            vec.push_back(vec_s);
            left2right = !left2right;
        }
        return vec;
    }
};

void main(){
    TreeNode n1(3),n2(9),n3(20),n4(15),n5(17);
    n1.left = &n2;
    n1.right = &n3;
    n3.left = &n4;
    n3.right = &n5;
    Solution sol;
    vector<vector<int>> vec = sol.zigzagLevelOrder(&n1);

}
