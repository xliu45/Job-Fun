//96. Unique Binary Search Trees
/*
Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Subscribe to see which companies asked this question

Tag: Tree, Dynamic Programming

Author: Xinyu Liu
*/

#include<iostream>
#include<vector>
using namespace std;

class Solution {
public:
    int numTrees(int n) {
        vector<int>num(n + 1,0);
        num[0] = 1;
        num[1] = 1;
        
        for (int i = 2; i <= n; i++){
            for(int j = 1; j <= i; j++){
                num[i] += num[j - 1]*num[i - j]; 
            }
        }
        return num[n];
    }
};



void main(){
    int i = 2;
    Solution sol;
    int num = sol.numTrees(i);
}
