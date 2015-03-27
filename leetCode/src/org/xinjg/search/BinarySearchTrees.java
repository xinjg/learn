package org.xinjg.search;

public class BinarySearchTrees<Key extends Comparable,Value> {
	private Node root;
	
	public void put(Key key,Value value){
		Node node =root;
		if(node==null){
			
		}
		while( node !=null){
			if(node.key.compareTo(key) <0 ){
				if(node.right!=null)
					node = node.right;
				else{
					Node tmp = new Node(key,value);
					node.right = tmp;
					return;
				}
			}else if( node.key.compareTo(key) >0 ){
				if( node.left!=null )
					node = node.left;
				else{
					Node tmp = new Node(key,value);
					node.left = tmp;
					return;
				}
			}else 
				node.value = value;
		}
	}
	
	public Value get(Key key){
		Node node = root;
		while (node !=null){
			if( node.key.compareTo(key) <0 ){
				node =node.left;
			}else if( node.key.compareTo(key)>0 ){
				node =node.right;
			}
			else return node.value;
		}
		return null;
	}
	
	private class Node{
		Key key;
		Value value;
		Node left,right;
		Node(Key key,Value value){
			this.key = key;
			this.value=value;
		}
	}
	
	
}
