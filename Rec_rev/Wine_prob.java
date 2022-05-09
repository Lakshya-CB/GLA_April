package Rec_rev;

public class Wine_prob {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 1, 4 };
		System.out.println(MaxPro(arr, 0, arr.length - 1));
		System.out.println(MaxProBU(arr));
	}

	public static int MaxPro(int[] bottle, int s, int e) {
		if (s > e) {
			return 0;
		}
		int day = bottle.length - (e - s);
		int sp1 = bottle[s] * day + MaxPro(bottle, s + 1, e);
		int sp2 = bottle[e] * day + MaxPro(bottle, s, e - 1);
		return Math.max(sp1, sp2);

	}

	public static int MaxProTD(int[] bottle, int s, int e, Integer[][] dp) {
		if (s > e) {
			return 0;
		}
		if (dp[s][e] != null) {
			return dp[s][e];
		}

		int day = bottle.length - (e - s);
		int sp1 = bottle[s] * day + MaxProTD(bottle, s + 1, e, dp);
		int sp2 = bottle[e] * day + MaxProTD(bottle, s, e - 1, dp);
		dp[s][e] = Math.max(sp1, sp2);

		return Math.max(sp1, sp2);

	}

	public static int MaxProBU(int[] bottle) {
		int dp[][] = new int[bottle.length+1][bottle.length];
		for (int s = bottle.length - 1; s >= 0; s--) {
			for (int e = 0; e < bottle.length; e++) {
//				calculate (s,e)
				if (s > e) {
					dp[s][e] = 0;
					continue;
				}

				int day = bottle.length - (e - s);
				int sp1 = bottle[s] * day + dp[s + 1][e];
				int sp2 = 0;
				if(e!=0) {
					sp2 = bottle[e] * day + dp[s][e - 1];
				}
				dp[s][e] = Math.max(sp1, sp2);
			}
		}
		return dp[0][bottle.length-1];
	}
}
