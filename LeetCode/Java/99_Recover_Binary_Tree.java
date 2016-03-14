/*
99. Recover Binary Search Tree

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

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
    List<TreeNode> nodes;
    public void recoverTree(TreeNode root) {
        nodes = new ArrayList<>();
        inorder(root);

        int size = nodes.size();
        TreeNode first=null,second=null;
        for(int i = 0;i<size-1;i++){
            TreeNode prev = nodes.get(i);
            TreeNode next = nodes.get(i+1);

            if(prev.val>next.val){
                if(first == null){
                    first = prev;
                    second = next;                    
                }
                else
                    second = next;
            }
        }
        int val = first.val;
        first.val = second.val;
        second.val = val;
    }
    private void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        nodes.add(root);
        inorder(root.right);
    }
}