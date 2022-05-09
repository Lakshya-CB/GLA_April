package Rec_rev;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
	class Node {
		public Node(int i) {
			// TODO Auto-generated constructor stub
			data = i;
		}

		int data;
		Node left;
		Node right;
	}

	Node root;

//	public Tree(int[] lvl) {
//
//		Queue<Node> Q = new LinkedList<>();
//		root = new Node(lvl[0]);
//		Q.add(root);
//		int idx = 1;
//		while (!Q.isEmpty()) {
//			Node temp = Q.poll();
//			if (lvl[idx] != -1) {
//				temp.left = new Node(lvl[idx]);
//				Q.add(temp.left);
//			}
//			idx++;
//
//			if (lvl[idx] != -1) {
//				temp.right = new Node(lvl[idx]);
//				Q.add(temp.right);
//			}
//			idx++;
//
//		}
//	}

	public void Disp() {
		Disp(root);
	}

	private void Disp(Node nn) {
		if (nn == null) {
			return;
		}
		String ans = "";
		if (nn.left != null) {
			ans = nn.left.data + "";
		}

		ans = ans + "=>" + nn.data + "<=";
		
		if (nn.right != null) {
			ans = ans + nn.right.data ;
		}
		System.out.println(ans);
		Disp(nn.left);
		Disp(nn.right);

	}

	int idx = 0;

	private Node create(int[] pre) {
		if (pre[idx] == -1) {
			idx++;
			return null;
		}
//		System.out.println(pre[idx]);
		Node nn = new Node(pre[idx]);
		idx++;
		nn.left = create(pre);
		nn.right = create(pre);

		return nn;
	}
	public Tree(int[] pre) {
		// TODO Auto-generated constructor stub
		idx=0;
		root = create(pre);
	}
}
