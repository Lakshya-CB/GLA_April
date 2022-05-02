package Map_;

import java.util.ArrayList;

public class HashMap_ {
	class Node {
		public Node(String k, int v) {
			// TODO Auto-generated constructor stub
			Key = k;
			Value = v;
		}

		String Key;
		Integer Value;
		Node next;
	}

	int size = 0;
	ArrayList<Node> buckets;

	public HashMap_() {
		// TODO Auto-generated constructor stub
		buckets = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			buckets.add(null);
		}
	}

	public void put(String K, int V) {
		int bucket_num = hashFn(K);
		Node nn = new Node(K, V);
		Node head = buckets.get(bucket_num);
		nn.next = head;
		buckets.set(bucket_num,nn);
		size++;
		double load_factor = (size *1.0)/buckets.size();
		if(load_factor>2) {
//			rehash!!/
		}
	
				
	}

	public int get(String K) {
		int bucket_num = hashFn(K);
		Node head = buckets.get(bucket_num);
		while (head != null) {
			if (head.Key.equals(K)) {
				return head.Value;
			}
			head = head.next;
		}
		return -1;
	}

	private int hashFn(String k) {
		// TODO Auto-generated method stub
		int l = k.hashCode();
		return l % buckets.size();
	}
}
