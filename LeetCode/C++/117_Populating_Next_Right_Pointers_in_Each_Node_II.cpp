//117. Populating Next Right Pointers in Each Node II
/*
Follow up for problem "Populating Next Right Pointers in Each Node".
What if the given tree could be any binary tree? Would your previous solution still work?

Tags: Tree, Depth-first Search

Author: Xinyu Liu
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
        TreeLinkNode *n = root->next;
        TreeLinkNode *NextNode = NULL;

        while(n != NULL && NextNode == NULL){
            if (n->left != NULL){
                NextNode = n->left;
                break;
            }
            if (n->right != NULL){
                NextNode = n->right;
                break;
            }
            n = n->next;
        }

        if(root->right != NULL)
            root->right->next = NextNode;
        if(root->left != NULL){
            root->left->next = (root->right == NULL ? NextNode : root->right);
        }
        
        connect(root->right);
        connect(root->left);
        
    }
};

void main(){
    TreeLinkNode n1(2),n2(1),n3(3),n4(0),n5(7),n6(9),n7(1),n8(2),n9(1),n10(0),n11(8),n12(8),n13(7);
    n1.left = &n2;
    n1.right = &n3;
    n2.left = &n4;
    n2.right = &n5;
    n3.left = &n6;
    n3.right = &n7;
    n4.left = &n8;
    n5.left = &n9;
    n5.left = &n10;
    n7.left = &n11;
    
    Solution sol;
    sol.connect(&n1);
}
