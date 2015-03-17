package org.xinjg.stack;

public class ResizeArrayStack implements Stack {
	private String[] array =new String[1];
	private int size=0;
	
	private void resize(int newSize){
		String[] oldArray= array;
		array = new String[newSize];
		for( int i=0;i<size ;i++){
			array[i]=oldArray[i];
		}
	}
	@Override
	public void push(String val) {
		// TODO Auto-generated method stub
		if( size ==array.length )
			resize(2*array.length);
		array[size++] = val;
	}

	
	@Override
	public String pop() {
		if( size==array.length/4 )
			resize(array.length/2);
		return array[--size];
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size==0;
	}

	public static void main(String[] args) {
		Stack stack = new ResizeArrayStack();
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
