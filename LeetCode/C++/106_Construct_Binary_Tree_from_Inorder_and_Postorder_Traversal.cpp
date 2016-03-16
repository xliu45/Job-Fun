//106. Construct Binary Tree from Inorder and Postorder Traversal
/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Tag: Tree, Array, Depth-first-Search

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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int begin1 = 0, end1 = inorder.size();
        int begin2 = 0, end2 = postorder.size();
        return buildsubTree(inorder, begin1, end1, postorder, begin2, end2);

    }
    TreeNode* buildsubTree(vector<int>& inorder, int begin1, int end1, vector<int>& postorder, int begin2, int end2){
        int i;
        if (end1 - begin1 == 0)
            return NULL;
        if (end1 - begin1 == 1)
            return new TreeNode(inorder.at(begin1));;
        TreeNode* root = new TreeNode(postorder.at(end2 - 1));
        for (i = begin1; i < end1; i++){
            if (inorder.at(i) == postorder.at(end2 - 1))
                break;
        }
        int left_l = i - begin1;
        int right_l = end1 - i -1;
        root->left = buildsubTree(inorder, begin1, begin1 + left_l, postorder, begin2, begin2 + left_l);
        root->right = buildsubTree(inorder, i + 1, i + 1 + right_l, postorder, end2 - 1 - right_l, end2 - 1);

        return root;
    }
};

void main(){
    int a[] = {1,2,3,4};
    vector<int> inorder(a,a + sizeof(a)/sizeof(int));
    int b[] = {3,2,4,1};
    vector<int> postorder(b,b + sizeof(b)/sizeof(int));
    Solution sol;
    TreeNode* root = sol.buildTree(inorder, postorder);
}
