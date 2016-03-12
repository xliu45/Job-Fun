package com.huaqingzhang.ubst2;

import java.util.*;
/*
209. minimum size subarray sum 

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.
Author: Huaqing Zhang
*/

public class Unique_Binary_Search_Trees_II {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; left = null; right = null; }
		 }
	public List<TreeNode> generateTrees(int n) {
        return genergate(1,n);
    }
    private List<TreeNode> genergate(int start, int end){
        List<TreeNode> res = new ArrayList<TreeNode>();
        // base case
        if (start > end){
            // make sure the first tree is null and also won't break teh case when one side is null
            res.add(null);
            return res;
        }
        for(int i=start; i<=end;i++){
            List<TreeNode> leftsubTree = genergate(start,i-1);
            List<TreeNode> rightsubTree = genergate(i+1,end);
            for(int j=0; j<leftsubTree.size();j++){
                for(int k=0;k<rightsubTree.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftsubTree.get(j);
                    root.right = rightsubTree.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }
    
    public static void main(String[] args) {
        int nn=4;
        List<TreeNode> point = new ArrayList<TreeNode>();
        Unique_Binary_Search_Trees_II test = new Unique_Binary_Search_Trees_II();
        point=test.generateTrees(nn);
       System.out.println(point.size() );
    }

}