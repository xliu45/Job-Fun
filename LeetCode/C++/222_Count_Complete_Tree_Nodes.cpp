//222. Count Complete Tree Nodes
/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, 
and all nodes in the last level are as far left as possible. 
It can have between 1 and 2h nodes inclusive at the last level h.

Author: Xinyu Liu

Tag: Tree, Binary Search
*/


#include <iostream>
#include <cmath>

using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int countNodes(TreeNode* root) {
        if (root == NULL)
            return 0;
        TreeNode* l = root->left;
        TreeNode* r = root->right;
        int hl = 1, hr = 1;
        while(l) {
            l = l->left;
            hl++;
        }
        while(r){
            r = r->right;
             hr++;
        }
        if(hl == hr){
            return int(pow(2.0,hl) - 1);
        }
        return 1 + countNodes(root->left) + countNodes(root->right);
    }
};

void main(){

    TreeNode n1(1),n2(2),n3(3);
    n1.left = &n2;
    n2.right = &n3;
    Solution sol;
    int i = sol.countNodes(&n1);

}
