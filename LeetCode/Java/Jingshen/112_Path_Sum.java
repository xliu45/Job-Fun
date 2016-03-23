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
    public boolean hasPathSum(TreeNode root, int sum) {
        return sum(root,sum,0);
    }
    private boolean sum(TreeNode root, int target, int sum)
    {
        if(root==null)
            return false;
        sum+=root.val;
        if(root.left==null&&root.right==null)
            return sum==target;
        return sum(root.left,target,sum)||sum(root.right,target,sum);
    }
}
