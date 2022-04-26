package Heap;

public class Heap_client {
	public static void main(String[] args) {
		Heap PQ = new Heap();
		PQ.add(100);
		PQ.add(10);
		PQ.add(200);
		PQ.disp();
		PQ.add(5);
		PQ.disp();
		PQ.add(-200);

		PQ.disp();
//		
		System.out.println(PQ.poll());
		PQ.disp();
		
	}

}
