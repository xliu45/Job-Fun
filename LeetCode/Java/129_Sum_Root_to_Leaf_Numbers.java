/*
129. Sum Root to Leaf Numbers

Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
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
    public int sumNumbers(TreeNode root) {
        int totalVal=0;
        if (root==null){
            return 0;
        }else{
            return sumProcess(root, root.val);
        }
    }
    private int sumProcess(TreeNode a, int currentVal){
        if (a.left==null && a.right ==null ){
            return currentVal;
        }else{
            if (a.left !=null && a.right ==null){
                int newVal= a.left.val+currentVal*10;
                return sumProcess(a.left, newVal);
            }else{
                if (a.left ==null && a.right !=null){
                    int newVal= a.right.val+currentVal*10;
                    return sumProcess(a.right, newVal);
                }else{
                    int leftnewVal= a.left.val+currentVal*10;
                    int rightnewVal= a.right.val+currentVal*10;
                    return sumProcess(a.left, leftnewVal) + sumProcess(a.right, rightnewVal);
                }
            }
        }
    }
    
}