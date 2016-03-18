/**
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].

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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null)
            return new ArrayList<Integer>();
        return sub(root);
    }
    public List<Integer> sub(TreeNode root) {
        List<Integer> left=new ArrayList<Integer>();
        List<Integer> right=new ArrayList<Integer>();
        if(root==null)
            return right;
        right=sub(root.right);
        left=sub(root.left);
        if(left.size()>right.size())
            right.addAll(left.subList(right.size(),left.size()));
        right.add(0,root.val);
        return right;
    }
}
