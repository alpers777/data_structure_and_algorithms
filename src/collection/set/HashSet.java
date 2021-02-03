package collection.set;

import hash.HashWithSeparateChaining;

public class HashSet<E> extends Set<E> {
	
	private HashWithSeparateChaining<E> hashTable = new HashWithSeparateChaining<>();

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
