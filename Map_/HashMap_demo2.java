package Map_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMap_demo2 {
	public static void main(String[] args) {
//				<Key, Value>
		HashMap<String, Integer> map = new HashMap<>();
		map.put("Pappu", 50);  // O(1)
		map.put("Shetaan", 100);
		map.put("Neeraj",0);
		map.put("NB",20);
		map.put("LA",10);
		map.put("FF",10);
		
		System.out.println(map);
		
		System.out.println(map.get("Neeraj")); // O(1)
		map.put("Neeraj",-10);
		System.out.println(map.get("Neeraj")); // O(1)
		
		
		Set<String> Keys = map.keySet();
		for(String Key : Keys) {
			System.out.println(Key);
		}
		
		
		ArrayList<String> AL_Keys = new ArrayList<>(Keys);
		System.out.println("//////////////");
		for(String Key : AL_Keys) {
			System.out.println(Key);
		}

		System.out.println("///////////");
		int[] arr = {10,20,30,40,50,67};

		for(int ali : arr) {
			ali = 99;
//			System.out.println(ali);
		}
		for(int ali : arr) {
//			ali = 99;
			System.out.println(ali);
		}
		
		System.out.println(map.size());
	}

}
