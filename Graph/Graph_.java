package Graph;

import java.util.HashMap;

public class Graph_ {
//	HashMap<V1, HM <V1 ka nbr, Wt>>
	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph_(int total_V) {
		map = new HashMap<>();
		// TODO Auto-generated constructor stub
		for (int V = 1; V <= total_V; V++) {
			map.put(V, new HashMap<>());
		}
	}
	public void addEdge(int V1, int V2 ,int wt) {
		HashMap<Integer, Integer> V1_nbr = map.get(V1);
		V1_nbr.put(V2, wt);
		
		HashMap<Integer, Integer> V2_nbr = map.get(V2);
		V2_nbr.put(V1, wt);
		
	}
	public boolean isNbr(int V1, int V2) {
		return map.get(V1).containsKey(V2);
	}
	
}
