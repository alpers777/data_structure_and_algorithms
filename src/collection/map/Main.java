package collection.map;

public class Main {

	public static void main(String[] args) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		
		map.put(1, "ali");
		map.put(2, "veli");
		map.put(3, "deli");
		map.put(4, "abc");
		
		System.out.println(map.containsKey(1));

	}

}
