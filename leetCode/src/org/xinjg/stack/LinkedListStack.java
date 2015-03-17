package org.xinjg.stack;

public class LinkedListStack implements Stack {

	private class Node{
		String value;
		Node next;
	};
	
	private Node firstNode=new Node();
	
	@Override
	public void push(String val) {
		// TODO Auto-generated method stub
		Node oldFirst = this.firstNode; 
		Node node = new Node();
		node.value = val;
		node.next=oldFirst;
		this.firstNode=node;
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		Node oldFirstNode = this.firstNode;
		this.firstNode =oldFirstNode.next ;
		return oldFirstNode.value;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode.value==null;
	}

	public static void main(String[] args) {
		Stack stack = new LinkedListStack();
		stack.push("to");
		stack.push("be");
		stack.push("or");
		stack.push("not");
		while( !stack.isEmpty() )
			System.out.println(stack.pop());
	}
}