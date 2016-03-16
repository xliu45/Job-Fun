/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        TreeNode left=root.left;
        TreeNode right=root.right;
        if(left==null&&right==null)
            return true;
        else
            return subIsSymmetric(left,right);
    }
    public boolean subIsSymmetric(TreeNode left, TreeNode right)
    {
        if((left==null&&right!=null)||(left!=null&&right==null))
            return false;
        else if(left==null&&right==null)
            return true;
        else if(left.val!=right.val)
            return false;
        else
        {
            if(subIsSymmetric(left.left,right.right)&&subIsSymmetric(left.right,right.left))
                return true;
            else
                return false;
        }
    }
}
