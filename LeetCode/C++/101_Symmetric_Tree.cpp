//101. Symmetric Tree
/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
*/
#include <iostream>
using namespace std;

// Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (!root)
            return true;
        return isSymmetric_two(root ->left, root ->right);
    }
    bool isSymmetric_two(TreeNode* left, TreeNode* right){
        if (!left) return right == NULL;
        if (!right) return left == NULL;
        if (left -> val != right ->val) return false;
        return (isSymmetric_two(left ->left, right ->right) && isSymmetric_two(left ->right, right ->left));
       
    }
};

void main(){
    TreeNode* tree = new TreeNode(1);
    tree ->left = new TreeNode(2);
    tree ->right = new TreeNode(2);
    tree ->left ->left = new TreeNode(3);
    tree ->left ->left ->left = new TreeNode(4);
    tree ->left ->left ->right = new TreeNode(5);
    tree ->right ->left = new TreeNode(3);
    tree ->right ->left ->left = new TreeNode(5);
    Solution sol;
    bool b = sol.isSymmetric(tree);
}
