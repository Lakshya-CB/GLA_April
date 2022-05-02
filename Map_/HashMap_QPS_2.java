package Map_;

import java.util.HashMap;

public class HashMap_QPS_2 {
	public static void main(String[] args) {
//		int[] arr1 = { 10, 20, 30, 10, 20, 10, 40, 20 };
//		int[] arr2 = { 20, 10, 30, 30, 30, 10, 20, 10, 100 };
//		Intersection(arr1, arr2);
		int[] arr1 = { 1, 8, 7, 15, 2, 16, 3, 5, 4 };
		LongestConsSeq(arr1);
	}

	public static void Intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ali : arr1) {
//			if (map.containsKey(ali)) {
//				int prev_freq = map.get(ali);
//				map.put(ali, prev_freq + 1);
//
//			} else {
//				map.put(ali, 1);
//			}
			int prev_freq = map.getOrDefault(ali, 0);
			map.put(ali, prev_freq + 1);
		}

		System.out.println(map);
		for (int ali : arr2) {
			if (map.containsKey(ali) && map.get(ali) > 0) {
				System.out.println(ali);
				int prev_freq = map.get(ali);
				map.put(ali, prev_freq - 1);
			}
		}

	}

	public static void LongestConsSeq(int[] arr) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		for (int ali : arr) {
//			ali==4
			map.put(ali, true);
			if (map.containsKey(ali - 1)) {
				
				map.put(ali, false);
			}
			if (map.containsKey(ali + 1)) {
				map.put(ali + 1, false);
			}
//			System.out.println(map);
		}
		for (int key : map.keySet()) {
			if (map.get(key)) {
				int num = key;
//				System.out.println(key);
				while (map.containsKey(num)) {
					System.out.print(num + " ");
					num++;
				}
				System.out.println();
			}
		}

	}
}
