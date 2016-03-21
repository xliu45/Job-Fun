/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
        if(root==null){
            return true;
        }
        else{
            return checkSym(root.left, root.right);
        }
    }
    public boolean checkSym(TreeNode a, TreeNode b){
        if (a==null && b==null){
            return true;
        }else{
            if (a==null || b==null){
                return false;
            }else{
                if (a.val==b.val){
                    return checkSym(a.left,b.right) && checkSym(a.right,b.left)  ;
                }
                else{
                    return false;
                }
            }
        }
        
    }
}