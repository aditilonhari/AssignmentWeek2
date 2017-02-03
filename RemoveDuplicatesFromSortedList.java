/*
Problem Statement : Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    
	    if(a == null)
	        return a;
	    
	    ListNode t = new ListNode(0);
        t.next = a;
     
        ListNode p = t;
        while(p.next!=null&&p.next.next!=null){
            if(p.next.val == p.next.next.val){
                int dup = p.next.val;
                while(p.next!=null&&p.next.val==dup){
                    p.next = p.next.next;
                }
            }else{
                p=p.next;
            }
     
        }
     
        return t.next;
	}
}

