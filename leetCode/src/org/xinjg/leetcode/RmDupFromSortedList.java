package org.xinjg.leetcode;

public class RmDupFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
    	ListNode node = head;
    	while(node!=null && node.next!=null){
    		if(node.val==node.next.val){
    			node.next=node.next.next;
    		}else
    			node = node.next;
    	}
        return head;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	head.next= new ListNode(1);
    	head.next.next= new ListNode(1);
	}
}
