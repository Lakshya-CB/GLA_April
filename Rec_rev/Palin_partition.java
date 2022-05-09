package Rec_rev;

import java.util.ArrayList;
import java.util.List;

public class Palin_partition {
	public static void main(String[] args) {
		partition("nittin", "" ,new ArrayList<String>());
	}

	public static void partition(String str, String parts, List<String>AL) {
		if (str.isEmpty()) {
			System.out.println(parts+ " , "+AL);

		}
		for (int len = 1; len <= str.length(); len++) {
			String tukra = str.substring(0, len);
			if (isPalin(tukra)) {
				String remain = str.substring(len);
//			System.out.println(tukra + " ,, "+remain);
				AL.add(tukra);
				partition(remain, 	,AL);
			}
		}
	}

	private static boolean isPalin(String piece) {
		int s = 0;
		int e = piece.length() - 1;
		while (s < e) {
			if (piece.charAt(s) != piece.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}
