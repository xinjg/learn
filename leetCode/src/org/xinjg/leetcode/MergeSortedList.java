package org.xinjg.leetcode;

public class MergeSortedList {
public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1==null) {
			return l2;
		};
		if (l2==null) {
			return l1;
		}
        ListNode head = null;
        ListNode node = null;
        ListNode list=null;
       while(l1!=null || l2!=null){
    	   if (l1==null&&l2!=null) {
    		   node=l2;
    		   l2=l2.next;
    	   }else   if (l2==null&&l1!=null) {
    		   node=l1;
    		   l1=l1.next;
    	   } else if (l1!=null&&l2!=null) {
    		   if (l1.val<l2.val) {
    			   node=l1;
    			   l1=l1.next;
    		   }else {
    			   node=l2;
        		   l2=l2.next;
    		   }
    	   }
    	   if (list==null) {
    	  		list=node;
    	  		head = list;
    	  	}else {
    	  		list.next=node;
    	  		list=list.next;
    	  	}
       }
        return head;
    }

	public static void main(String[] args) {
		ListNode l1 =new ListNode(1);
		l1.next=new ListNode(3);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(0);
		MergeSortedList  mergeSortedList = new MergeSortedList();
		ListNode l3 =mergeSortedList.mergeTwoLists(l1, l2);
		ListNode node =l3;
		while (node!=null) {
			System.out.println(node.val);
			node=node.next;
		}
	}
}
