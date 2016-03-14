
/*
112. Path Sum

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

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
        private boolean isequal = false; 

    public boolean hasPathSum(TreeNode root, int sum) {
        calculate(root, 0, sum);
        return isequal;
    }

    
    private void calculate(TreeNode node, int cur, int sum) {
        if (!isequal && node != null) { 


            if (node.left == null && node.right == null && (node.val + cur == sum) ) {
                isequal = true;
            }


            if (node.left != null) {
                calculate(node.left, cur + node.val, sum);
            }

            if (node.right != null) {
                calculate(node.right, cur + node.val, sum);
            }
        }
    }
    
}