package Map_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMap_demo {
	public static void main(String[] args) {
//				<Key, Value>
		HashMap<String , Integer> map = new HashMap<>();
		
//		map.put(Key, Value);
		map.put("Pappu", 51); // O(1)
		map.put("Ajit",-27);
		map.put("Abhishek", 0);
		map.put("AB", 10);
		map.put("BA", 2);
		map.put("LL", 15);
		map.put("GH", 17);

		System.out.println(map);
		System.out.println(map.get("Pappu"));
	

		map.put("Pappu", -1); // O(1)
		System.out.println(map.get("Pappu"));
		
//Key?!
		Set<String> Keys = map.keySet();
		ArrayList<String> Keys_AL = new ArrayList<>(Keys);
		System.out.println(Keys);
		System.out.println(Keys_AL);
		for(String Key  : Keys_AL) {
			System.out.println(Key);
		}
		for(String Key  : Keys) {
			System.out.println(Key);
		}
		int[] arr = {1,2,4,5,7,88,100};
		for(int val  : arr) {
			val=10;
		}
		for(int val  : arr) {
			
			System.out.println(val);
		}
		System.out.println(map.size());
		System.out.println(map.containsKey("Lakshya"));
	}

}
