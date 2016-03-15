/**
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Author: Jingshen
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
    private TreeNode target;
    private int count;
    public int kthSmallest(TreeNode root, int k) {
        this.count=0;
        search(root,k);
        return target.val;
    }
    private void search(TreeNode root, int k) {
        if(root.left!=null)
        {
            search(root.left,k);
            this.count+=1;
            if(this.count==k)
                this.target=root;
            if(root.right!=null)
                search(root.right,k);
        }
        else
        {
            this.count+=1;
            if(this.count==k)
                this.target=root;
            if(root.right!=null)
                search(root.right,k);
        }

    }
}
