/**
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        return findRoot(0,nums.length-1,nums);
    }
    private TreeNode findRoot(int firstIdx, int lastIdx, int[] nums)
    {
        if(firstIdx>lastIdx)
            return null;
        int middleIdx=(firstIdx+lastIdx)/2;
        TreeNode root=new TreeNode(nums[middleIdx]);
        root.left=findRoot(firstIdx,middleIdx-1,nums);
        root.right=findRoot(middleIdx+1,lastIdx,nums);
        return root;
    }
}
