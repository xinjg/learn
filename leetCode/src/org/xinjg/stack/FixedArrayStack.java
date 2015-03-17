package org.xinjg.stack;

public class FixedArrayStack implements Stack {
    
	private String[] array;
	private int size =0;
	public FixedArrayStack(int n){
		array = new String[n];
	}
	
	@Override
	public void push(String val) {
		array[size++]=val;
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		return array[--size];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	public static void main(String[] args) {
		Stack stack = new FixedArrayStack(10);
		stack.push("Xin");
		stack.push("Jin");
		stack.push("gang");
		stack.push("is");
		stack.push("SUPER");
		while( !stack.isEmpty() ){
			System.out.println(stack.pop());
		}
	}
}
