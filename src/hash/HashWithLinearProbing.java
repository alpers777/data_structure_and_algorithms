package hash;

import collection.list.library.ArrayList;

public class HashWithLinearProbing<E> {
	private static final int DEFAULT_CAPACITY = 16;

	private ArrayList<E> hashTable;
	private int size = 0;
	private double loadFactor = 0.75;

	public HashWithLinearProbing() {
		this(DEFAULT_CAPACITY);
	}

	public HashWithLinearProbing(int capacity) {
		clear(capacity);
	}

	public void add(E element) {
		rehashIfNecessary();

		int hash = getHash(element);
		while (hashTable.get(hash) != null) {
			hash++;
			if (hash > size - 1) {
				hash = 0;
			}
		}
		hashTable.set(hash, element);
		size++;
	}

	public boolean remove(E element) {
		if (hashTable.contains(element)) {
			return hashTable.removeElement(element);
		}
		return false;
	}

	public boolean contains(E element) {
		int hash = getHash(element);

		if (hashTable.get(hash) == null) {
			return false;
		}
		int acc = 0;
		while (hashTable.get(hash) != element && acc > (hashTable.getLength() / loadFactor)) {
			hash++;
			acc++;
			if (hash > size - 1) {
				hash = 0;
			}
		}
		if (hashTable.get(hash) == element) {
			return true;
		}
		return false;
	}

	public void clear(int capacity) {
		size = 0;
		hashTable = new ArrayList<E>(capacity);
	}

	public int getSize() {
		return size;
	}

	private int getHash(E element) {
		return element.hashCode() % hashTable.getLength();
	}

	private void rehashIfNecessary() {
		if ((double) size / hashTable.getLength() >= loadFactor) {
			ArrayList<E> oldTable = hashTable;
			hashTable = new ArrayList<E>(hashTable.getLength() * 2);
			size = 0;
			for (E e : oldTable) {
				if (e != null) {
					add(e);
				}
			}
		}
	}
}
