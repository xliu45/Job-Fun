package com.huaqingzhang.UBST;


/*
96. Unique Binary Search Trees

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
Author: Huaqing Zhang
*/

public class Unique_Binary_Search_Trees {
    //public int minSubArrayLen(int s, int[] nums) {
        
    //}
    
    public static void main(String[] args) {
        int n=4;
        n=n+1;
        int [] nums = new int[n];
        Arrays.fill(nums, 0);
        nums[0]=1;
        for (int i=2;i<=n;i++){
            nums[i-1]=0;
            for (int j=1; j<=i-1;j++){
            	nums[i-1]=nums[i-1]+nums[i-j-1]*nums[j-1];
            }
            
        }
       System.out.println(nums[n-1]);
       
    }

}