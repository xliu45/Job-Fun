//99. Recover Binary Search Tree
/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.

Tag: Tree, Depth-first Search

Author: Xinyu Liu
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
private: 

    void inorder_trans(TreeNode* root, TreeNode*& pre, TreeNode*& swap1, TreeNode*& swap2){
        if(!root) return;
        inorder_trans(root->left, pre, swap1, swap2);
        
        if(swap1 == NULL && root->val < pre->val){
            swap1 = pre;
        }
        if(swap1 != NULL && root->val < pre->val){
            swap2 = root;
        }
        pre = root;
        inorder_trans(root->right, pre, swap1, swap2);
    }
public:
    void recoverTree(TreeNode* root) {
        if(!root) return;
        TreeNode* pre = new TreeNode(INT_MIN);
        TreeNode* swap1 = NULL;
        TreeNode* swap2 = NULL;
        inorder_trans(root, pre, swap1, swap2);
        int tmp = swap1->val;
        swap1->val = swap2->val;
        swap2->val = tmp;
    }
};

void main(){
    TreeNode n1(2),n2(1),n3(3);
    n1.left = &n2;
    n2.right = &n3;
    Solution sol;
    sol.recoverTree(&n1);
}
