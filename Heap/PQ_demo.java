package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class PQ_demo {
	public static void main(String[] args) {
//		PriorityQueue<Integer> PQ = new PriorityQueue<>();// min heap
		PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());// max heap
		
		
		PQ.add(100);
		PQ.add(10);
		PQ.add(200);
		PQ.add(5);

		System.out.println(PQ);
		PQ.add(-200);

		System.out.println(PQ);
	
	}
}
