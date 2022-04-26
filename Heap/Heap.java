package Heap;

import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> AL;

	public Heap() {
		// TODO Auto-generated constructor stub
		AL = new ArrayList<>();
	}

	public int size() {
		return AL.size();

	}

	public boolean isEmpty() {
		return AL.isEmpty();
	}

	public int peek() {
		return AL.get(0);
	}

	public void add(int ali) {
		AL.add(ali);
		Upheapify(AL.size() - 1);

	}

	private void Upheapify(int child) {
		// TODO Auto-generated method stub
		int parent = (child - 1) / 2;
		if (AL.get(parent) > AL.get(child)) {
			swap(child, parent);
			Upheapify(parent);
		}
	}

	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		int temp = AL.get(i);
		AL.set(i, AL.get(j));
		AL.set(j, temp);
	}

	public void disp() {
		System.out.println(AL);

	}

	public int poll() {
		int ans = peek();
		AL.set(0, AL.get(AL.size() - 1));
		AL.remove(AL.size() - 1);
		Downheapify(0);
		return ans;
	}

	private void Downheapify(int p) {
		// TODO Auto-generated method stub
		int c1 = 2 * p + 1;
		int c2 = 2 * p + 2;
		int min_idx = p;
		if (c1 < AL.size() && AL.get(min_idx) > AL.get(c1)) {
			min_idx = c1;
		}
		if (c2 < AL.size() && AL.get(min_idx) > AL.get(c2)) {
			min_idx = c2;
		}
		if (min_idx != p) {
			swap(min_idx, p);
			Downheapify(min_idx);
		}
	}
}
