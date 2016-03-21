/*
98. Validate Binary Search Tree

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
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
    public boolean isValidBST(TreeNode root) {
        return checkBST(root);
        
    }
    private boolean checkBST(TreeNode a){
        if (a==null){
            return true;
        }else{
            if( compareLeft(a,a.left) && compareRight(a,a.right) ){
                return checkBST(a.left) && checkBST(a.right);
            }else{
                return false;
            }
        }
    }
    private boolean compareLeft(TreeNode l, TreeNode cl){
        if (cl==null){
            return true;
        }
        if (l.val>cl.val){
            return compareLeft(l,cl.left) && compareLeft(l,cl.right);
        }else{
            return false;
        }
    }
    private boolean compareRight(TreeNode r, TreeNode cr){
        if (cr==null){
            return true;
        }
        if (r.val<cr.val){
            return compareRight(r,cr.left) && compareRight(r,cr.right);
        }else{
            return false;
        }
    }
}