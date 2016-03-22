/**
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<TreeNode>();
        List<List<TreeNode>> rootss=new ArrayList<List<TreeNode>>();
        rootss.add(new ArrayList<TreeNode>());
        rootss.get(0).add(null);
        rootss.add(new ArrayList<TreeNode>(Arrays.asList(new TreeNode(1))));
        for(int i=2;i<=n;i++)
        {
            List<TreeNode> tmpRoots=new ArrayList<TreeNode>();
            for(int j=1;j<=i;j++)
            {
                for(int l=0;l<rootss.get(j-1).size();l++)
                {
                    for(int r=0;r<rootss.get(i-j).size();r++)
                    {
                        TreeNode tmpRoot=new TreeNode(j);
                        tmpRoot.left=rootss.get(j-1).get(l);
                        tmpRoot.right=moveRight(rootss.get(i-j).get(r),j);
                        tmpRoots.add(tmpRoot);
                    }
                }
                
            }
            rootss.add(tmpRoots);
        }
        return rootss.get(rootss.size()-1);
    }

    private TreeNode moveRight(TreeNode root,int n)
    {
        if(root==null)
            return null;
        TreeNode newRoot=new TreeNode(root.val+n);
        newRoot.left=moveRight(root.left,n);
        newRoot.right=moveRight(root.right,n);
        return newRoot;
    }
}
