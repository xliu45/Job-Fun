/**
* Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
* For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Jingshen

Found a 5-line answer for this problem. WTF!
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p==q)
            return p;
        List<List<TreeNode>> path=new ArrayList<List<TreeNode>>();
        List<TreeNode> rootVal=new ArrayList<TreeNode>();
        rootVal.add(root);
        path.add(rootVal);
        search(root,p,q,path);
        for(int n=(path.get(0).size()-1);n>=0;n--)
        {
            if(path.get(1).contains(path.get(0).get(n)))
                return path.get(0).get(n);
        }
            return null;
    }
    private boolean search(TreeNode root, TreeNode p, TreeNode q, List<List<TreeNode>> path) {
        path.get(path.size()-1).add(root);
        List<TreeNode> curPath=new ArrayList<TreeNode>(path.get(path.size()-1));
        if(root==null)
            return false;
        if(root==p||root==q)
        {
            path.add(curPath);
            if(path.size()==3)
                return true;
        }
        if(search(root.left,p,q,path))
            return true;
        else
            path.get(path.size()-1).remove(path.get(path.size()-1).size()-1);
        if(search(root.right,p,q,path))
            return true;
        else
            path.get(path.size()-1).remove(path.get(path.size()-1).size()-1);
        return false;
        
    }
}
