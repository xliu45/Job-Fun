/**
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

Jingshen
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        List<TreeLinkNode> nodes=new ArrayList<TreeLinkNode>();
        connectSub(root,nodes,1);
    }
    private void connectSub(TreeLinkNode root, List<TreeLinkNode> nodes, int level) {
        if(root==null)
            return;
        connectSub(root.left,nodes,level+1);
        root.next=null;
        while(nodes.size()<level)
            nodes.add(new TreeLinkNode(0));
 
        nodes.get(level-1).next=root;
        nodes.set(level-1,root);

        connectSub(root.right,nodes,level+1);
    }
}
