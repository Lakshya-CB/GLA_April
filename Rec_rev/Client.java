package Rec_rev;

public class Client {
	public static void main(String[] args) {
//		int[] lvl = { 10, 20, 30, 40, -1, 50, 60, -1, -1, -1, -1, -1, -1 };
//		Tree T = new Tree(lvl);
		int[] pre = { 10, 20, 40, -1, -1, -1, 30, 50, -1, -1, 60, -1, -1 };
		Tree T = new Tree(pre);
		T.Disp();

	}
}
