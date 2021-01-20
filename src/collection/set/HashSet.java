package collection.set;

import hash.HashSeperatingChanging;

public class HashSet<E> extends Set<E> {
	
	private HashSeperatingChanging<E> hashTable = new HashSeperatingChanging<>();

	// O(1)
	@Override
	public boolean add(E element) {
		if (hashTable.contains(element))
			return false;
		
		hashTable.add(element);
		return true;
	}

	// O(1)
	@Override
	public boolean remove(E element) {
		return hashTable.remove(element);
	}

	// O(1)
	@Override
	public boolean contains(E element) {
		return hashTable.contains(element);
	}

}
