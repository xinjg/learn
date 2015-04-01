package org.xinjg.search;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

import javax.xml.soap.Node;

public class BinarySearchTrees<Key extends Comparable,Value> {
	private Node root;
	
	public void put(Key key,Value value){
		root =put( root,key,value );
	}
	
	public Value get(Key key){
		Node node = root;
		while (node !=null){
			if( node.key.compareTo(key) <0 ){
				node =node.right;
			}else if( node.key.compareTo(key)>0 ){
				node =node.left;
			}
			else return node.value;
		}
		return null;
	}
	
	public boolean isEmpty(){
		return root==null;
	}
	
	public Key getMax(){
		Node node = root;
		Key max=null;
		while( node!=null ){
			max=node.key;
			node = node.right;
		}
		return max;
	}
	
	/**
	 * 
	 *  author : xinjg
	 *	TODO : Largest Key in the BST which <= key	
	 *	@param key
	 *	@return
	 */
	public Key getFloor(Key key){
		Node node = floor(root, key);
		if( node!=null )
			return node.key;
		else {
			return null;
		}
	}
	
	/*
	 * case 1. [ k equals the key at root ] the floor of k is k
	 * case 2. [ k is less than the key at root ] the floor of k is in the left subtree
	 * case 3. [ k is greater than the key at root ] the floor of k is in the right 
	 * subtree( if there any key <=k in the subtree );otherwiise it is the key in the root.
	 */
	private Node floor( Node node,Key key ){
		if (key==null|| node==null) {
			return null;
		}
		int cmp = key.compareTo( node.key );
		Node floorRight =null;
		if (cmp<0) {//case 2
			return  floor(node.left , key);
		}else if (cmp >0) {//case  3
			floorRight = floor(node.right , key);
			return floorRight ==null ? node :floorRight;
		}else {//case 1
			return node;
		}
	}
	
	/**
	 * 	
	 *  author : xinjg
	 *	TODO	:	Smallest key in the BST which >= key
	 *	@param key
	 *	@return
	 */
	public Key getCeil(Key key){
		Node node = ceil(root, key);
		return node==null?null:node.key;
	}
	
	/*	Smallest key in the BST which >= k
	 * case 1. [ k equals the key at root ] the ceil of k is k
	 * case 2. [ k is greater than the key at root ] the ceil of k is in the right subtree
	 * case 3. [ k is less than the key at root ] the ceil of k is in the left 
	 * subtree( if there any key <=k in the subtree );otherwiise it is the key in the root.
	 */
	private Node ceil(Node node,Key key) {
		if (key==null||node==null) {
			return null;
		}
		int cmp = key.compareTo(node.key);
		if (cmp==0) {//case 1
			return node;
		}
		if (cmp>0) {//case 2
			return ceil(node.right, key);
		}
	
		Node ceilLeft = ceil(node.left, key);
		return ceilLeft==null? node:ceilLeft;
		
	}
	
	public Key getMin(){
		Node node = root;
		Key min=null;
		while( node!=null ){
			min=node.key;
			node = node.left;
		}
		return min;
	}
	
	private  Node put( Node node,Key key,Value value ){
		if(node==null){
			node= new Node( key,value ) ;
			node.cnt=size(node.right) + size(node.left) + 1;
			return node;
		}
		int comp = node.key.compareTo(key);
		if( comp <0 )
			node.right =put( node.right,key,value );
		else if( comp >0  )
			node.left =put( node.left,key,value );
		else
			node.value=value;
		node.cnt=size(node.right) + size(node.left) + 1;
		return node;
	}
	
	/**
	 * 
	 *  author : xinjg
	 *	TODO	: Node count of the BST	
	 *	@return
	 */
	public int size(){
		return size(root);
	}
	
	/*
	 * OK to call size when node is null 
	 */
	private int size(Node node){
		return node!=null?node.cnt:0;
	}
	
	/**
	 * 
	 *  author : xinjg
	 *	TODO	: how many nodes <key
	 *	@param key
	 *	@return
	 */
	public int rank(Key key){
		return rank(root,key);
	}
	
	/*
	 * how many nodes <key?	
	 * 3 Cases:
	 * case 1: key equals node.key, the count is size( node.left );
	 * case 2: key is smaller than node.key,the count is size(node.left)+1 + rank(node.right,key);
	 * case 3: key is greater than node.key,the count is size(node.left)+1 + rank(node.right,key)+ rank( node.left,key )
	 */
	private int rank( Node node,Key key){
		if (key==null || node==null) {
			return 0;
		}
		int cmp = key.compareTo(node.key);
		if (cmp==0) {
			return size( node.left );
		}else if (cmp<0) {
			return size(node.left)+1 + rank(node.right,key);
		}else {
			return size(node.left)+1 + rank(node.right,key)+ rank( node.left,key );
		}
	}
	
	/**
	 * 
	 *  author : xinjg
	 *	TODO	: Inorder traversal	
	 *	@return
	 */
	public Iterable<Key> keys() {
		Queue<Key> queue = new LinkedList<Key>();
		inorder(root, queue);
		return queue;
	}
	
	private void inorder(Node node , Queue<Key> queue) {
		if (node==null) {
			return;
		}
		inorder(node.left, queue);
		queue.offer(node.key);
		inorder(node.right, queue);
		return;
	}
	
	private class Node{
		Key key;
		Value value;
		Node left,right;
		int cnt;//
		Node(Key key,Value value){
			this.key = key;
			this.value=value;
		}
	}
	
}
