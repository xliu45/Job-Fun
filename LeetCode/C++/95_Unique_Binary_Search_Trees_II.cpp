//95. Unique Binary Search Trees II
/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

Tag: Tree, Dynamic Programming

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
private: TreeNode* cloneOffset (TreeNode* node, int offset){
             if (!node) return NULL;
             TreeNode* n =new TreeNode(node->val + offset); 
             n->left = cloneOffset(node->left, offset);
             n->right = cloneOffset(node->right, offset);
             return n;
         }
public:
    vector<TreeNode*> generateTrees(int n) {
        vector<vector<TreeNode*>> vec (n+1);
        vec[0] = vector<TreeNode*>();
        vec[0].push_back(NULL);
        if (n == 0) return vector<TreeNode*>();
        for(int i = 1; i <= n; i++){
            vec[i] = vector<TreeNode*>();
            for(int j = 0; j < i; j++){
                for(vector<TreeNode*>::iterator m = vec[j].begin(); m != vec[j].end(); m++){
                   TreeNode* nodeL = *m;
                   for(vector<TreeNode*>::iterator k = vec[i - j - 1].begin(); k != vec[i - j - 1].end(); k++){
                        TreeNode* nodeR = *k;
                        TreeNode* root = new TreeNode(j + 1);
                        root->left = nodeL;
                        root->right = cloneOffset(nodeR, j + 1);
                        vec[i].push_back(root);
                    }
                }

            }
        }
        return vec[n];
    }
};

void main(){
    int n = 0;
    Solution sol;
    vector<TreeNode *> T = sol.generateTrees(n);
}
