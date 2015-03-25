package org.xinjg.queue;

import java.util.Arrays;

public class MaxPriorityQueue {
	
	private Integer[] pq;
	private int size;
	public MaxPriorityQueue(int capacity){
		pq=new Integer[capacity];
	}
	
	public void insert(int n){
		pq[++size]=n;
		swim( size );
	}
	
	public int max(){
		return pq[1];
	}
	
	public void delMax(){
		swap(1,size);
		pq[size--]=null;
		sink(1);
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	private void swap(int i,int j){
		int tmp = pq[i];
		pq[i]=pq[j];
		pq[j]=tmp;
	}
	
	/**
	 *  exchange with one's child
	 * @param i
	 */
	private void sink( int i){
		while( pq[2*i] >pq[i] || pq[2*i+1]>pq[i]){
			//exchange with bigger one
			if( pq[2*i] > pq[2*i+1] )
				swap(i,2*i);
			else{ 
				swap(i,2*i+1);
			}
			i=i*2;
		}
	}
	
	/**
	 * exchange with one's parent
	 * @param i
	 */
	private void swim(int i) {
		while( i>1 && pq[i/2] < pq[i] ){
			swap(i,i/2);
			i=i/2;
		}
	}
	
	public String toString(){
		return Arrays.toString(pq);
	}
	
	public static void main(String[] args) {
		MaxPriorityQueue q = new MaxPriorityQueue(10);
		q.insert(10);
		q.insert(2);
		q.insert(3);
		q.insert(12);
		q.insert(5);
		q.insert(20);
		System.out.println( q.toString() );
	}
}
