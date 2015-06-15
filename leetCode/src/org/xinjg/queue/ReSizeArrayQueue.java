package org.xinjg.queue;

import java.util.NoSuchElementException;

/**
 * FIFO First In First Out
 * @author xinjg
 *
 */
public class ReSizeArrayQueue<Item> {
	private Item[] q;
	private int head;//Index of the first element
	private int tail;//Index after the last element  
	private int size;//element added in the queue
	
	@SuppressWarnings("unchecked")
	public ReSizeArrayQueue(){
		q=(Item[]) new Object[10];
		head=0;
		tail=0;
	}
	
	@SuppressWarnings("unchecked")
	public ReSizeArrayQueue(int capcity){
		q=(Item[]) new Object[capcity];
		head=0;
		tail=0;
	}
	public void enqueue(Item item){
		if (tail==q.length-1) {
			resizeArray(size()*2);
		}
		q[tail++]=item;
		size++;
	}
	
	public Item dequeue() throws NoSuchElementException{
		Item item=null;
		if (!isEmpty()) {
			item=q[head++];
			if (size==q.length/4) {
				resizeArray(size()*2);
			}
			size--;
		}else {
			throw new NoSuchElementException();
		}
		return item;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	private void resizeArray(int capcity){
		@SuppressWarnings("unchecked")
		Item[] newq=(Item[]) new Object[capcity];
		for (int i = head; i <tail; i++) {
			newq[i-head]=q[i];
		}
		q=newq;
		head=0;
		tail=size;
		newq=null;
	}
	
	public static void main(String[] args) throws NoSuchElementException {
		ReSizeArrayQueue<Integer> queue =new ReSizeArrayQueue<Integer>(2);
		System.out.println(queue.isEmpty());
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.size());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println("queue size :"+queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue.dequeue());
		System.out.println(queue.isEmpty());
	}
}
