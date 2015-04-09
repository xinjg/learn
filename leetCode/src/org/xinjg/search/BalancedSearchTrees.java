package org.xinjg.search;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 
 * @author Administrator
 * Left-leaning Red-black tree
 * @param <Key>
 * @param <Value>
 */
public class BalancedSearchTrees<Key extends Comparable<Key>,Value> {
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private class Node{
		Key key;
		Value value;
		Node left,right;
		int cnt;//subtree node count 
		boolean color ;//color of parent link
		Node(Key key,Value value){
			this.key = key;
			this.value=value;
			//set default link red
			this.color=RED;
		}
	}
	
	private Node root;
	
	/*
	 * Left rotation : Orient a ( temporarily ) right-learning red link to learn left
	 */
	private Node rotateLeft(Node node){
		if (isRed(node)) {
			return node;
		}
		Node right = node.right;
		node.right = right.left;
		right.left = node;
		right.color =node.color;
		node.color=RED;
		//update subtree count
		right.cnt=node.cnt;
		node.cnt=1+size(node.right)+size(node.left);
		return right;
	}
	
	/*
	 * Right rotation. Orient a left-leaning red link to(temporarily) lean right
	 */
	private Node rotateRight(Node node){
		Node left=node.left;
		node.left=left.right;
		left.right=node;
		left.color=node.color;
		node.color=RED;
		left.cnt=node.cnt;
		node.cnt = 1+ size(node.right)+size(node.left);
		return left;
	}
	
	private void flipColors(Node node){
		node.color =RED;
		node.left.color=BLACK;
		node.right.color=BLACK;
	}
	
	/*
	 * is the node's parent link red
	 */
	private boolean isRed(Node node){
		return node==null?false:node.color;
	}
	
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
		if (key==null) {
			throw new NullPointerException("can not inset null key in a BSTs");
		}
		if (node==null) {//insert on an empty tree
			return new Node(key, value);
		}
		int cmp = key.compareTo(node.key);
		if (cmp>0) {
			node.right =put(node.right, key, value);
		}else if (cmp<0) {
			node.left = put(node.left, key, value);
		}else {
			node.value=value;
		}
		node.cnt=size(node.right) + size(node.left) + 1;
		if (isRed(node.right)&& !isRed(node.left)) {//right lean
			node = rotateLeft(node);
		}
	if (isRed(node.left)&&isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.left)&&isRed(node.right)) {
			flipColors(node);
		}
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
		deleteMin(root);
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
	
	public void delete(Key key) {
		delete(root, key);
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
			
			if (node.right==null&&node.left==null) {//no child
				return null;
			}else if (node.left==null) {//with right child only
				return node.right;
			}else if (node.right==null) {//with left child only
				return node.left;
			}else {//two children
				Node t =node;
				node = min(node.right);//t is next to X
				node.right = deleteMin(node.right);
				node.left=t.left;
			}
		}//refresh node count
		node.cnt = size(node.right)+size(node.right)+1;
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
