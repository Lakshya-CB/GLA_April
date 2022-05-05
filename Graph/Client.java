package Graph;

public class Client {
	public static void main(String[] args) {
		Graph_ G = new Graph_(7);
		G.addEdge(1, 4, 6);
		G.addEdge(1, 2, 10);
		G.addEdge(2, 3, 2);
		G.addEdge(3, 4, 3);
		G.addEdge(5, 4, 10);
		G.addEdge(5, 6, 9);
		G.addEdge(5, 7, 14);
		G.addEdge(6, 7, 13);
		System.out.println(G.hasPath(1, 7));
//		G.removeEdge(4, 5);
//		System.out.println(G.map);
//		System.out.println(G.num_of_Edge());
//		System.out.println(G.hasPath(1, 7));
//		G.BFT();
//		G.Dijkstra(1);
	}
}
