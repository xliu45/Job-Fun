//235. Lowest Common Ancestor of a Binary Search Tree
/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Tag: Tree

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
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if (!root)
            return NULL;
        if (!p || p->val == q->val) return q;
        if (!q) return p;
        if (min(p->val, q->val) <= root->val && root-> val <= max(p->val, q->val))
            return root;
        else if (p->val > root->val) 
            return lowestCommonAncestor(root->right, p, q);
        else if (p->val < root->val)
            return lowestCommonAncestor(root->left, p, q);
    }
};

void main(){
    TreeNode n1(6),n2(2),n3(8),n4(0),n5(4);
    n1.left = &n2;
    n1.right = &n3;
    n2.left = &n4;
    n2.right = &n5;
    Solution sol;
    TreeNode* n = sol.lowestCommonAncestor(&n1, &n4, &n5);
}
