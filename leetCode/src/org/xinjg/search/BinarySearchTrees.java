package org.xinjg.search;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTrees<Key extends Comparable<Key>,Value> {
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
		return max(root).key;
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
		return min(root).key;
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
	
	public void deleteMin(){
		root = deleteMin(root);
	}
	
	/*
	 * step 1 go left until reaching null left link;
	 * setp 2 return that node's right link;
	 * step 3 update links and node counts after recursive calls;
	 */
	private Node deleteMin(Node node){
		if (node==null) {
			return null;
		}
		if (node.left==null) {
			return node.right;
		}
	   node.left = deleteMin(node.left);
	   node.cnt=1+size(node.left) + size(node.right);
	   return node;
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
	
	public void delete(Key key){
		root =delete(root, key);
	}
	
	private Node delete(Node node,Key key) {
		if (node==null || key==null) {
			return node;
		}
		int cmp=key.compareTo(node.key);
		if (cmp>0) {
			node.right= delete(node.right, key);
		}else if (cmp<0) {
			node.left=delete(node.left, key);
		}else {
			if (node.left==null) {//with right child only
				return node.right;
			}else if (node.right==null) {//with left child only
				return node.left;
			}else {
				Node t =node;
				node = min(t.right);//t is next to X
				node.right = deleteMin(t.right);
				node.left=t.left;
			}
			
		}//refresh node count
//		System.out.println( "---node info--- "+ node.key +"    " + size(node.right) + "      " + node.left );
		node.cnt = size(node.right)+size(node.left)+1;
		return node;
	}
	
	private Node min(Node node){
		if (node==null) {
			return null;
		}
		Node min = null;
		if (node.left!=null) {
			min = min(node.left);
		}else {
			min =node;
		}
		return min;
	}
	
	private Node max(Node node){
		if (node==null) {
			return null;
		}
		Node max =null;
		if (node.right!=null) {
			max=max(node.right);
		}else {
			max=node;
		}
		return max;
	}
}
