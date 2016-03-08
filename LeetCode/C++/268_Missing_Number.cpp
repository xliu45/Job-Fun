//268. Missing Number
/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example: Given nums = [0, 1, 3] return 2.

Tag: Array, Math, Bit Manipulation

Author: Xinyu Liu
*/

#include <iostream>
#include <vector>
#include <algorithm>    // std::sort
using namespace std;

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        sort (nums.begin(), nums.end());
        int i = 0;
        int start = 0;
        if (nums.size() == 0)
            return 0;
        for ( ; i < nums.size(); i++){
            if (nums.at(i) != i)
            return nums.at(i) - 1; 
        }
        return nums.at(i - 1) + 1;
    }
};

void main(){
    int a[] = {2,0};
    vector<int> test(a, a + sizeof(a)/sizeof(int));
    //vector<int> test;
    Solution sol;
    int miss = sol.missingNumber(test);
}
