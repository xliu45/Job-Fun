/*
297. Serialize and Deserialize Binary Tree

Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.

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
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null){
            return "null,";
        }
        String se=root.val + ",";
        se+=serialize(root.left);
        se+=serialize(root.right);
        return se;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] node=data.split(",");
        Queue<String> q=new LinkedList<String>();
        for(int i=0;i<node.length;i++){
            q.add(node[i]);
        }

        return getDeserialize(q);

    }
    public static TreeNode getDeserialize(Queue<String> q){
        String tmp=q.poll();
        if(tmp.equals("null")){
            return null;
        }
        TreeNode head = new TreeNode(Integer.valueOf(tmp));
        head.left = getDeserialize(q);
        head.right = getDeserialize(q);
        return head;


    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));