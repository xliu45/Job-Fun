/*
144. Binary Tree Preorder Traversal

Given a binary tree, return the preorder traversal of its nodes' values.

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
    private List<Integer> result;
    public List<Integer> preorderTraversal(TreeNode root) {
        result = new LinkedList<>();
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode root) {
        if (root != null) {
            result.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    
}