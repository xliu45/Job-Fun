/**
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?

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
    public void recoverTree(TreeNode root) {
        List<TreeNode> swap=new ArrayList<TreeNode>();
        swap.add(new TreeNode(Integer.MIN_VALUE));
        helper(root,swap);
        if(swap.size()==3)
        {
            int tmp=swap.get(0).val;
            swap.get(0).val=swap.get(1).val;
            swap.get(1).val=tmp;
        }
        else
        {
            int tmp=swap.get(0).val;
            swap.get(0).val=swap.get(3).val;
            swap.get(3).val=tmp;
        }
    }
    private void helper(TreeNode root, List<TreeNode> swap) {
        if(root==null)
            return;
        helper(root.left,swap);
        if(swap.get(swap.size()-1).val<root.val)
            swap.set(swap.size()-1,root);
        else
        {
            swap.add(root);
            swap.add(root);
        }
        helper(root.right,swap);
    }
}
