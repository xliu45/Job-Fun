/**
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> s=new ArrayList<List<Integer>>();
        List<Integer> rootVal=new ArrayList<Integer>();
        if(root==null)
        	return s;
        s.add(rootVal);
        Sum(root,sum,0,s);
        s.remove(s.size()-1);
        return s;
    }
    private void Sum(TreeNode root, int sum, int curSum, List<List<Integer>> path) {
        curSum+=root.val;
        path.get(path.size()-1).add(root.val);
    	List<Integer> tmp=new ArrayList<Integer>(path.get(path.size()-1));
        if(root.left==null&&root.right==null)
        {
        	if(sum==curSum)
        		path.add(tmp);
        	return;
        }
        if(root.left!=null)
        {
	        Sum(root.left,sum,curSum,path);
	        path.get(path.size()-1).remove(path.get(path.size()-1).size()-1);
        }
        if(root.right!=null)
        {
	        Sum(root.right,sum,curSum,path);
	        path.get(path.size()-1).remove(path.get(path.size()-1).size()-1);
        }
    }
}
