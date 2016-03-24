114. Flatten Binary Tree to Linked List

/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

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
        if(root==null){
            return 0;
        }
        int LevelonLeft=1;
        int LevelonRight=1;
        TreeNode l=root.left;
        while(l!=null){
            LevelonLeft++;
            l=l.left;
        }
        TreeNode r=root.right;
        while(r!=null){
            LevelonRight++;
            r=r.right;
        }
        if (LevelonLeft==LevelonRight){
            return (1<<LevelonLeft)-1;
        }else{
            return countNodes(root.left)+countNodes(root.right)+1;
        }
        
    }
}