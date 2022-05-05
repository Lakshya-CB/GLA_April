package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
//HashMap<V, HashMap<nbr, wt>>
//	int LALU = 9999;
	HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

	public Graph(int total_V) {
		// TODO Auto-generated constructor stub
		map = new HashMap<>();
		for (int V = 1; V <= total_V; V++) {
			map.put(V, new HashMap<>());
		}

	}

	public void addEdge(int V1, int V2, int wt) {
		HashMap<Integer, Integer> V1_nbrs = map.get(V1);
		V1_nbrs.put(V2, wt);
		HashMap<Integer, Integer> V2_nbrs = map.get(V2);
		V2_nbrs.put(V1, wt);
	}

	public void removeEdge(int V1, int V2) {
		HashMap<Integer, Integer> V1_nbrs = map.get(V1);
		V1_nbrs.remove(V2);
		HashMap<Integer, Integer> V2_nbrs = map.get(V2);
		V2_nbrs.remove(V1);
	}

	public boolean containsEdge(int V1, int V2) {
		return map.get(V1).containsKey(V2);
	}

	public int num_of_edge() {
		int ans = 0;
		for (int V1 : map.keySet()) {
			for (int nbr_V1 : map.get(V1).keySet()) {
				ans++;
			}
		}
		return ans / 2;
	}

	public boolean hasPath(int src, int dest) {
		return hasPath(src, dest, src + "", new HashSet<>());
	}

//	DFS
	private boolean hasPath(int src, int dest, String path, HashSet<Integer> Visited) {
		if (src == dest) {
			System.out.println(path);
			return true;
		}
		if (Visited.contains(src)) {
			return false;
		}
		Visited.add(src);
		boolean ans = false;
		for (int nbr : map.get(src).keySet()) {
			boolean sp = hasPath(nbr, dest, path + " " + nbr, Visited);
			ans = ans || sp;
		}
		Visited.remove(src);
		return ans;
	}

	public void BFS(int src, int dest) {
		HashSet<Integer> Visited = new HashSet<>();
		Queue<Integer> Q = new LinkedList<>();
		Q.add(src);
		while (!Q.isEmpty()) {
			int V = Q.poll();

			if (Visited.contains(V)) {
				System.out.println("Cycle hein BABU!!!!!");
			}

			Visited.add(V);
			for (int nbr : map.get(V).keySet()) {
				if (!Visited.contains(nbr)) {
					Q.add(nbr);
				}
			}
		}
	}

//		BFT : Breadth First Traversal 
	public void BFT() {
		HashSet<Integer> Visited = new HashSet<>();
		for (int V : map.keySet()) {
//				BFS!!!!!!
			if (Visited.contains(V)) {
				continue;
			}
			String ans = "";
			Queue<Integer> Q = new LinkedList<>();
			Q.add(V);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
					System.out.println("Cycle hein BABU!!!!!");
					continue;
				}
				ans = ans + " " + curr;
				System.out.println(ans);
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
		}
	}

	public boolean isCycle() {
		HashSet<Integer> Visited = new HashSet<>();
		for (int V : map.keySet()) {
//				BFS!!!!!!
			if (Visited.contains(V)) {
				continue;
			}
			String ans = "";
			Queue<Integer> Q = new LinkedList<>();
			Q.add(V);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
//					System.out.println("Cycle hein BABU!!!!!");
//					continue;
					return true;
				}
//				ans = ans + " " + curr;
//				System.out.println(ans);
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
		}
		return false;
	}

	public int num_Components() {
		int numC = 0;
		HashSet<Integer> Visited = new HashSet<>();
		for (int V : map.keySet()) {
//				BFS!!!!!!
			if (Visited.contains(V)) {
				continue;
			}
			numC++;
			String ans = "";
			Queue<Integer> Q = new LinkedList<>();
			Q.add(V);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
//					System.out.println("Cycle hein BABU!!!!!");
					continue;
				}
				ans = ans + " " + curr;
//				System.out.println(ans);
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
		}
		return numC;
	}

	public boolean isTree() {
		return isCycle() == false && num_Components() == 0;
	}

	class DijPair implements Comparable<DijPair> {
		public DijPair(int src, int i) {
			// TODO Auto-generated constructor stub
			V = src;
			CTR = i;
		}

		int V;
		int CTR = 0;
		public String toString() {
			return this.V + " with cost "+ this.CTR;
		}
		@Override
		public int compareTo(DijPair o) {
			// TODO Auto-generated method stub
			return this.CTR -o.CTR;
		}
	}

	public void Dijkstra(int src) {
		PriorityQueue<DijPair> PQ = new PriorityQueue<>();
		HashSet<Integer> Visited = new HashSet<>();
		PQ.add(new DijPair(src, 0));
		while (!PQ.isEmpty()) {
			DijPair temp = PQ.poll();
			if(Visited.contains(temp.V)) {
				continue;
			}
			System.out.println(temp);
			Visited.add(temp.V);
			for (int nbr : map.get(temp.V).keySet()) {
				if (!Visited.contains(nbr)) {
					int Edge_cost = map.get(temp.V).get(nbr);
					PQ.add(new DijPair(nbr, temp.CTR + Edge_cost));
				}
			}
		}
	}
}
