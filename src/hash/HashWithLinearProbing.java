package hash;

public class HashWithLinearProbing<E> {
	private static final int DEFAULT_CAPACITY = 16;
	
	// Dummy value to associate with an Object in the backing Map
    private static final Object PRESENT = new Object();

	private E[] hashTable;
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
		while (hashTable[hash] != null && !(hashTable[hash] instanceof Object)) {
			hash = (hash + 1) % size;
		}
		
		if (hashTable[hash] == null)
			size++;
		
		hashTable[hash] = element;
	}

	@SuppressWarnings("unchecked")
	public boolean remove(E element) {
		int index = findIndex(element);
		
		if (index == -1)
			return false;
		
		hashTable[index] = (E) PRESENT;
		
		return false;
	}

	public boolean contains(E element) {
		return findIndex(element) != -1;
	}

	private int findIndex(E element) {
		int index = getHash(element);

		while (!(hashTable[index] == null || hashTable[index].equals(element))) {
			index = (index + 1) % size;
		}

		if (hashTable[index] == null) {
			return -1;
		}
		return index;
	}

	@SuppressWarnings("unchecked")
	public void clear(int capacity) {
		size = 0;
		hashTable = (E[]) new Object[capacity];
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
			E[] oldTable = hashTable;
			hashTable = (E[]) new Object[hashTable.length * 2];
			size = 0;
			for (E e : oldTable) {
				if (e != null && !(e.getClass() == PRESENT.getClass())) {
					add(e);
				}
			}
		}
	}
}
