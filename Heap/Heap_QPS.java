package Heap;

import java.util.PriorityQueue;

public class Heap_QPS {
	public static void main(String[] args) {
		int[] arr = { 20, 30, 60, 50, 10, 55, 57, 40 };
		Largest_K(arr, 3);
	}

	public static void Largest_K(int[] arr, int k) {
		PriorityQueue<Integer> PQ = new PriorityQueue<>();
		for(int i=0;i<arr.length;i++) {
			PQ.add(arr[i]);
			if(PQ.size()>k) {
				PQ.poll();
			}
		}
				
		System.out.println(PQ);
	}
}
