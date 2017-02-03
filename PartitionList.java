/*
Problem Statement : Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
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
	public ListNode partition(ListNode a, int b) {
	    
	    if(a == null)
	        return a;
	   
	    ListNode newlist = null;
	    ListNode last = null;
	    
	    ListNode temp = a;
	        
	    while(temp != null){
	        if(temp.val < b && newlist == null){
	            newlist = new ListNode(temp.val);
	            last = newlist;
	        }
	        else if(temp.val < b && newlist != null){
	            last.next = new ListNode(temp.val);
	            last = last.next;
	        }
	        temp = temp.next;
	    }
	    
	    temp = a;
	    while(temp != null){
	        if(temp.val >= b && newlist == null){
	            newlist = new ListNode(temp.val);
	            last = newlist;
	        }
	        else if(temp.val >= b && newlist != null) {
	            last.next = new ListNode(temp.val);
	            last = last.next;
	        }
	      
	        temp = temp.next;
	    }
	    
	    return newlist;
	}
}

