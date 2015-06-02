package org.xinjg.string;


public class StringST<Item> {
	public StringST(){
		root=new Node();
	}
	Node root;
	private static int R=256;
	private class Node{
		Item item;
		Object[] next ;
		public Node() {
			next= new Object[R];
		}
	}
	
	@SuppressWarnings("unchecked")
	public void put(String key,Item item) {
		Node node =root;
		int i=0;
		
		while( i<key.length() ){
			if ( node.next[key.charAt(i)]==null) {
				 node.next[key.charAt(i)]=new Node();
			} ;
			node=(StringST<Item>.Node) node.next[key.charAt(i)];
			i++;
		}
		node.item=item;
	}
	
	@SuppressWarnings("unchecked")
	public Item get(String key){
		int i=0;
		Node node = root;
		while (node!=null&&i<key.length()) {
			node=(StringST<Item>.Node) node.next[ key.charAt(i) ];
			if (i==key.length()-1) {
				return node==null? null:node.item;
			}
			i++;
		}
		return null;
	}
	
	public boolean contains(String key){
		return this.get(key)!=null;
	}
	
	public static void main(String[] args) {
		StringST<Integer> st= new StringST<Integer>();
		st.put("a", 1);
		st.put("aa", 2);
		st.put("b1a", 3);
		st.put("bcde", 4);
		System.out.println(st.get("cdefgkillllllll"));
		System.out.println(st.get("a"));
		System.out.println(st.get("aa"));
		System.out.println(st.get("b1a"));
		System.out.println(st.get("bcde"));
		System.out.println(st.contains("bcde"));
		System.out.println(st.contains("bcdef"));
	}
}
