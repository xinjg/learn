package org.xinjg.string;

public class StringTST<Item> {
	private Node root;
	private class Node{
		char index;
		Item item;
		Node left;
		Node right;
		Node next;
	}
	
	public void put(String key,Item item){
		root=put(root,key,0,item);
	}
	
	private Node put( Node node,String key,int d,Item item ){
		if (node==null) {
			node = new Node();
			node.index=key.charAt(d);
		}
		if (node.index<key.charAt(d)) {
			node.left=put(node.left, key, d, item);
		}else if (node.index>key.charAt(d)) {
			node.right=put(node.right, key, d, item);
		}else{
			if (d==key.length()-1) {
				node.item=item;
			}else {
				node.next=put(node.next, key, d+1, item);
			}
		}
		return node;
	}
	
	public Item get(String key){
		Node node=get(root, key, 0);
		if (node!=null) {
			return node.item;
		}
		return null;
	}
	
	private Node get( Node node,String key,int d ){
		if (node==null) {
			return null;
		}
		if (node.index<key.charAt(d)) {
			return get(node.left, key, d);
		}else if (node.index>key.charAt(d)) {
			return get(node.right, key, d);
		}else{
			if (d==key.length()-1) {
				return node;
			}else {
				return get(node.next, key, d+1);
			}
		}
	}
	
	public boolean contains(String key){
		return get(key)!=null;
	}
	
	public static void main(String[] args) {
		StringTST<Integer> tst= new StringTST<>();
		tst.put("a", 1);
		tst.put("b", 2);
		tst.put("c", 3);
		tst.put("ac", 4);
		System.out.println(tst.get("a"));
		System.out.println(tst.get("b"));
		System.out.println(tst.get("c"));
		System.out.println(tst.get("ac"));
	}
}
