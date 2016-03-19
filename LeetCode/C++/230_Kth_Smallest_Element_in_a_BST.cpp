//230. Kth Smallest Element in a BST
/*
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

Tag: Tree, Binary Search

Author: Xinyu Liu
*/

#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int kthSmallest(TreeNode* root, int k) {
        vector<int> nlist;
        nodelist(root, nlist);
        return nlist.at(k - 1);

    }
    void nodelist(TreeNode* root, vector<int> & nlist){
        if(!root) return;
        nodelist(root->left, nlist);
        nlist.push_back(root->val);
        nodelist(root->right, nlist);
    }
};

void main(){
    TreeNode n1(2),n2(1),n3(3);
    n1.left = &n2;
    n1.right = &n3;
    Solution sol;
    int kth = sol.kthSmallest(&n1,3);
}
