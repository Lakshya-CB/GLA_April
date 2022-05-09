package Rec_rev;

import java.util.ArrayList;
import java.util.List;

public class Palindrome {
	public static void main(String[] args) {

		List<List<String>> All_AL = new ArrayList<List<String>>();
		partition("nitin", "", new ArrayList<String>(),All_AL);
		System.out.println(All_AL);
	
	}

	public static void partition(String str, String parts, List<String> AL,List<List<String>> All_AL) {
		if (str.length() == 0) {
			System.out.println(parts +" , "+AL);
			All_AL.add(new ArrayList<>(AL));
		}
		for (int len = 1; len <= str.length(); len++) {
			String piece = str.substring(0, len);
			if (isPalin(piece)) {
				String bacca_kucha = str.substring(len);
				AL.add(piece);
				partition(bacca_kucha, parts + piece + " ",AL,All_AL);
				AL.remove(AL.size()-1);
				//			System.out.println(piece + " , " + bacca_kucha);
			}
		}
	}

	private static boolean isPalin(String piece) {
		// TODO Auto-generated method stub
		int s =0;
		int e = piece.length()-1;
		while(s<e) {
			if(piece.charAt(s)!=piece.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}
