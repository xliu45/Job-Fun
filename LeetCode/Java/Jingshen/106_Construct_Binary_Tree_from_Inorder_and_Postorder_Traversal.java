/**
Given inorder and postorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0)
            return null;
        return helper(postorder,inorder.length-1,inorder,0,inorder.length);
    }
    private TreeNode helper(int[] postorder, int postEnd, int[] inorder, int inStart, int length)
    {
        TreeNode root=new TreeNode(postorder[postEnd]);
        int rootIdx = findIndex(postorder[postEnd],inorder,inStart,length);
        if(rootIdx!=inStart)
            root.left=helper(postorder,postEnd-(length-rootIdx+inStart),inorder,inStart,rootIdx-inStart);
        if(rootIdx!=inStart+length-1)
            root.right=helper(postorder,postEnd-1,inorder,rootIdx+1,length-1-rootIdx+inStart);
        return root;
    }
    private int findIndex(int val, int[] inorder, int inStart, int length) {
        for(int n=inStart;n<inStart+length;n++) {
            if(val==inorder[n])
                return n;
        }
        return -1;
    }
}
