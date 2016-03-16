/*
Given two binary trees, write a function to check if they are equal or not.

Jingshen
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(q==null^p==null)
            return false;
        else if(p==null&&q==null)
            return true;
            else
            {
                if(p.val!=q.val)
                    return false;
                else
                    return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
            }
    }
}
