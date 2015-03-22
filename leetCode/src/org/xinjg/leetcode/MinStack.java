package org.xinjg.leetcode;

/**
 * Problems: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
	push(x) -- Push element x onto stack.
	pop() -- Removes the element on top of the stack.
	top() -- Get the top element.
	getMin() -- Retrieve the minimum element in the stack.
 * @author Administrator
 *
 */
public class MinStack {
	private Node head;
	private int min = Integer.MAX_VALUE;
	private class Node{
    	int val;
    	Node next;
    }
	public void push(int x) {
        Node node = new Node();
        node.val=x;
        node.next=head;
        head = node;
        if( x<=min )
        	min = x;
    }

    public void pop() {
    	 if( min ==head.val ){
    	        Node node = head.next;
    	        min =node ==null ? Integer.MAX_VALUE:node.val;
    	        while( node !=null  ){
    	        	if( node.val<=min )
    	        		min = node.val;
    	        	node = node.next;
    	        }
    	 }
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return min;
    }
    
    public static void main(String[] args) {
    	MinStack stack= new MinStack();
    	stack.push(2147483646);
    	stack.push(2147483646);
    	stack.push(2147483647);
    	System.out.println(stack.top());
    	stack.pop();
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.getMin());
    	stack.pop();
    	stack.push(2147483647);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.push(-2147483648);
    	System.out.println(stack.top());
    	System.out.println(stack.getMin());
    	stack.pop();
    	System.out.println(stack.getMin());
    	stack.pop();
	}
}
