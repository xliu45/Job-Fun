/*
113. Path Sum II

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

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
        private void solve(List<List<Integer>> res,List<Integer> tmpList,TreeNode root,int sum,int now){
        if(root==null)
            return;
        now += root.val;
        tmpList.add(root.val);
        if(root.left==null && root.right==null && now==sum){
            res.add(new LinkedList<>(tmpList));
        }
        solve(res,tmpList,root.left,sum,now);
        solve(res, tmpList, root.right, sum, now);

        now -= root.val;
        tmpList.remove(tmpList.size() - 1);
    }
    public void solvesolve(List<List<Integer>> res,List<Integer> tmpList,TreeNode root,int sum,int now){
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            if(now+root.val==sum){
                tmpList.add(root.val);
                res.add(new LinkedList<>(tmpList));
                tmpList.remove(tmpList.size()-1);
            }
            return;
        }
        tmpList.add(root.val);
        solvesolve(res,tmpList,root.left,sum,now+root.val);
        solvesolve(res,tmpList,root.right,sum,now+root.val);
        tmpList.remove(tmpList.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> tmpList = new LinkedList<>();

        solvesolve(res,tmpList,root,sum,0);
        return res;
    }
}