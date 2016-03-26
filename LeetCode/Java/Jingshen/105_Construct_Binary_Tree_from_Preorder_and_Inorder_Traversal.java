/**
Given preorder and inorder traversal of a tree, construct the binary tree.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0)
            return null;
        return helper(preorder,0,inorder,0,inorder.length);
    }
    private TreeNode helper(int[] preorder, int preStart, int[] inorder, int inStart, int length)
    {
        TreeNode root=new TreeNode(preorder[preStart]);
        int rootIdx = findIndex(preorder[preStart],inorder,inStart,length);
        if(rootIdx!=inStart)
            root.left=helper(preorder,preStart+1,inorder,inStart,rootIdx-inStart);
        if(rootIdx!=inStart+length-1)
            root.right=helper(preorder,preStart+rootIdx-inStart+1,inorder,rootIdx+1,length-1-rootIdx+inStart);
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
