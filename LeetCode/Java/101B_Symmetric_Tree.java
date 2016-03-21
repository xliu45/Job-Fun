/*
101. Symmetric Tree

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null){
            return true;
        }
        List<TreeNode> a = new ArrayList<TreeNode>();
        List<TreeNode> b = new ArrayList<TreeNode>();
        
        a.add(root.left);
        b.add(root.right);
        
        while(a.size()!=0 && b.size()!=0){
            TreeNode l = a.remove(0);
            TreeNode r = b.remove(0);
            if (l==null && r==null){
                continue;
            }else{
                if(l==null || r==null){
                    return false;
                }else{
                    if(l.val==r.val){
                        a.add(l.left);
                        b.add(r.right);
                        a.add(l.right);
                        b.add(r.left);
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        if (a.size()==0 && b.size()==0){
            return true;
        }else{
            return false;
        }
    }
}