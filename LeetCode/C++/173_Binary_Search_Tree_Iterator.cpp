//173. Binary Search Tree Iterator
/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.

Tag: Tree Stack Design

Author: Xinyu Liu
*/
#include <iostream>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};


class BSTIterator {
private:
    stack<TreeNode*> s;
public:
    BSTIterator(TreeNode *root) {
        pushall(root);
    }

    /** @return whether we have a next smallest number */
    bool hasNext() {
        return !s.empty();

    }

    /** @return the next smallest number */
    int next() {
        TreeNode* tmp = s.top();
        s.pop();
        pushall(tmp->right);
        return tmp->val;
    }

    void pushall(TreeNode* root){
        while(root){
            s.push(root);
            root = root->left;
        }
    }
};


void main(){
    TreeNode n1(2), n2(1), n3(3);
    n1.left = &n2;
    n1.right = &n3;
    BSTIterator i(&n1);
    while(i.hasNext())
        cout << i.next();
}
