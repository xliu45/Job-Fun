/*
117. Populating Next Right Pointers in Each Node II

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
        if(root==null || (root.left==null && root.right==null)){
            return;
        }else{
            if(root.left==null){
                if(findNext(root)!=null){
                    if(findNext(root).left!=null){
                        root.right.next=findNext(root).left;
                    }else{
                        if(findNext(root).right!=null){
                            root.right.next=findNext(root).right;
                        }
                    }
                }
                connect(root.right);
            }else{
                if (root.right==null){
                    if(findNext(root)!=null){
                        if(findNext(root).left!=null){
                            root.left.next=findNext(root).left;
                        }else{
                            if(findNext(root).right!=null){
                                root.left.next=findNext(root).right;
                            }
                        }
                    }
                    connect(root.left);
                }else{
                    root.left.next=root.right;
                    if(findNext(root)!=null){
                        if(findNext(root).left!=null){
                            root.right.next=findNext(root).left;
                        }else{
                            if(findNext(root).right!=null){
                                root.right.next=findNext(root).right;
                            }
                        }
                    }
                    
                    connect(root.right);
                    connect(root.left);
                }
            }
        }
    }
    public TreeLinkNode findNext(TreeLinkNode a){
        if(a.next!=null){
            if( (a.next.left!=null) || (a.next.right!=null) ){
                return a.next;
            }else{
                return findNext(a.next);
            }
        }else{
            return null;
        }
    }
}