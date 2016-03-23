//297. Serialize and Deserialize Binary Tree
/*
erialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.*/


#include <iostream>
#include <queue>
#include <sstream>
#include <string>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        if (!root)
            return string();
        string s;
        queue<TreeNode*> q;
        q.push(root);
        while(!q.empty()){
            root = q.front();
            q.pop();
            if (root != NULL){
                string tmp;
                ostringstream convert;
                convert << root->val;
                tmp = convert.str();
                s = s + tmp + ',';
            }
            else
                s += "#,";
            if (root != NULL){
                q.push(root->left);
                q.push(root->right);
            }
        }
        return s;
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        if(data.empty())
            return NULL;
        queue<TreeNode*> q;
        TreeNode * head = new TreeNode(stoi(data.substr(0, data.find(","))));
        data.erase(0,data.find(",") + 1);
        q.push(head);
        while(!data.empty()){
            TreeNode* root = q.front();
            q.pop();
            if(data.substr(0, data.find(",")) != "#"){

                TreeNode* nodel = new TreeNode (stoi(data.substr(0, data.find(","))));
                root->left = nodel;
                q.push(nodel);
            }

            data.erase(0,data.find(",") + 1);

            if(data.substr(0, data.find(",")) != "#"){

                TreeNode* noder = new TreeNode (stoi(data.substr(0, data.find(","))));
                root->right = noder;
                q.push(noder);
            }
            data.erase(0,data.find(",") + 1);

        }
        return head;
    }
    
};


void main(){
    TreeNode n1(1),n2(2),n3(3),n4(4),n5(5);
    n1.left = &n2;
    n1.right = &n3;
    n3.left = &n4;
    n3.right = &n5;
    Codec cod;
    string s = cod.serialize(&n1);
    TreeNode* root = cod.deserialize(s);
}
