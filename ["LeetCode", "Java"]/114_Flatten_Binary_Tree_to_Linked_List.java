114. Flatten Binary Tree to Linked List

/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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
    public void flatten(TreeNode root) {
        if(root==null){
            return;
        }
        if(root.left!=null && root.right==null){
            root.right=root.left;
            root.left=null;
        }else{
            if(root.left!=null && root.right!=null){
                TreeNode temp=root.right;
                TreeNode t=root.left;
                root.right=t;
                root.left=null;
                while(t.right!=null){
                    t=t.right;
                }
                t.right=temp;
            }
        }
        flatten(root.right);
    }
}