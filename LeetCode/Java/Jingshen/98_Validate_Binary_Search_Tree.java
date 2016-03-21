/**
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
    private Integer prev=null;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(this.prev!=null&&root.val<=this.prev)
            return false;
        else
            this.prev=root.val;
        return isValidBST(root.right);
    }
}
