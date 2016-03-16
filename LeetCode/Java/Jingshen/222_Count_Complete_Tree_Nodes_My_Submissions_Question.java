/**
Given a complete binary tree, count the number of nodes.

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

    public int countNodes(TreeNode root) {
        if(root==null)
            return 0;
        int l=getDepth(root.left);
        int r=getDepth(root.right);
        if(l==r)
            return (1<<l)+countNodes(root.right);
        else
            return (1<<r)+countNodes(root.left);
    }
    private int getDepth(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+getDepth(root.left);
    }
}
