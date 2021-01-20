package hash;

import collection.list.library.LinkedList;

public class HashSeperatingChanging<E> {
	private static final int DEFAULT_CAPACITY = 16;

	private LinkedList<E>[] hashTable;
	private int size = 0;
	private double loadFactor = 0.75;

	public HashSeperatingChanging() {
		this(DEFAULT_CAPACITY);
	}

	public HashSeperatingChanging(int capacity) {
		clear(capacity);
	}

	public void add(E element) {
		rehashIfNecessary();

		int hash = getHash(element);
		if (hashTable[hash] == null) {
			hashTable[hash] = new LinkedList<>();
		}

		hashTable[hash].addLast(element);
		size++;
	}

	public boolean remove(E element) {
		int hash = getHash(element);
		if (hashTable[hash] == null) {
			return false;
		}
		return hashTable[hash].removeElement(element);
	}

	public boolean contains(E element) {
		int hash = getHash(element);
		if (hashTable[hash] == null) {
			return false;
		}
		
		return hashTable[hash].contains(element);
	}

	@SuppressWarnings("unchecked")
	public void clear(int capacity) {
		size = 0;
		hashTable = new LinkedList[capacity];
	}

	public int getSize() {
		return size;
	}

	private int getHash(E element) {
		return element.hashCode() % hashTable.length;
	}

	@SuppressWarnings("unchecked")
	private void rehashIfNecessary() {
		if ((double) size / hashTable.length >= loadFactor) {
			LinkedList<E>[] oldTable = hashTable;
			hashTable = new LinkedList[hashTable.length * 2];
			size = 0;

			for (LinkedList<E> list : oldTable) {
				if (list != null) {
					for (E e : list) {
						add(e);
					}
				}
			}
		}
	}
}
