/**
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Jingshen
**/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mListNode=new ListNode(0);
        ListNode header=mListNode;
        while(l1!=null&&l2!=null)
        {
            if(l1.val<=l2.val)
            {
               mListNode.next=l1;
               mListNode=mListNode.next;
               l1=l1.next;
            }
            else
            {
               mListNode.next=l2;
               mListNode=mListNode.next;
               l2=l2.next;
            }
        }
        mListNode.next=l1==null?l2:l1;
        return header.next;
    }
}
