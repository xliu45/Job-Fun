//129. Sum Root to Leaf Numbers
/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.

Tag: Tree, Depth-first Search 
*/

#include<iostream>
#include<vector>
#include<stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        if(!root) return 0;
        return sum(root, 0);
    }
    int sum(TreeNode* root, int s){
        if(!root) return 0;
        if(!(root->left) && !(root->right)) return (10 * s + root->val);
        return sum(root->left, 10*s + root->val) + sum(root->right, 10*s + root->val);
    }
};

void main(){
    TreeNode n1(1),n2(0);
    n1.left = &n2;
    Solution sol;
    int res = sol.sumNumbers(&n1);
}
