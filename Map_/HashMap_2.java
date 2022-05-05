package Map_;

import java.util.ArrayList;

public class HashMap_2 {
	class Node {
		public Node(String k, Integer v) {
			// TODO Auto-generated constructor stub
			Key = k;
			Val = v;
					
		}
		String Key;
		Integer Val;
		Node next;
	}
	int size =0;

	ArrayList<Node> buckets;

	HashMap_2() {
		size =0;
		buckets = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			buckets.add(null);
		}
	}
	void put(String K, Integer V) {
		int bucket_num = hashFn(K);
		Node head = buckets.get(bucket_num);
		Node nn = new Node(K, V);
		nn.next = head;
		buckets.set(bucket_num, nn);
		size ++;
		double LF = (1.0*size)/buckets.size();
		if(LF>2) {
//			rehash!!!!!!!
			rehash();
		}
	}
	private void rehash() {
		// TODO Auto-generated method stub
		ArrayList<Node>  old = buckets; //10k
		buckets = new ArrayList<>(); // 20k
		for(int i=0;i<buckets.size()*2;i++){
			buckets.add(null);
		}
		
		for(Node head : old) {
			Node temp = head;
			while(temp!=null) {
				put(temp.Key, temp.Val);
				temp = temp.next;
			}
		}
		
		
	}
	
	
	
	
	boolean ContainsKey(String K) {
		int bucket_num = hashFn(K);
		Node temp = buckets.get(bucket_num);
		while(temp!=null) {
			if(temp.Key.equals(K)) {
				return true;
			}
			temp=temp.next;
		}
		return false;
	}
	
	private int hashFn(String k) {
		int out = k.hashCode();
		
		// TODO Auto-generated method stub
		return out%buckets.size();
	}
}
