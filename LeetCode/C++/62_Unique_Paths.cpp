//62. Unique Paths
/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
How many possible unique paths are there?

Tag: Array, Dynamic Programming

Author: Xinyu Liu
*/
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> mat (m, vector<int>(n,1));
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                mat[i][j] = mat[i-1][j] + mat[i][j-1];
            }
        }
        return mat[m-1][n-1];
    }
};

void main(){
    int m = 1;
    int n = 2;
    Solution sol;
    int nums = sol.uniquePaths(m, n);
}
