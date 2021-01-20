package hash;

public class Main {

	public static void main(String[] args) {
		Hash<Integer, String> hashTable = new Hash<>();

		hashTable.put(12, "ali");
		hashTable.put(5, "veli");
		hashTable.put(1, "ahmet");
		hashTable.put(9, "mehmet");
		System.out.println(hashTable.containsValue("ali"));
		System.out.println(hashTable.containsKey(1));
		System.out.println(hashTable.remove(12, "ali"));
		System.out.println(hashTable.containsValue("ali"));
		System.out.println(hashTable.containsKey(12));
		System.out.println(hashTable.remove(5, "veli"));

	}

}
