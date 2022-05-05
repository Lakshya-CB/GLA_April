package Graph;

import java.util.HashMap;
import java.util.List;

import Graph.BTree.Node;


public class Distance_K_away {
	public static void main(String[] args) {
		int[] lvl = { 40, 20, 60, 10, 30, 50, 70, -1, -1, 25, -1, -1, 55, -1, -1, 23, -1, 52, -1, -1, -1, -1, -1 };
		BTree BT = new BTree(lvl, true);
//		BT.disp();
		HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
		Convert(BT.root, map);
		System.out.println(map);
		
	}

	public static void Convert(Node root, HashMap<Integer, HashMap<Integer, Integer>> map) {
		if (root == null) {
			return;
		}
		map.put(root.data, new HashMap<>());
		Convert(root.left, map);
		Convert(root.right, map);
		if (root.left != null) {
			map.get(root.data).put(root.left.data, 0);
			map.get(root.left.data).put(root.data, 0);
			
		}
		if (root.right != null) {
			map.get(root.data).put(root.right.data, 0);
			map.get(root.right.data).put(root.data, 0);
			
		}
	}

}
