package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Graph_ {
//	HashMap<V1, Nbrs of V1 HM <V1 ka nbr, Wt>>
	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph_(int total_V) {
		map = new HashMap<>();
		// TODO Auto-generated constructor stub
		for (int V = 1; V <= total_V; V++) {
			map.put(V, new HashMap<>());
		}
	}

	public void addEdge(int V1, int V2, int wt) {
		HashMap<Integer, Integer> V1_nbr = map.get(V1);
		V1_nbr.put(V2, wt);

		HashMap<Integer, Integer> V2_nbr = map.get(V2);
		V2_nbr.put(V1, wt);

	}

	public boolean isNbr(int V1, int V2) {
		return map.get(V1).containsKey(V2);
	}

	public void removeEdge(int V1, int V2) {
		HashMap<Integer, Integer> V1_nbr = map.get(V1);
		V1_nbr.remove(V2);

		HashMap<Integer, Integer> V2_nbr = map.get(V2);
		V2_nbr.remove(V1);
	}

	public int num_of_Edge() {
		int ans = 0;
		for (int V : map.keySet()) {
			int V_nbrs = map.get(V).size();
			ans = ans + V_nbrs;

		}
		return ans / 2;
	}

	public boolean hasPath(int src, int dest) {

		return hasPath(src, dest, src + "", new HashSet<>());
	}

	private boolean hasPath(int src, int dest, String path, HashSet<Integer> Visited) {
		if (src == dest) {
			System.out.println(path);
			return true;
		}
		Visited.add(src);
		boolean ans = false;
		for (int nbr : map.get(src).keySet()) {
			if (!Visited.contains(nbr)) {
				boolean sp = hasPath(nbr, dest, path + " " + nbr, Visited);
				ans = ans | sp;
			}
		}
		Visited.remove(src);
		return ans;
	}

	public void BFS(int src) {
		Queue<Integer> Q = new LinkedList<>();
		Q.add(src);
		HashSet<Integer> Visited = new HashSet<>();
		while (!Q.isEmpty()) {
			int curr = Q.poll();

			if (Visited.contains(curr)) {
				System.out.println("Cycle hein babu");
				continue;
			}
			Visited.add(curr);
			for (int nbr : map.get(curr).keySet()) {
				if (!Visited.contains(nbr)) {
					Q.add(nbr);
				}
			}
		}
	}

	public void BFT() {

		HashSet<Integer> Visited = new HashSet<>();
		for (int src : map.keySet()) {
			Queue<Integer> Q = new LinkedList<>();
			Q.add(src);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
					System.out.println("Cycle hein babu");
					continue;
				}
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
		}
	}

	public int NumOfComp() {
		int ans = 0;
		HashSet<Integer> Visited = new HashSet<>();
		for (int src : map.keySet()) {
			Queue<Integer> Q = new LinkedList<>();
			Q.add(src);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
					System.out.println("Cycle hein babu");
					continue;
				}
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
			ans++;
		}
		return ans;
	}

	public boolean isCyclic() {
		int ans = 0;
		HashSet<Integer> Visited = new HashSet<>();
		for (int src : map.keySet()) {
			Queue<Integer> Q = new LinkedList<>();
			Q.add(src);
			while (!Q.isEmpty()) {
				int curr = Q.poll();

				if (Visited.contains(curr)) {
//					System.out.println("Cycle hein babu");
//					continue;
					return true;
				}
				Visited.add(curr);
				for (int nbr : map.get(curr).keySet()) {
					if (!Visited.contains(nbr)) {
						Q.add(nbr);
					}
				}
			}
			ans++;
		}
		return false;
	}

	public boolean isTree() {
		return isCyclic() == false && NumOfComp() == 1;
	}
}
