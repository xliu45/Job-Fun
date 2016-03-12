// 116. Populating Next Right Pointers in Each Node
/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

#include <iostream>
using namespace std;
//Definition for binary tree with next pointer.
struct TreeLinkNode {
    int val;
    TreeLinkNode *left, *right, *next;
    TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
    void connect(TreeLinkNode *root) {
        if (root == NULL)
            return;
        if(root->left != NULL)
        root->left->next= root->right;
        if (root->right != NULL && root->next != NULL)
        root->right->next = root->next->left;
        connect(root->left);
        connect(root->right);
    }
};

void main(){
    TreeLinkNode n1(1),n2(2),n3(3),n4(4);
    n1.left = &n2;
    n1.right = &n3;
   // n2.left = &n4;
    Solution sol;
    sol.connect(&n1);
}
