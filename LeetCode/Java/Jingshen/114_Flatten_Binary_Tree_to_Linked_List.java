/**
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
    private TreeNode parent=new TreeNode(0);
    public void flatten(TreeNode root) {
        parent.left=null;
        parent.right=root;
        if(root==null)
            return;
        TreeNode right=root.right;
        parent=root;
        flatten(root.left);
        flatten(right);
    }
}
