package Map_;

import java.util.HashMap;

public class Map_QPS {
	public static void main(String[] args) {
//		int[] arr1 = { 10, 20, 30, 10, 20, 10, 40, 20 };
//		int[] arr2 = { 20, 10, 30, 30, 30, 10, 20, 10, 100 };
//		Intersection(arr1, arr2);
		int[] arr1 = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		LongestConsSeq(arr1);
	}

	public static void Intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int ali : arr1) {
			if (map.containsKey(ali)) {
				int prev_freq = map.get(ali);
				map.put(ali, prev_freq + 1);
			} else {
				map.put(ali, 1);
			}
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
		for (int alu : arr) { // alu == 5
			map.put(alu, true);
			if (map.containsKey(alu - 1)) {
				map.put(alu, false);
			}
			if (map.containsKey(alu + 1)) {
				map.put(alu + 1, false);
			}
			System.out.println(map);
		}
		for (int ali : arr) {
			if (map.get(ali)) {
				int start = ali;
				while (map.containsKey(start)) {
					System.out.print(start + " ");
					start++;
				}
				System.out.println();
			}
		}

	}
}
